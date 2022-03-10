package com.calorie.calc.fragments.recipe.query;

import android.graphics.Color;
import android.widget.Button;

import com.calorie.calc.R;

public enum DishType implements QueryType {

       AlcoholCocktail("Alcohol-cocktail","Alcohol Cocktail",""),
       BiscuitsAndCookies("Biscuits%20and%20cookies","Biscuits And Cookies",""),
    	Bread("Bread","Bread",""),
    	Cereals("Cereals","Cereals",""),
    	CondimentsAndSauces("Condiments%20and%20sauces","Condiments And Sauces",""),
    	Drinks("Drinks","Drinks",""),
    	Desserts("Desserts","Desserts",""),
    	Egg("Egg","Egg",""),
    	MainCourse("Main course","Main Course",""),
    	Omelet("Omelet","Omelet",""),
    	Pancake("Pancake","Pancake",""),
    	Preps("Preps","Preps",""),
    	Preserve("Preserve","Preserve",""),
    	Salad("Salad","Salad",""),
    	Sandwiches("Sandwiches","Sandwiches",""),
    	Soup("Soup","Soup",""),
    	Starter("Starter","Starter","");

    String queryString="dishType";
    String parametr;
    boolean included = false;
    String label;
    String description;
    Button button;
    DishType(String parametr, String label, String description) {
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
