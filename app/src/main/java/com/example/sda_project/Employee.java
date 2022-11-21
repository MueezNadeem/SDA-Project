package com.example.sda_project;

public class Employee extends User {

    private int EmployeeID;
    private EmployeeType EmpType;

    public Employee() {
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public EmployeeType getEmpType() {
        return EmpType;
    }

    public void setEmpType(EmployeeType empType) {
        EmpType = empType;
    }
}
