package com.example.sda_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class SignInPage extends AppCompatActivity {
    EditText t1;
    EditText t2;
    DatabaseHelper myDB;
    DatabaseClass myC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myC=new DatabaseClass(this);
        //
       //   myDB= new DatabaseHelper(SignInPage.this);
//        try {
//            myDB.createDataBase();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        myDB.openDataBase();
        setContentView(R.layout.signinpage);
        t1=(EditText) findViewById(R.id.UName);
        t2=(EditText) findViewById(R.id.PWord);
    }


    public void sendmsg(View view){
//        boolean ans=myDB.CheckUserName(t1.getText().toString(),t2.getText().toString());
//        TextView a=(TextView) findViewById(R.id.Results);
//        String abc=Boolean.valueOf(ans).toString();
//        a.setText(abc);
        LoginManager LM=new LoginManager();
        LM.VerifyCredentials(t2.getText().toString(),t1.getText().toString());

    }


}