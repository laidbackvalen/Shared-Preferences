package com.example.sharedpreferencesmain.activities;

import static com.example.sharedpreferencesmain.constants.Constants.EMAIL;
import static com.example.sharedpreferencesmain.constants.Constants.NAME;
import static com.example.sharedpreferencesmain.constants.Constants.PASSWORD;
import static com.example.sharedpreferencesmain.constants.Constants.PHONE_NUMBER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sharedpreferencesmain.R;
import com.example.sharedpreferencesmain.peferences.UsersSharedPreference;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText email_EdTxt, password_EdTxt;
    Button loginButton;
    TextView dontHaveAccTxt;
    UsersSharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_EdTxt = findViewById(R.id.emailLoginTextInputEditText);
        password_EdTxt = findViewById(R.id.passwordLoginTextInputEditText);
        loginButton = findViewById(R.id.loginButton);
        dontHaveAccTxt = findViewById(R.id.dontHaveAnAccountLoginText);

        sharedPreference = new UsersSharedPreference(LoginActivity.this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_EdTxt.getText().toString();
                String password = password_EdTxt.getText().toString();

                if (email.equals("valen.patel1@gmail.com") && password.equals("valen123!")) {
                    sharedPreference.setUserInfo("Valen Patel", "valen.patel1@gmail.com", "valen123!", "7517770046");
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dontHaveAccTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });


    }
}