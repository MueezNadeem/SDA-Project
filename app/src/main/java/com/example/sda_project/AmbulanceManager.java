package com.example.sda_project;

public class AmbulanceManager {
    private DatabaseClass myC=new DatabaseClass();
    private DatabaseHelper DB =myC.getInstance();

    public boolean CheckAmbulanceExistence(String AmbulanceID)
    {
        return true;
            //Todo: add Code
    }
    public void SetStatus(String AmbulanceID,AmbulanceStatus _status){
        //Todo: add queries

    }

}
