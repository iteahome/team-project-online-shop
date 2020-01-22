package com.shop.model;

import java.util.Scanner;

// USER CLASS:
public class User {
    private String userName;
    private String password;
    private int userID;
    private int phoneNo;
    private String email;
    private static String datas;

    public User(String userName, String password, int userID, int phoneNo, String email) {
        this.userName = userName;
        this.password = password;
        this.userID = userID;
        this.phoneNo = phoneNo;
        this.email = email;
        datas = userID + "|" + userName + "|" + email + "|" + phoneNo + "|" + password;
    }

    // USERNAME GETTER AND SETTER:
    public String getUserName() {
        Scanner input = new Scanner (System.in);
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // PASSWORD GETTER AND SETTER:
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // USER ID GETTER AND SETTER:
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    // PHONE NUMBER GETTER AND SETTER:
    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    // EMAIL GETTER AND SETTER:
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getDatas() {
        return datas;
    }

    public static void setDatas(String datas) {
        User.datas = datas;
    }
}
