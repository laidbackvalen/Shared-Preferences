package com.example.sharedpreferencesmain.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sharedpreferencesmain.R;
import com.example.sharedpreferencesmain.peferences.UsersSharedPreference;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UsersSharedPreference preference = new UsersSharedPreference(SplashScreen.this);
                Boolean b = preference.checkSession();
                if (b == true) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();

                }
            }
        }, 2000);
    }
}