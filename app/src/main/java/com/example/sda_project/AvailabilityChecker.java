package com.example.sda_project;

public class AvailabilityChecker {
    private DatabaseClass myC=new DatabaseClass();
    private DatabaseHelper DB =myC.getInstance();

    public boolean CheckAvailability(String DriverID,String AmbulanceID){
       return DB.CheckDriverAndAmbulance(DriverID,AmbulanceID);
    }


}
