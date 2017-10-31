package com.example.s528748.trackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class MainActivityOne extends AppCompatActivity {

    private Button btnLogin;

    private final static int LOGIN_PERMISSION = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_one);
        btnLogin = (Button) findViewById(R.id.loginbtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        AuthUI.getInstance().createSignInIntentBuilder()
                                .setAllowNewEmailAccounts(true).build(), LOGIN_PERMISSION);
            }
        });
    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == LOGIN_PERMISSION){
            startNewActivity(resultCode, data);
        }
    }

    private void startNewActivity(int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void signUp(View view) {
        // go to signup activity
        Intent i = new Intent(this, SignUpOne.class);
        startActivity(i);
    }

    public void login(View view) {
        // go to home after logging in
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }
}
