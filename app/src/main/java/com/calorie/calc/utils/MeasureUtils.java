package com.calorie.calc.utils;

import android.content.Context;

import com.calorie.calc.R;

public class MeasureUtils {
    public static String getEnergyString(double kKal, Context context)
    {
        Double d = kKal;
        Integer i = d.intValue();
      return i+context.getString(R.string.kkal);

    }
}
