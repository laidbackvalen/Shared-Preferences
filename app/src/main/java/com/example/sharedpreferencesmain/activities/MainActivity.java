package com.example.sharedpreferencesmain.activities;

import static com.example.sharedpreferencesmain.constants.Constants.EMAIL;
import static com.example.sharedpreferencesmain.constants.Constants.NAME;
import static com.example.sharedpreferencesmain.constants.Constants.PASSWORD;
import static com.example.sharedpreferencesmain.constants.Constants.PHONE_NUMBER;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sharedpreferencesmain.R;
import com.example.sharedpreferencesmain.peferences.UsersSharedPreference;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView nameTxt, emailTxt, passwordTxt, phoneTxt;
    Button logoutButton;
    UsersSharedPreference usersSharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameTxt = findViewById(R.id.nameMainProfileTextView);
        emailTxt = findViewById(R.id.emailMainProfileTextView);
        passwordTxt = findViewById(R.id.passwordMainProfileTextView);
        phoneTxt = findViewById(R.id.phoneMainProfileTextView);
        logoutButton = findViewById(R.id.logoutButton);

        usersSharedPreference = new UsersSharedPreference(MainActivity.this);
        HashMap<String, String> info = usersSharedPreference.getUserInfo();

        nameTxt.setText(info.get(NAME));
        emailTxt.setText(info.get(EMAIL));
        passwordTxt.setText(info.get(PASSWORD));
        phoneTxt.setText(info.get(PHONE_NUMBER));

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usersSharedPreference.logOut(MainActivity.this);
            }
        });

    }
}