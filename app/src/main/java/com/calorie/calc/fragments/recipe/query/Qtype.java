package com.calorie.calc.fragments.recipe.query;

import android.graphics.Color;
import android.widget.Button;

import com.calorie.calc.R;

public enum Qtype implements QueryType{

    QTYPE("","","");


  private   String queryString="q";
    private  String parametr;
    private boolean included = false;
    private  String label;
    private  String description;
    private Button button;
    Qtype(String parametr, String label, String description) {
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

    public void setParametr(String parametr) {
        if(!parametr.isEmpty())setInclude(true);

        this.parametr = parametr;
    }

    @Override
    public String getLable() {

        return parametr;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public boolean isIncluded() {
        return (!parametr.isEmpty());

    }

    @Override
    public void setInclude(Boolean include) {
      if(!include) parametr="";
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
