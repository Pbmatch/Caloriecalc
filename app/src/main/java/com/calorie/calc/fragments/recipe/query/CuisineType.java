package com.calorie.calc.fragments.recipe.query;

import android.graphics.Color;
import android.widget.Button;

import com.calorie.calc.R;

public enum CuisineType implements QueryType{

    	American("American","American",""),
    	Asian("Asian","Asian",""),
    	British("British","British",""),
    	Caribbean("Caribbean","Caribbean",""),
    	CentralEurope("Central%20Europe","Central Europe",""),
    	Chinese("Chinese","Chinese",""),
    	EasternEurope("Eastern%20Europe","Eastern Europe",""),
    	French("French","French",""),
    	Indian("Indian","Indian",""),
    	Italian("Italian","Italian",""),
    	Japanese("Japanese","Japanese",""),
    	Kosher("Kosher","Kosher",""),
    	Mediterranean("Mediterranean","Mediterranean",""),
    	Mexican("Mexican","Mexican",""),
    	MiddleEastern("Middle%20Eastern","Middle Eastern",""),
    	Nordic("Nordic","Nordic",""),
    	SouthAmerican("South%20American","South American",""),
    	SouthEastAsian("South%20East%20Asian","South East Asian","");

	String queryString="cuisineType";
	String parametr;
	boolean included = false;
	String label;
	String description;
	Button button;
	CuisineType(String parametr, String label, String description) {
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
