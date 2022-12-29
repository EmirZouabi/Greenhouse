package com.example.green_house_dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity4Courbe extends AppCompatActivity {
LineChart mplinechart ;
int x1,x2;
String  t;
int k;
LineDataSet lineDataSet = new LineDataSet(null,null);
ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
LineData lineData;
FirebaseDatabase firebaseDatabase;
Button b ;
DatabaseReference myref ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_courbe);
        b=(Button) findViewById(R.id.clickbtn) ;
        firebaseDatabase=FirebaseDatabase.getInstance();
        myref=firebaseDatabase.getReference("DATA");

        mplinechart=(LineChart) findViewById(R.id.linechart) ;


        LineDataSet lineDataSet=new LineDataSet(dataValuestemp(),"data set 1") ;
        LineDataSet lineDataSet1=new LineDataSet(dataValueshum(),"data set 2") ;
        ArrayList<ILineDataSet> dataSets=new ArrayList<>() ;
        dataSets.add(lineDataSet) ;
        dataSets.add(lineDataSet1);
        LineData data=new LineData(dataSets);
        mplinechart.setData(data);
        mplinechart.invalidate();
        t = getTodayDate();
        int k = Integer.parseInt(t);
        Intent i=getIntent() ;
        x1 = i.getIntExtra("temp",0);
        x2 = i.getIntExtra("hum",0);
        retrieveData();
    }


private ArrayList<Entry> dataValuestemp() {
        ArrayList<Entry> dataVals=new ArrayList<Entry>() ;
        dataVals.add(new Entry(x1,k));
        return dataVals;
}


    private ArrayList<Entry> dataValueshum() {
        ArrayList<Entry> dataVals=new ArrayList<Entry>() ;
        dataVals.add(new Entry(x2,k));
        return dataVals;
    }
    private String getTodayDate() {
        return new SimpleDateFormat("ddmmyyyy", Locale.getDefault()).format(new Date()) ;
    }

    private void retrieveData(){
    myref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            ArrayList<Entry> dataVals = new ArrayList<Entry>();
            if (snapshot.hasChildren()) {
                for (DataSnapshot MyDatasnapshot : snapshot.getChildren()) {
                    DataPoint dataPoint = MyDatasnapshot.getValue(DataPoint.class);
                    dataVals.add(new Entry(dataPoint.getX(), dataPoint.getY()));
                }
                showChart(dataVals);}
                else {
                    mplinechart.clear();
                    mplinechart.invalidate();
                }
        }
        @Override
        public void onCancelled(@NonNull DatabaseError error) {
        }
    });
    }
private void showChart(ArrayList<Entry> dataVals){
        lineDataSet.setValues(dataVals);
        lineDataSet.setLabel("DataSet 1 ");
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData = new LineData(iLineDataSets);
        mplinechart.clear();
        mplinechart.setData(lineData);
        mplinechart.invalidate();
}

}

