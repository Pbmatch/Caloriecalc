package com.calorie.calc.spoonacular.network;


import com.calorie.calc.spoonacular.client.model.InlineResponse200;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface IRetrofitInterface {

   /* @GET("api.php?method=appOpen")
    Call<Object> getData(@Header("APP-DEVICE") String appDevice
                              , @Header("APP-PACKAGE") String appPackage
                              , @Header("APP-VERSION") String appVersion
                              , @Header("APP-LOCALE") String appLocale
                           );

    @GET("api.php?method=activateCode")
    Call<Object> activateCode(
            @Header("APP-DEVICE") String appDevice
            , @Header("APP-PACKAGE") String appPackage
            , @Header("APP-VERSION") String appVersion
            , @Header("APP-LOCALE") String appLocale,
            @Query("code") String code);
*/
    @GET("recipes/complexSearch")
    Call<InlineResponse200> recipe(
            @Header("Accept") String applicationJson,
            @Query("apiKey") String apiKey,
            @QueryMap Map<String, String> options);

}
