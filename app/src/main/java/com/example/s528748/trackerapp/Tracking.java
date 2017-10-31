package com.example.s528748.trackerapp;

/**
 * Created by S528748 on 10/22/2017.
 */

public class Tracking {

    private String email, uid, lat, lon;

    public Tracking() {
    }

    public Tracking(String email, String uid, String lat, String lon) {
        this.email = email;
        this.uid = uid;
        this.lat = lat;
        this.lon = lon;
    }

    public String getEmail() {
        return email;
    }

    public String getUid() {
        return uid;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
