package com.example.s528748.trackerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddFriend extends AppCompatActivity {

    private List<User> users = new ArrayList<>();
    ArrayAdapter server;
    User lastClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        ListView listView = (ListView) findViewById(R.id.Listview99);

        server = new MyArrayAdapterTwo(this, R.layout.user_layout, R.id.txt_email, users);

        listView.setAdapter(server);

        listView.setOnItemClickListener(new ListView.OnItemClickListener( ){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                User e = users.get(position);
                Log.d("POSITION", position+ "");
              //  e.incrementCountByOne();
              //  lastClicked = e;
//                TextView textView = (TextView) findViewById(R.id.textView2);
//                textView.setText(e.getCount() + "");
                // redraws only updated ones
                server.notifyDataSetChanged();
//                Toast.makeText(getApplicationContext(),
//                        "You clicked: "+ users.get(position).getEmail(),
//                        Toast.LENGTH_SHORT).show();
            }
            //   data.add(new Pet("xx", "mutt", 50.0));
        });


    }

    public void onAdd(View view){

        EditText searchView = (EditText) findViewById(R.id.searchET);
        String newFriendName = searchView.getText().toString();

        if(!newFriendName.equals("")){
            User u = new User(newFriendName, "Added");
            users.add(u);
         //   e.setRating();
            Toast.makeText(getApplicationContext(),
                    "You added" + u.getEmail() + " as your friend",
                    Toast.LENGTH_SHORT).show();
            server.notifyDataSetChanged();
        }
        else
            Toast.makeText(getApplicationContext(),
                    "Enter a friends name",
                    Toast.LENGTH_SHORT).show();
    }


}
