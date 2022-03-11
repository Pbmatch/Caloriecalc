package com.calorie.calc.fragments.recipe.query;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

           // queryMap.putAll(  getPathMap(query,stringList));
            queryMap.put(query,stringList);
        }



    }

    public static Map<String, String> getPathMap(String key, List<String> params) {
        Map<String, String> paramMap = new HashMap<>();
        String paramValue;

        for (String param  : params) {
            if (!TextUtils.isEmpty(param)) {
                try {
                    if (paramMap.containsKey(key )) {
                        // Add the duplicate key and new value onto the previous value
                        // so (key, value) will now look like (key, value&key=value2)
                        // which is a hack to work with Retrofit's QueryMap
                        paramValue = paramMap.get(key );
                        paramValue += ", " + key + "=" + URLEncoder.encode(String.valueOf(param), "UTF-8");
                    } else {
                        // This is the first value, so directly map it
                        paramValue = URLEncoder.encode(String.valueOf(param), "UTF-8");
                    }
                    paramMap.put(key, paramValue);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        return paramMap;
    }
}
