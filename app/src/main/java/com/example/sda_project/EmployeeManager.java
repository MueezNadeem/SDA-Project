package com.example.sda_project;

public class EmployeeManager {
    private DatabaseClass myC=new DatabaseClass();
    private DatabaseHelper DB =myC.getInstance();

    public EmployeeType CheckEmployeeType(String EmpID){
        // String EmpFromDB=DB.EmployeeTypeString(EmpID);

        return EmployeeType.Admin;
    }

    //TODO: Add Code
    public void AddEmployeeToDB(Admin _ad){

    }
    public void AddEmployeeToDB(Manager _mg){

    }
    public void AddEmployeeToDB(Dispatcher _dp){

    }
    public void AddEmployeeToDB(Driver _dr){

    }
    public void AddEmployeeToDB(Worker _wr){

    }



    public boolean CheckEmployeeExistence(int EmpID){
        return true;
    }
}
