package com.thededlier.rohan.bookmark;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.camera2.params.StreamConfigurationMap;

import java.util.HashMap;

public class UserSessionManager {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREFER_NAME = "AndroidExamplePref";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";

    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

//    Constructor
    public UserSessionManager(Context context){
        this._context = context;
        prefs = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = prefs.edit();
    }

//    Create login session
    public void createUserLoginSession(String name, String email) {

        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }

    public boolean checkLogin() {

        if(!this.isUserLoggedIn()) {

            Intent intent = new Intent(_context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(intent);
            return true;
        }
        return false;
    }

    public HashMap<String, String> getUserDetails() {

        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_NAME, prefs.getString(KEY_NAME, null));
        user.put(KEY_EMAIL, prefs.getString(KEY_EMAIL, null));
        return user;
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();

        Intent intent = new Intent(_context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(intent);
    }

    public boolean isUserLoggedIn() {

        return prefs.getBoolean(IS_USER_LOGIN, false);
    }
}
