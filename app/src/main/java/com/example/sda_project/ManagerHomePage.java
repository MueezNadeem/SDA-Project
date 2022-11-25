package com.example.sda_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ManagerHomePage extends AppCompatActivity {
    private Manager CurrentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CurrentManager=(Manager) getIntent().getSerializableExtra("ManagerClass");
        TextView WelcomeMsg=(TextView)findViewById(R.id.MgrWelcome);
        WelcomeMsg.setText(String.format("Welcome%s", CurrentManager.getName()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home_page);
    }
    public void ExitApp(View view){
        finish();
        System.exit(0);
    }

    public  void AddAmbulanceActivity(View view){
        Intent i=new Intent(this,ManagerAddAmbulance.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

    public  void DelAmbulanceActivity(View view){
        Intent i=new Intent(this,ManagerRemoveAmbulance.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

    public  void AddEmployeeActivity(View view){
        Intent i=new Intent(this,ManagerAddEmployee.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

    public  void DelEmployeeActivity(View view){
        Intent i=new Intent(this,ManagerDeleteEmployee.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

    public  void EditEmployeeActivity(View view){
        Intent i=new Intent(this,ManagerEditEmployee.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

    public  void ViewAmbulanceActivity(View view){
        Intent i=new Intent(this,ManagerViewAmbulance.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

    public  void ViewTasksActivity(View view){
        Intent i=new Intent(this,ManagerViewTasks.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

    public  void VerifyTasksActivity(View view){
        Intent i=new Intent(this,ManagerVerifyTask.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

    public  void ManageAmbulanceActivity(View view){
        Intent i=new Intent(this,ManagerManageAmbulance.class);
        i.putExtra("PatientClass",CurrentManager);
        startActivity(i);
    }

}