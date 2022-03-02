package com.calorie.calc.edamam.network;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.fragments.recipe.holders.RecipeSearch;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.RecipeType;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipeRecipient extends Recipient {

    MutableLiveData<List<RecipeAndLinks>> recipeState;
    RecipeType type;

    public RecipeRecipient(Context context, MutableLiveData<List<RecipeAndLinks>> recipeState, RecipeType type) {
        super(context);
        this.recipeState = recipeState;
        this.type = type;
    }

    String APP_KEY_RECIPE = "df47a981d80b7d7f5c1deb614701691c";
    String APP_ID_RECIPE = "4772da4b";
    String APP_KEY_FOOD = "3fb0249a92fd83b77bb0f3e57d62a8e8";
    String APP_ID_FOOD = "df7288a0";
    private Callback<RecipeSearch> callback;


    public RecipeRecipient(Context context) {
        super(context);


    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    @Override
    protected void setCallBack() {
        callback = new Callback<RecipeSearch>() {
            @Override
            public void onResponse(Call<RecipeSearch> call, Response<RecipeSearch> response) {
                RecipeState.getProgressBar().setValue(false);
                if (response.body() != null) {

                    RecipeSearch recipeSearch= response.body();
                    System.out.println("onResponce" + recipeSearch.getCount()+"onResponceSize"+recipeSearch.getHits().size());
                    recipeState.postValue(recipeSearch.getHits());

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
                RecipeState.getProgressBar().setValue(false);
                System.out.println("onFailure" + t.toString());
            }
        };

    }


    public void getRecipe() {
        if (!connectOk()) {
            return;
        }
        RecipeState.getProgressBar().setValue(true);
      //   param.put("ingr", "chicken");
         retrofitInterface.recipe(APP_ID_RECIPE, APP_KEY_RECIPE, type.getParams()).enqueue(callback);
      //  retrofitInterface.recipeId("recipe_04d73a0b27e84a6680cd370eeecbb636",APP_ID, APP_KEY, param).enqueue(callback);
      //  retrofitInterface.foodParser(APP_ID_FOOD, APP_KEY_FOOD, param).enqueue(callback);
    }

    @Override
    protected void onNetwork() {
      //  if (!callBackOk) getRecipe();
    }


}
