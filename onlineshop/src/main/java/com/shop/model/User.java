package com.shop.model;

// USER CLASS:
public class User {
    private String userName;
    private String password;
    private String phoneNo;
    private String email;

    public User(String userName, String password, String phoneNo, String email) {
        this.userName = userName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    // USERNAME GETTER AND SETTER:
    public String getUserName() {
        return userName;
    }

    public String setUserName(String userName) {
        this.userName = userName;
        return userName;
    }

    // PASSWORD GETTER AND SETTER:
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // PHONE NUMBER GETTER AND SETTER:
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    // EMAIL GETTER AND SETTER:
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
