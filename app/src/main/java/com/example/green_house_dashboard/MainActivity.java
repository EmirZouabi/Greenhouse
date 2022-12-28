package com.example.green_house_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtemail , edtpassword;
    Button btnlogin, btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"Firebase connection succées",Toast.LENGTH_LONG).show();

        edtemail = (EditText) findViewById(R.id.edt_email);
        edtpassword = (EditText) findViewById(R.id.edt_password);
        btnlogin = (Button) findViewById(R.id.btn_login);
        btnsignup = (Button) findViewById(R.id.btn_signup);

        Intent i1 = new Intent(MainActivity.this,MainActivity2.class);
        Intent i2 = new Intent(MainActivity.this,MainActivity3.class);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i1);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i2);
            }
        });




    }
}