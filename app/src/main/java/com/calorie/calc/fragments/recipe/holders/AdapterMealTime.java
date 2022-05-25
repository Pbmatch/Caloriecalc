package com.calorie.calc.fragments.recipe.holders;

import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;

import java.util.List;

public class AdapterMealTime {
    int yield=0;
    private double calories=0;


    public List<Nutrient> getNutrientList(List<Nutrient> list) {

        return list;
    }
    public int getYield() {
        return yield;
    }

    public AdapterMealTime setYield(int yield) {
        this.yield = yield;
        return this;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
