package com.example.syedaramshamohsin.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

      EditText e1,e2;
      Button b1;
TextView text1,text2;
      Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new Database(this);
        e1 = (EditText)findViewById(R.id.Email);
        e2 = (EditText)findViewById(R.id.pass);
        b1 = (Button)findViewById(R.id.login);
        text1 = findViewById(R.id.textView);
        text2=findViewById(R.id.exitt);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(login.this,MainActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean chkemailpass = db.emailpassword(email,password);
                if (chkemailpass == true)
                { Toast.makeText(getApplicationContext(),"successfully login",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this,successfullogin.class);
                startActivity(intent);}
                else
                { Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
            }}
        });
    }
}
