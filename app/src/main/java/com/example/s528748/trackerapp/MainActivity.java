package com.example.s528748.trackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signUp(View view) {
        // go to signup activity
        Intent i = new Intent(this, Signup.class);
        startActivity(i);
    }

    public void login(View view) {
        // go to home after logging in
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }
}
