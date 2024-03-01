package com.example.sharedpreferencesmain.peferences;

import static com.example.sharedpreferencesmain.constants.Constants.EMAIL;
import static com.example.sharedpreferencesmain.constants.Constants.IF_LOGGED_IN;
import static com.example.sharedpreferencesmain.constants.Constants.NAME;
import static com.example.sharedpreferencesmain.constants.Constants.PASSWORD;
import static com.example.sharedpreferencesmain.constants.Constants.PHONE_NUMBER;
import static com.example.sharedpreferencesmain.constants.Constants.USER_FILE_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.sharedpreferencesmain.activities.LoginActivity;

import java.util.HashMap;

public class UsersSharedPreference {
    Context context;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final int PRIVATE_MODE = 0;

    public UsersSharedPreference(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(USER_FILE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }
    public boolean checkSession() {
        if (preferences.contains(IF_LOGGED_IN)) {
            return true;
        }else {
            return false;
        }
    }
    public void setUserInfo(String name, String email, String password, String phone) {
        //editor.putString("name", name);
        editor.putString(NAME, name);
        editor.putString(EMAIL, email);
        editor.putString(PASSWORD, password);
        editor.putString(PHONE_NUMBER, phone);
        editor.putBoolean(IF_LOGGED_IN, true);
        editor.commit();
    }

    public HashMap<String, String> getUserInfo() {
        HashMap<String, String> info = new HashMap<>();
        info.put(NAME, preferences.getString(NAME, null));
        info.put(EMAIL, preferences.getString(EMAIL, null));
        info.put(PASSWORD, preferences.getString(PASSWORD, null));
        info.put(PHONE_NUMBER, preferences.getString(PHONE_NUMBER, null));
        return info;
    }

    //    public String  getSessionsDetails(String key) {
//        String value = preferences.getString(key, null);
//        return value;
//    }


    public void logOut(Context context) {
        editor.clear();
        editor.commit();

        context.startActivity(new Intent(context, LoginActivity.class));
    }

}
