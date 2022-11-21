package com.example.sda_project;

import java.util.Date;

public class User {
    private String Name;
    private Date DOB;
    private String CNIC;
    private String Address;
    private String PhoneNum;
    private Date EnrollDate;
    private String UserName;
    private String Password;
    private Account myAcc;

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getEnrollDate() {
        return EnrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        EnrollDate = enrollDate;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }
}
