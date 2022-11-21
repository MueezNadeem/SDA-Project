package com.example.sda_project;

public class Account {
    private  int AccountID;
    private AccountType Type;

    public AccountType getType() {
        return Type;
    }

    public void setType(AccountType type) {
        Type = type;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }
}
