package com.example.sda_project;

public class LoginManager {
    private DatabaseClass myC=new DatabaseClass();
    private DatabaseHelper DB =myC.getInstance();

    public boolean VerifyCredentials(String Password,String Username){
       return DB.CheckUserName(Username,Password);
    }

}
