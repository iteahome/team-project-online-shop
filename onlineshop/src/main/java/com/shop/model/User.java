package com.shop.model;

public class User {
    private String username;
    private String password;
    private int uniqueid;
    private int phoneno;
    private String email;

    public User(String username, String password, int uniqueid, int phoneno, String email) {
        this.username = username;
        this.password = password;
        this.uniqueid = uniqueid;
        this.phoneno = phoneno;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
