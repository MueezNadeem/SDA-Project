package com.example.sda_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class SignInPage extends AppCompatActivity {
    EditText t1;
    EditText t2;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDB= new DatabaseHelper(SignInPage.this);
        try {
            myDB.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myDB.openDataBase();
        setContentView(R.layout.signinpage);
        t1=(EditText) findViewById(R.id.UName);
        t2=(EditText) findViewById(R.id.PWord);
    }


    public void sendmsg(View view){
//<<<<<<< Updated upstream
//        boolean ans=myDB.CheckUserName(t1.getText().toString(),t2.getText().toString());
//        TextView a=(TextView) findViewById(R.id.Results);
//        String abc=new Boolean(ans).toString();
//        a.setText(abc);
//=======
//        boolean ans=myDB.CheckUserName(t1.getText().toString(),t2.getText().toString());
//        TextView a=(TextView) findViewById(R.id.Results);
//        String abc=Boolean.valueOf(ans).toString();
//        a.setText(abc);
        LoginManager LM=new LoginManager();
        if (LM.VerifyCredentials(t2.getText().toString(),t1.getText().toString())==true){
            AccountType UserType=LM.getTypeUser(t1.getText().toString());

            if (UserType==AccountType.Consumer){
                Patient CurrentUser=LM.GetPatient(t1.getText().toString());
                Intent PatientMenu=new Intent(this,Patient_Homepage.class);
                PatientMenu.putExtra("PatientClass",CurrentUser);
                startActivity(PatientMenu);
            }else if (UserType==AccountType.Employee) {
                EmployeeType EmpType= LM.getEmpType(t1.getText().toString());
                switch (EmpType){
                    case Admin: Admin CurrentAdmin=LM.GetAdmin(t1.getText().toString());
                        Intent AdminMenu=new Intent(this,ManagerHomePage.class);
                        AdminMenu.putExtra("AdminClass",CurrentAdmin);
                        break;
                    case Driver:Driver CurrentDriver=LM.GetDriver(t1.getText().toString());
                        Intent DriverMenu=new Intent(this,DriverWorkerHomepage.class);
                        DriverMenu.putExtra("DriverClass",CurrentDriver);
                        break;
                    case Worker:Worker CurrentWorker=LM.GetWorker(t1.getText().toString());
                        Intent WorkerMenu=new Intent(this,DriverWorkerHomepage.class);
                        WorkerMenu.putExtra("WorkerClass",CurrentWorker);
                        break;
                    case Manager: Manager CurrentManager=LM.GetManager(t1.getText().toString());
                        Intent ManagerMenu=new Intent(this,ManagerHomePage.class);
                        ManagerMenu.putExtra("ManagerClass",CurrentManager);
                        break;
                    case Dispatcher:Dispatcher CurrentDispatcher=LM.GetDispatcher(t1.getText().toString());
                        Intent DispatcherMenu=new Intent(this,DispatcherHomePage.class);
                        DispatcherMenu.putExtra("DispatcherClass",CurrentDispatcher);
                        break;
                }
            }
        }else {
            Toast ErrMsg=Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT);
            ErrMsg.show();

        }

    }


}