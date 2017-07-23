package com.fc.fan.another.utils;

import android.preference.PreferenceManager;

import com.fc.fan.another.ThisApp;

/**
 * Created by fan on 7/12/17.
 */

public class PreferenceUtil {
    public static final String baseUrl = "http://10.0.0.17:8080/";

    public static boolean getBoolean(String key, boolean defValue) {
        return PreferenceManager.getDefaultSharedPreferences(ThisApp.getInstance()).getBoolean(key, defValue);
    }
}
