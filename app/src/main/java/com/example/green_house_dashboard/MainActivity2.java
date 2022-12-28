package com.example.green_house_dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    TextView temp , humidity;
    DatabaseReference reff;
    ArcProgress arcProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        temp = (TextView) findViewById(R.id.temperature);
        humidity = (TextView) findViewById(R.id.Humidity);
       arcProgress = (ArcProgress) findViewById(R.id.xd);


     


        reff = FirebaseDatabase.getInstance().getReference().child("DATA").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v1= snapshot.child("temperature").getValue().toString();
                String v2= snapshot.child("humidity").getValue().toString();
                temp.setText(v1);
                humidity.setText(v2);
                arcProgress.setProgress(Integer.parseInt(v1));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}