package com.calorie.calc.fragments.recipe.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryHandler {

    Map<String, Object> queryMap;



    public Map<String, Object> build() {

        queryMap = new HashMap<>();
        getIncludedType(Arrays.asList(MealType.values()));
        getIncludedType(Arrays.asList(HealthType.values()));
        getIncludedType(Arrays.asList(DishType.values()));
        getIncludedType(Arrays.asList(CuisineType.values()));
        getIncludedType(Arrays.asList(DietType.values()));
        getIncludedType(Arrays.asList(EnergyType.values()));
        getIncludedType(Arrays.asList(Qtype.values()));
        return queryMap;

    }



    public boolean needOpenFindFragment() {
        build();
        return (!Qtype.QTYPE.getParametr().isEmpty() || queryMap != null && !queryMap.isEmpty());
    }

    private void getIncludedType(List<QueryType> type) {
        List<String> stringList = new ArrayList<>();
        String query = "";
        for (QueryType item : type) {
            if (item.isIncluded()) {
                stringList.add(item.getParametr());
                query = item.getQueryString();
            }

        }
        if (!stringList.isEmpty()) {


            queryMap.put(query, stringList);
        }


    }
    public   List<QueryType> getListForButton()
    {
        List<QueryType> list = new ArrayList<>();
        list.addAll( getItemList(Arrays.asList(MealType.values())));
        list.addAll( getItemList(Arrays.asList(HealthType.values())));
        list.addAll( getItemList(Arrays.asList(DishType.values())));
        list.addAll( getItemList(Arrays.asList(CuisineType.values())));
        list.addAll( getItemList(Arrays.asList(DietType.values())));
        list.addAll( getItemList(Arrays.asList(EnergyType.values())));
        list.addAll(getItemList(Arrays.asList(Qtype.values())));

      return list;



    }
    private    List<QueryType>   getItemList(List<QueryType> type) {
        List<QueryType> list = new ArrayList<>();
        String query = "";
        for (QueryType item : type) {
            if (item.isIncluded()) {
                list.add(item );

            }

        }
       return list;


    }

}
