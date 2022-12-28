package com.example.green_house_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    EditText edtfirstname , edtlastname , edtemail , edtpassword ,edtpassword2 ;
    Button btn_signinact3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        edtfirstname = (EditText) findViewById(R.id.edtfirstname);
        edtlastname = (EditText) findViewById(R.id.edtlastname);
        edtemail = (EditText) findViewById(R.id.edt_email);
        edtpassword = (EditText) findViewById(R.id.edtsignpassword);
        edtpassword2 = (EditText) findViewById(R.id.edtsignpassword2);
        btn_signinact3 = (Button) findViewById(R.id.signupact3);



        btn_signinact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}