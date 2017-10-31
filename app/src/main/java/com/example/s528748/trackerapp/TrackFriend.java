package com.example.s528748.trackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TrackFriend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_friend);
    }

    public void TrackSelectedFriend(View v)

    {
        Intent trackSelectedFriend = new Intent(this,TrackFriendOnMap.class);
        startActivity(trackSelectedFriend);
    }
}
