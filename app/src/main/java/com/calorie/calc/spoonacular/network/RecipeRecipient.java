package com.calorie.calc.spoonacular.network;


import android.content.Context;

import com.calorie.calc.spoonacular.client.model.InlineResponse200;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipeRecipient extends Recipient {


    String API_KEY = "a9eeb753d8ec41af9d2a4fb5bacf29a2";
    private Callback<InlineResponse200> callback;



    public RecipeRecipient(Context context  ) {
        super(context);


    }


    @Override
    protected void setCallBack() {
        callback = new Callback<InlineResponse200>() {
            @Override
            public void onResponse(Call<InlineResponse200> call, Response<InlineResponse200> response) {
                System.out.println("onResponce" + response.body().toString());

            }

            @Override
            public void onFailure(Call<InlineResponse200> call, Throwable t) {
                System.out.println("onFailure" + t.toString());
            }
        };

    }


    public void getRecipe() {
        if (!connectOk()  ) {
            return;
        }
        Map<String,String> param = new HashMap<>();
        param.put("query","pasta");
        param.put("maxFat","25");

        retrofitInterface.recipe("application/json",API_KEY,param).enqueue(callback);
    }

    @Override
    protected void onNetwork() {
       if(!callBackOk) getRecipe();
    }


}
