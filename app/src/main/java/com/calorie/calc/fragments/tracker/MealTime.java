package com.calorie.calc.fragments.tracker;

import com.calorie.calc.R;

public enum MealTime {
    BREAKFAST("Завтрак", R.drawable.breakfastcolor),
    LUNCH("Обед", R.drawable.lunchcolor),
    DINNER("Ужин", R.drawable.dinnercolor),
    SNACK("Перекус", R.drawable.bitecolor);
   private final String title;
    private final int resourceImageView;

    MealTime(String title, int resourceImageView) {
        this.title = title;
        this.resourceImageView = resourceImageView;
    }

    public String getTitle() {
        return title;
    }

    public int getResourceImageView() {
        return resourceImageView;
    }
}
