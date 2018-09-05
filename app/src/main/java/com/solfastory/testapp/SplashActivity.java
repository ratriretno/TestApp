package com.solfastory.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.BoringLayout;

import com.solfastory.testapp.helper.DatabaseHelper;

public class SplashActivity extends AppCompatActivity {
private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        databaseHelper = new DatabaseHelper(this);
        Boolean login = databaseHelper.getLogin(this).isLoginStatus();
        if (login){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        finish();
    }
}