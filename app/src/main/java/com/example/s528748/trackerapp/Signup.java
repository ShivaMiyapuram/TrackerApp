package com.example.s528748.trackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Signup extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;
    private EditText phoneField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button register = (Button) findViewById(R.id.registerBTN);
        usernameField = (EditText) findViewById(R.id.usernameET);
        passwordField = (EditText) findViewById(R.id.passwordET);
        phoneField = (EditText) findViewById(R.id.phoneET);

        register.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                String phone = phoneField.getText().toString();

                //Register a user with Backendless
                BackendlessUser backendlessUser = new BackendlessUser();
                backendlessUser.setPassword(password);
                backendlessUser.setProperty("name", username);
                backendlessUser.setProperty("phone", phone);

                //Actually registers user with Backendless
                Backendless.UserService.register(backendlessUser, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(getApplicationContext(), "You are registered with username: "
                                + username, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(getApplicationContext(), "There was a problem with your " +
                                "registration", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button back = (Button)findViewById(R.id.backToLogin);
        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this, MainActivity.class));
            }
        });
    }

}
