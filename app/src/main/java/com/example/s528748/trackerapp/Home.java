package com.example.s528748.trackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void settings (View v){
        Intent about = new Intent(this, SettingsActivity.class);
        startActivity(about);
    }
    public void addFriend(View v)
    {
        Intent addF = new Intent(this,AddFriend.class);
        startActivity(addF);

    }

    public void trackFriend(View v)
    {
        //Intent trackF = new Intent(this,ListOnline.class);
        Intent trackF = new Intent(this,ListOfFriends.class);
        startActivity(trackF);


    }
    public void trackPublicUser(View v)
    {
        Intent trackPubUser = new Intent(this,MapsActivity.class);
        startActivity(trackPubUser);

    }

    public void logoutUser(View v)
    {
        Intent logoutuser = new Intent(this,MainActivityOne.class);
        Toast.makeText(getApplicationContext(),
                "Successfully logged out",
                Toast.LENGTH_SHORT).show();
        startActivity(logoutuser);


    }
}
