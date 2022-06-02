package com.calorie.calc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.TotalNutrients;

public   class OptionsUnit {
    public  static String getBodySizeUnit(Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(Constants.KEY_BODY_SIZE_UNIT,"см");
    }
    public  static String getWaterUnit(Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(Constants.KEY_BODY_SIZE_UNIT,"мл");
    }

    public static String getExerciseItemTimeUnit(Context context) {
        return context.getString(R.string.time);
    }
    public static String getExerciseItemEnergyUnit(Context context) {
        return context.getString(R.string.kkal);
    }
    public static String getWeightItemUnit(Context context) {
        return context.getString(R.string.weight_unit);
    }
    public static String getWeightCount(final Context context, final long count) {
        final int safeCount = count > Integer.MAX_VALUE ? Integer.MAX_VALUE
                : count < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) count;
        return context.getResources().getQuantityString(R.plurals.day_count, safeCount, count);
    }
    public static TotalNutrients.Fat getFat(String stringMealTime)
    {
        switch (stringMealTime)
        {
            case "BREAKFAST" :{
                return new TotalNutrients().new Fat("Fat",50.0,"g");

                }
            case      "LUNCH":{
                return new TotalNutrients().new Fat("Fat",20.0,"g");

            }
            case      "DINNER":{
                return new TotalNutrients().new Fat("Fat",150.0,"g");

            }
            case        "SNACK":{
                return new TotalNutrients().new Fat("Fat",80.0,"g");

            }

        }
        TotalNutrients.Fat fat = new TotalNutrients().new Fat("Fat",100.0,"g");
        return fat;

    }
    public static TotalNutrients.EnercKcal getEnergy(String stringMealTime)
    {
        switch (stringMealTime)
        {
            case "BREAKFAST" :{
                return  new TotalNutrients().new EnercKcal("Energy",450.0,"kcal");

            }
            case      "LUNCH":{
                return  new TotalNutrients().new EnercKcal("Energy",500.0,"kcal");

            }
            case      "DINNER":{
                return new TotalNutrients().new EnercKcal("Energy",500.0,"kcal");

            }
            case        "SNACK":{
                return  new TotalNutrients().new EnercKcal("Energy",200.0,"kcal");

            }

        }
        return  new TotalNutrients().new EnercKcal("Energy",100.0,"kcal");


    }
    public static TotalNutrients.Procnt getProtein(String stringMealTime)
    {
        switch (stringMealTime)
        {
            case "BREAKFAST" :{
                return  new TotalNutrients().new Procnt("Protein",22.0,"g");

            }
            case      "LUNCH":{
                return  new TotalNutrients().new Procnt("Protein",28.0,"g");

            }
            case      "DINNER":{
                return new TotalNutrients().new Procnt("Protein",30.0,"g");

            }
            case        "SNACK":{
                return  new TotalNutrients().new Procnt("Protein",15.0,"g");

            }

        }
        return  new TotalNutrients().new Procnt("Protein",10.0,"g");


    }
    public static TotalNutrients.Chocdf getCarb(String stringMealTime)
    {
        switch (stringMealTime)
        {
            case "BREAKFAST" :{
                return  new TotalNutrients().new Chocdf("Carb",32.0,"g");

            }
            case      "LUNCH":{
                return  new TotalNutrients().new Chocdf("Carb",38.0,"g");

            }
            case      "DINNER":{
                return new TotalNutrients().new Chocdf("Carb",40.0,"g");

            }
            case        "SNACK":{
                return  new TotalNutrients().new Chocdf("Carb",35.0,"g");

            }

        }
        return  new TotalNutrients().new Chocdf("Carb",30.0,"g");


    }

}
