package com.example.sda_project;

import android.location.Location;
import android.location.LocationManager;

import java.util.regex.Pattern;

public class AccountRegisterer {

    private DatabaseClass myC=new DatabaseClass();
    private DatabaseHelper DB =myC.getInstance();

    public boolean ValidateCode(){
        return true;
    }

    public boolean CreateAccount(User PatientAcc){
        //   int Max=DB.getMaxAccID(); //ToDo : write query and code
        // PatientAcc.SetAccID(Max);
        PatientAcc.SetAccType("C");
        return true;
    }

    public void AddPatientToDB(User PatientAcc){
        //     DB.AddPatient(PatientAcc); //ToDo: write query and code
        //   DB.AddUser(PatientAcc);
    }

    public void PromptCode(String VerificationCode){

    }
}
