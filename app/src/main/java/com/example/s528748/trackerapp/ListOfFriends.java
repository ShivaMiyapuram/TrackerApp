package com.example.s528748.trackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListOfFriends extends AppCompatActivity {

    private List<User> users = new ArrayList<>();
    ArrayAdapter server;
    User lastClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_friends);

        ListView listView = (ListView) findViewById(R.id.Listview);
        users.add(new User("John", "online"));
        users.add(new User("Jerry", "online"));
        users.add(new User("Krish", "online"));
        users.add(new User("Tom", "online"));


        server = new MyArrayAdapter(this, R.layout.user_layout, R.id.txt_email, users);

        listView.setAdapter(server);
        // listView.addView();

        listView.setOnItemClickListener(new ListView.OnItemClickListener( ){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                User e = users.get(position);
                Log.d("POSITION", position+ "");
             //   e.incrementCountByOne();
             //   lastClicked = e;
//                TextView textView = (TextView) findViewById(R.id.textView2);
//                textView.setText(e.getCount() + "");
//                // redraws only updated ones
//
                switch(position){
                    case 0: Intent map1 = new Intent(ListOfFriends.this, TrackFriendZero.class);
                        Toast.makeText(getApplicationContext(),
                                "You clicked: "+ e.getEmail(),
                                Toast.LENGTH_SHORT).show();
                            startActivity(map1);
                            break;
                    case 1: Intent map2 = new Intent(ListOfFriends.this, TrackFriendOne.class);
                        Toast.makeText(getApplicationContext(),
                                "You clicked: "+ e.getEmail(),
                                Toast.LENGTH_SHORT).show();
                            startActivity(map2);
                            break;
                    case 2: Intent map3 = new Intent(ListOfFriends.this, TrackFriendTwo.class);
                        Toast.makeText(getApplicationContext(),
                                "You clicked: "+ e.getEmail(),
                                Toast.LENGTH_SHORT).show();
                        startActivity(map3);
                        break;

                    case 3: Intent map4 = new Intent(ListOfFriends.this, TrackFriendThree.class);
                        Toast.makeText(getApplicationContext(),
                                "You clicked: "+ e.getEmail(),
                                Toast.LENGTH_SHORT).show();
                        startActivity(map4);
                        break;
                }
            }
            //   data.add(new Pet("xx", "mutt", 50.0));
        });

    }
}
