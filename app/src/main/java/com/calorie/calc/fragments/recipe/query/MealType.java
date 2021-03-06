package com.calorie.calc.fragments.recipe.query;

import android.graphics.Color;
import android.widget.Button;

import com.calorie.calc.R;

public enum MealType implements QueryType{

     Breakfast("Breakfast","Breakfast",""),
     Lunch("Lunch","Lunch",""),
     Dinner("Dinner","Dinner",""),
     Snack("Snack","Snack",""),
     Teatime("Teatime","Teatime","");

    String queryString="mealType";
     String parametr;
    boolean included = false;
    String label;
    String description;
    Button button;
    MealType(String parametr, String label, String description) {
        this.parametr = parametr;
        this.label = label;
        this.description = description;
    }

    @Override
    public String getQueryString() {
        return queryString;
    }

    @Override
    public String getParametr() {
        return parametr;
    }

    @Override
    public String getLable() {
        return label;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public boolean isIncluded() {
        return included;
    }

    @Override
    public void setInclude(Boolean include) {
        if (button!=null)
        {
            if( include)
            {
                button.setBackgroundResource(R.drawable.button_filter_on);
                button.setTextColor(Color.WHITE);
            }
            else
            {button.setBackgroundResource(R.drawable.button_filter_off);
                button.setTextColor(Color.BLACK);
            }
        }
        this.included=include;
    }
    @Override
    public Button getTextViewButton() {
        return button;
    }

    @Override
    public void setButton(Button button) {
        this.button=button;
    }

}
