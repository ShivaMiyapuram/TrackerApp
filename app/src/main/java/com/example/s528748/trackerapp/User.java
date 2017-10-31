package com.example.s528748.trackerapp;

/**
 * Created by S528748 on 10/21/2017.
 */

public class User {
    public String email, status;

    public User(){

    }

    public User(String email,  String status){
        this.email = email;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
