package com.calorie.calc.fragments.recipe.query;

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
        this.included=include;
    }
}
