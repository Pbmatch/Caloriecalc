package com.calorie.calc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
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

    public static Nutrient createDefaultNutrient(String stringMealTime, NormallyHolder holder)
    {
        double quantity=0;
        switch (stringMealTime)
        {
            case "BREAKFAST" :{
                quantity = holder.BREAKFASTquantity();
                break;
            }
            case      "LUNCH":{
                quantity = holder.LUNCHquantity();
                break;
            }
            case      "DINNER":{
                quantity = holder.DINNERquantity();
                break;
            }
            case        "SNACK":{
                quantity = holder.SNACKquantity();
                break;
            }
            default:quantity = holder.getSumm();

        }

        return holder.createNutrient(quantity);

    }


   interface NormallyHolder
    {
          double BREAKFASTquantity();
          double LUNCHquantity();
          double DINNERquantity();
        double SNACKquantity();
        Nutrient createNutrient(double quantity);
       default double getSumm()
        {
            return    BREAKFASTquantity()+
                    LUNCHquantity()+
             DINNERquantity()+
              SNACKquantity();
        }
    }
    public   static class NormallyProteinHolder implements NormallyHolder
    {

        @Override
        public double BREAKFASTquantity() {
            return 22;
        }

        @Override
        public  double LUNCHquantity() {
            return 28;
        }

        @Override
        public double DINNERquantity() {
            return 30;
        }

        @Override
        public double SNACKquantity() {
            return 15;
        }

        @Override
        public Nutrient createNutrient(double quantity) {
            return new TotalNutrients().new Procnt("Protein",quantity,"g");
        }
    }



    public   static class NormallyEnergyHolder implements NormallyHolder
    {

        @Override
       public double BREAKFASTquantity() {
            return 450;
        }

        @Override
        public  double LUNCHquantity() {
            return 500;
        }

        @Override
        public double DINNERquantity() {
            return 500;
        }

        @Override
        public double SNACKquantity() {
            return 200;
        }

        @Override
        public Nutrient createNutrient(double quantity) {
            return new TotalNutrients().new EnercKcal("Energy",quantity,"kcal");
        }
    }
    public   static class NormallyFatHolder implements NormallyHolder
    {

        @Override
        public double BREAKFASTquantity() {
            return 50;
        }

        @Override
        public  double LUNCHquantity() {
            return 20;
        }

        @Override
        public double DINNERquantity() {
            return 150;
        }

        @Override
        public double SNACKquantity() {
            return 80;
        }

        @Override
        public Nutrient createNutrient(double quantity) {
            return new TotalNutrients().new Fat("Fat",quantity,"g");
        }
    }
    public   static class NormallyCarbHolder implements NormallyHolder
    {

        @Override
        public double BREAKFASTquantity() {
            return 32;
        }

        @Override
        public  double LUNCHquantity() {
            return 38;
        }

        @Override
        public double DINNERquantity() {
            return 40;
        }

        @Override
        public double SNACKquantity() {
            return 35;
        }

        @Override
        public Nutrient createNutrient(double quantity) {
            return new TotalNutrients().new Chocdf("Carb",quantity,"g");
        }
    }

}
