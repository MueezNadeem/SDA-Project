package com.example.sda_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinpage);
    }

    public void sendmsg(View view){
        Intent i=new Intent(getApplicationContext(), RegisterPage.class);
        startActivity(i);

    }
}