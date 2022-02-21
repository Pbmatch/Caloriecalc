package com.calorie.calc.edamam.network;


import android.content.Context;

import com.calorie.calc.edamam.holders.RecipeSearch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipeRecipient extends Recipient {


    String APP_KEY_RECIPE = "df47a981d80b7d7f5c1deb614701691c";
    String APP_ID_RECIPE = "4772da4b";
    String APP_KEY_FOOD = "3fb0249a92fd83b77bb0f3e57d62a8e8";
    String APP_ID_FOOD = "df7288a0";
    private Callback<RecipeSearch> callback;


    public RecipeRecipient(Context context) {
        super(context);


    }


    @Override
    protected void setCallBack() {
        callback = new Callback<RecipeSearch>() {
            @Override
            public void onResponse(Call<RecipeSearch> call, Response<RecipeSearch> response) {
                if (response.body() != null) {
                    RecipeSearch recipeSearch= response.body();
                    System.out.println("onResponce" + recipeSearch.getCount()+"onResponceSize"+recipeSearch.getHits().size());

                } else {
                    try {
                        System.out.println("onResponceError" + response.errorBody().string() + response.message());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<RecipeSearch> call, Throwable t) {
                System.out.println("onFailure" + t.toString());
            }
        };

    }


    public void getRecipe() {
        if (!connectOk()) {
            return;
        }
        Map<String, String> param = new HashMap<>();
         param.put("type", "public");
         param.put("q", "chicken");
      //   param.put("ingr", "chicken");
         retrofitInterface.recipe(APP_ID, APP_KEY, param).enqueue(callback);
      //  retrofitInterface.recipeId("recipe_04d73a0b27e84a6680cd370eeecbb636",APP_ID, APP_KEY, param).enqueue(callback);
      //  retrofitInterface.foodParser(APP_ID_FOOD, APP_KEY_FOOD, param).enqueue(callback);
    }

    @Override
    protected void onNetwork() {
      //  if (!callBackOk) getRecipe();
    }


}
