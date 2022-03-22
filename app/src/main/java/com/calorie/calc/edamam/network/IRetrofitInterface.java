package com.calorie.calc.edamam.network;


import com.calorie.calc.fragments.recipe.holders.RecipeSearch;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface IRetrofitInterface {


    @GET("api/recipes/v2")
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

    @GET
    Call<RecipeSearch> recipeNextPage(
            @Url String url
    );
    @GET("auto-complete")
    Call<List<String>> getAutoText(
            @Query("app_id") String appFoodId,
            @Query("app_key") String appFoodKey,
             @Query("q") String query,
            @Query("limit") String limit
    );

    @GET("api/recipes/v2/{id}")
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
