package com.calorie.calc.fragments.recipe.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryHandler {

    Map<String,Object> queryMap;


   public  Map<String,Object> build()
   {
       queryMap = new HashMap<>();
       getIncludedType(Arrays.asList(MealType.values()));
       getIncludedType(Arrays.asList(HealthType.values()));
       getIncludedType(Arrays.asList(DishType.values()));
       getIncludedType(Arrays.asList(CuisineType.values()));
       getIncludedType(Arrays.asList(DietType.values()));
       return queryMap;

   }
    public  Map<String,Object> build(String findText)
    {
        queryMap = new HashMap<>();
        getIncludedType(Arrays.asList(MealType.values()));
        getIncludedType(Arrays.asList(HealthType.values()));
        getIncludedType(Arrays.asList(DishType.values()));
        getIncludedType(Arrays.asList(CuisineType.values()));
        getIncludedType(Arrays.asList(DietType.values()));
        queryMap.put("q",findText);
        return queryMap;

    }

   private void getIncludedType(List<QueryType> type)
    {
        List<String> stringList = new ArrayList<>();
        String query="";
        for(QueryType item:type)
        {
            if(item.isIncluded())
            {
                stringList.add(item.getParametr());
                query=item.getQueryString();
            }

        }
        if(!stringList.isEmpty())
        {
            queryMap.put(query,stringList);
        }



    }
}
