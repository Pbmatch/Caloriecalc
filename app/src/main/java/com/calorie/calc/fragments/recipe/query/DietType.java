package com.calorie.calc.fragments.recipe.query;

import android.graphics.Color;
import android.widget.Button;

import com.calorie.calc.R;

public enum DietType implements QueryType{

   Balanced	("balanced","Balanced","Protein/Fat/Carb values in 15/35/50 ratio"),
   HighFiber("high-fiber","High Fiber","More than 5g fiber per serving"),
    HighProtein	("high-protein","High Protein","More than 50% of total calories from proteins"),
    LowCarb	("low-carb","Low Carb","Less than 20% of total calories from carbs"),
    LowFat	("low-fat","Low Fat","Less than 15% of total calories from fat"),
    LowSodium	("low-sodium","Low Sodium","Less than 140mg Na per serving");

    String queryString="Diet";

    String parametr;
    boolean included = false;
    String label;
    String description;
    Button button;
    DietType(String parametr, String label, String description) {
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
                button.setTextColor(button.getContext().getColor(R.color.text_title_color));
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
