package com.example.sda_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Patient_Order extends AppCompatActivity {
    private LocationHandler LH;
    private Patient CurrentPatient;
    private DatabaseClass myC=new DatabaseClass();
    private DatabaseHelper DB =myC.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_order);
        LH=new LocationHandler();
        CurrentPatient=(Patient) getIntent().getSerializableExtra("PatientClass");
    }

    public void PutLocation(){
        TextView LocBox=(TextView) findViewById(R.id.LocationBox);
        String CurrLocation=LH.getLoc(this);
        LocBox.setText(CurrLocation);
    }

    public void AddTask(){
        Task NewTask=new Task();
        NewTask.setOrderPatient(CurrentPatient);
        DB.AddPatientTask(NewTask);
    }
}