package com.example.green_house_dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {

    DatabaseReference reff;
    ArcProgress arctempvalue;
    DonutProgress donutHumvalue ;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        donutHumvalue=findViewById(R.id.donutprogress) ;
        arctempvalue=findViewById(R.id.arcprogress) ;
        btn=(Button)findViewById(R.id.btnmore) ;

        reff = FirebaseDatabase.getInstance().getReference().child("DATA").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v1= snapshot.child("temperature").getValue().toString();
                String v2= snapshot.child("humidity").getValue().toString();

                arctempvalue.setProgress(Integer.parseInt(v1)) ;
                donutHumvalue.setProgress(Integer.parseInt(v2));

                Intent j = new Intent(MainActivity2.this,MainActivity4Courbe.class) ;
                j.putExtra("temp",Integer.parseInt(v1)) ;
                j.putExtra("hum",Integer.parseInt(v2)) ;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(MainActivity2.this,MainActivity4Courbe.class) ;
            startActivity(i);
        }
    });
    }


}