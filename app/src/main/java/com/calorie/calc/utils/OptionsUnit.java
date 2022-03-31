package com.calorie.calc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public   class OptionsUnit {
    public  static String getBodySizeUnit(Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(Constants.KEY_BODY_SIZE_UNIT,"см");
    }
}
