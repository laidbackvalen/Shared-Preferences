package com.example.sharedpreferencesmain.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sharedpreferencesmain.R;
import com.example.sharedpreferencesmain.peferences.UsersSharedPreference;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText name_EdTxt, email_EdTxt, password_EdTxt, phone_EdTxt;
    Button registerButton;
    TextView alreadyUserTxtView;
    UsersSharedPreference usersSharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name_EdTxt = findViewById(R.id.nameRegisterTextInputEditText);
        email_EdTxt = findViewById(R.id.emailRegisterTextInputEditText);
        password_EdTxt = findViewById(R.id.passwordRegisterTextInputEditText);
        phone_EdTxt = findViewById(R.id.phoneRegisterTextInputEditText);
        registerButton = findViewById(R.id.registerButton);
        alreadyUserTxtView = findViewById(R.id.alreadyUserText);

        usersSharedPreference = new UsersSharedPreference(RegisterActivity.this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_EdTxt.getText().toString().trim();
                String email = email_EdTxt.getText().toString().trim();
                String password = password_EdTxt.getText().toString().trim();
                String phone = phone_EdTxt.getText().toString().trim();
                usersSharedPreference.setUserInfo(name, email, password, phone);

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        alreadyUserTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
    }
}