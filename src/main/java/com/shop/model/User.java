package com.shop.model;

/** User class - for login and shopping purposes. */

public class User {

//  User parameters:
    private String userName;
    private String password;
    private String email;
    private String phoneNo;
    private String role;

//  User class constructor:
    public User(String password, String email, String role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String DBprint () {
        return userName + "|" + password + "|" + email + "|" + phoneNo + "|" + role;
    }
//  User getters and setters:
    public String getUserName() {
        return userName;
    }
    public String setUserName(String userName) {
        this.userName = userName;
        return userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}