package com.calorie.calc.edamam.network;


import com.calorie.calc.fragments.recipe.holders.RecipeSearch;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface IRetrofitInterface {


    @GET("recipes/v2")
    Call<RecipeSearch> recipe(

            @Query("app_id") String appId,
            @Query("app_key") String appKey,
            @QueryMap  Map<String, Object> options);
    @GET
    Call<RecipeSearch> recipeFilter(
            @Url String url,
            @Query("app_id") String appId,
            @Query("app_key") String appKey
         );


    @GET("recipes/v2/{id}")
    Call<ResponseBody> recipeId(
                @Path("id") String id,
            @Query("app_id") String appId,
            @Query("app_key") String appKey,
            @QueryMap(encoded = true) Map<String, String> options);
    @GET("food-database/v2/parser")
    Call<ResponseBody> foodParser(
            @Query("app_id") String appId,
            @Query("app_key") String appKey,
            @QueryMap Map<String, String> options);

}
