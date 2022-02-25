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
    public static String getNutrientString(double kKal,  String unit)
    {
        Double d = kKal;
        Integer i = d.intValue();
        return i+" "+unit;

    }
    public static String getIngrTitleString(Double yeld )
    {
        Double d = yeld;
        Integer i = d.intValue();
        return i + " "+"Порции";

    }
}
