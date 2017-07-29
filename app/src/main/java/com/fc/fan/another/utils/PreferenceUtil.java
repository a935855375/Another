package com.fc.fan.another.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.fc.fan.another.ThisApp;

/**
 * Created by fan on 7/12/17.
 */

public class PreferenceUtil {
    public static final String baseUrl = "http://10.0.0.17:8080/";

    private static SharedPreferences sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(ThisApp.getInstance());

    public static boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static void putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public static void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }
}
