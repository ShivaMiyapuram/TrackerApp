package com.example.s528748.trackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity {

    public static final String APP_ID = "FC6F63F0-859B-84B5-FF4D-126C761AC700";
    public static final String API_KEY = "64D916B7-2C32-39D6-FF3E-E60682A88200";
    public static final String SERVER_URL = "https://api.backendless.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Backendless.initApp(this, APP_ID, API_KEY);

    }

    public void signUp(View view) {
        // go to signup activity
        Intent i = new Intent(this, Signup.class);
        startActivity(i);
    }

    public void login(View view) {
        // go to home after logging in
        EditText username = (EditText) findViewById(R.id.usernameLogin);
        EditText password = (EditText) findViewById(R.id.passwordLogin);
        String user = username.getText().toString();
        String pwd = password.getText().toString();
        Backendless.UserService.login(user, pwd, new AsyncCallback<BackendlessUser>()
        {
            public void handleResponse( BackendlessUser user )
            {
                startActivity(new Intent(MainActivity.this, Home.class));
            }

            public void handleFault( BackendlessFault fault )
            {
                Toast.makeText(getApplicationContext(), "There was a problem with your " +
                        "login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
