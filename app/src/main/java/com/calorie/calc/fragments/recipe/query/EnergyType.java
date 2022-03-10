package com.calorie.calc.fragments.recipe.query;

import android.graphics.Color;
import android.widget.Button;

import com.calorie.calc.R;

public enum EnergyType implements QueryType{

    Ener100("100","До 100 ккал",""),
    Ener200("100-200","100-200 ккал",""),
    Ener300("200-300","200-300 ккал",""),
    Ener400("300-400","300-400 ккал",""),
    Ener500("400-500","400-500 ккал",""),
    Ener600("500-600","500-600 ккал",""),
    Ener700("600-700","600-700 ккал",""),
    Ener800("700%2B","более 700 ккал","");

    String queryString="mealType";
    String parametr;
    boolean included = false;
    String label;
    String description;
    Button button;
    EnergyType(String parametr, String label, String description) {
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
