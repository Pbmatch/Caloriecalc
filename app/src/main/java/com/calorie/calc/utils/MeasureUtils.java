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
    public static String getStringFromDouble(double kKal)
    {
        Double d = kKal;
        Integer i = d.intValue();
        return String.valueOf(i);

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
    public static String getDishCount(final Context context, final long count) {
        final int safeCount = count > Integer.MAX_VALUE ? Integer.MAX_VALUE
                : count < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) count;
        return context.getResources().getQuantityString(R.plurals.dish_count, safeCount, count);
    }
}
