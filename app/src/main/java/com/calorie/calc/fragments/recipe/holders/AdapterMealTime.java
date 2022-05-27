package com.calorie.calc.fragments.recipe.holders;

import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;

import java.util.List;

public class AdapterMealTime {
    double yield=0;
    private double calories=0;
    private double gram=0;

    public String getMeasureString() {
        return measureString;
    }

    public AdapterMealTime setMeasureString(String measureString) {
        this.measureString = measureString;
        return this;
    }

    String measureString="";


    public List<Nutrient> getNutrientList(List<Nutrient> list) {

        return list;
    }
    public double getYield() {
        return yield;
    }

    public AdapterMealTime setYield(double yield) {
        this.yield = yield;
        return this;
    }

    public double getCalories() {
        return calories;
    }

    public AdapterMealTime setCalories(double calories) {
        this.calories = calories;
        return this;
    }
    public enum MeasureEnum
    {
        Portion("Portion"),
        Gram("Gram");

        String title;

        MeasureEnum(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

}
