package com.example.sda_project;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


public class DatabaseHelper extends SQLiteOpenHelper {

    String DB_PATH = null;
    private static String DB_NAME = "ProjectDB";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }


    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }
    public boolean CheckUserName(String Uname,String Pword){
        String command="Select UserName,Password from User where Username= '"+Uname+"' AND Password ='"+Pword+"'";

        Cursor cs=  myDataBase.rawQuery(command,null);
        if (cs.getCount()==0){
            return false;
        }else{
            return true;
        }

    }

    public boolean CheckEmployee(String EmpID){
        String command = "Select * from Employee where EmpID="+EmpID;
        Cursor cs = myDataBase.rawQuery(command,null);
        if (cs.getCount()==0){
            return false;
        }else{
            return true;
        }
    }

    public boolean CheckEmployeeTimedIn(String EmpID){
        String command = "Select TimeIn from Attendance where EmpID="+EmpID;
        Cursor cs = myDataBase.rawQuery(command,null);
        cs.moveToFirst();
        String TimedIN=cs.getString(0);
        if (TimedIN==""){
            return  false;
        }else{
            return true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void AddTimeIn(String EmpID){
        LocalDate CurrentDate= LocalDate.now();
        LocalTime CurrentTime=LocalTime.now();
        Time SQLTime= Time.valueOf(CurrentTime.toString());
        Date SQLDate=Date.valueOf(CurrentDate.toString());
        String command = "Insert into Attendance (EmpID,Date,TimeIn,TimeOut,Status) VALUES (" +EmpID+ "," +SQLDate+ "," +SQLTime+ ",'',A";
        myDataBase.execSQL(command);
    }

    public void AddTimeOut(String EmpID){

        //ToDo: Add Code;
    }


    public boolean CheckDriverAndAmbulance(String Driver_ID, String Amb_ID){
        String cmd1= "Select Availability from Driver where DriverID='"+Driver_ID+"'";
        String cmd2= "Select CurrentStatus from Ambulance where AmbulanceID='"+Amb_ID+"'";
        Cursor cs1= myDataBase.rawQuery(cmd1,null);
        Cursor cs2= myDataBase.rawQuery(cmd2,null);
        cs1.moveToFirst();
        cs2.moveToFirst();

        if (cs1.getString(0)=="1" && cs2.getString(0)=="RY"){
            return true;
        }else{
            return false;
        }

    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return myDataBase.query("PLEASE CHANGE TO YOUR TABLE NAME", null, null, null, null, null, null);
    }


}