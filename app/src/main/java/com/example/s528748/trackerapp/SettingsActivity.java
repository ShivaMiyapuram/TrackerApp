package com.example.s528748.trackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void aboutUs (View v){
        // Opens AboutUsActivity
        Intent about = new Intent(this, AboutUsActivity.class);
        startActivity(about);
    }

    public void logOut (View v){
        // Opens LogOutActivity
        Intent logout = new Intent(this, LogOutActivity.class);
        startActivity(logout);
    }

    public void back(View v){
        // Closes settings activity and goes back to home
        Intent ini = new Intent(this, Home.class);
        ini.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ini);
    }

    public void aboutAppp(View view) {
        Intent logout = new Intent(this, LogOutActivity.class);
        startActivity(logout);

    }
}
