package com.calorie.calc.fragments.recipe.query;

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
        this.included=include;
    }
}
