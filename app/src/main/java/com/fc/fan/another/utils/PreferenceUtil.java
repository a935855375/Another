package com.fc.fan.another.utils;

import android.preference.PreferenceManager;

import com.fc.fan.another.ThisApp;

/**
 * Created by fan on 7/12/17.
 */

public class PreferenceUtil {
    public static boolean getBoolean(String key, boolean defValue) {
        return PreferenceManager.getDefaultSharedPreferences(ThisApp.getInstance()).getBoolean(key, defValue);
    }
}
