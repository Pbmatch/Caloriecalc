package com.calorie.calc.fragments.recipe.query;

  public  interface QueryType {


         String getQueryString();
          String getParametr();
          String getLable();
          String getDescription();
          boolean isIncluded();
          void setInclude(Boolean include);


}
