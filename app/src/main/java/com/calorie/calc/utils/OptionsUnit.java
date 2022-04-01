package com.calorie.calc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.calorie.calc.R;

public   class OptionsUnit {
    public  static String getBodySizeUnit(Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(Constants.KEY_BODY_SIZE_UNIT,"см");
    }


    public static String getExerciseItemTimeUnit(Context context) {
        return context.getString(R.string.time);
    }
    public static String getExerciseItemEnergyUnit(Context context) {
        return context.getString(R.string.kkal);
    }
}
