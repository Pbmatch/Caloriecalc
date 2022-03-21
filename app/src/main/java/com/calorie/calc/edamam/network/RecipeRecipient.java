package com.calorie.calc.edamam.network;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.RecipeType;
import com.calorie.calc.fragments.recipe.holders.RecipeSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipeRecipient extends Recipient {

    MutableLiveData<List<RecipeSearch>> listRecipeSearch;
    RecipeType type;
    boolean reloadContent = false;

    public RecipeRecipient(Context context, MutableLiveData<List<RecipeSearch>> listRecipeSearch, RecipeType type) {
        super(context);
        this.listRecipeSearch = listRecipeSearch;
        this.type = type;
    }

    String APP_KEY_RECIPE = "df47a981d80b7d7f5c1deb614701691c";
    String APP_ID_RECIPE = "4772da4b";
    String APP_KEY_FOOD = "3fb0249a92fd83b77bb0f3e57d62a8e8";
    String APP_ID_FOOD = "df7288a0";
    private Callback<RecipeSearch> callback;
    private Callback<ResponseBody> callback222;

    public RecipeRecipient(Context context) {
        super(context);


    }

    public boolean isReloadContent() {
        return reloadContent;
    }

    public void setReloadContent(boolean reloadContent) {
        this.reloadContent = reloadContent;
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

                    List<RecipeSearch> recipeSearchList;
                    recipeSearchList=listRecipeSearch.getValue();



                    if (recipeSearchList == null||reloadContent)
                    {
                        recipeSearchList=new ArrayList<>();
                    }
                    if(!recipeSearchList.contains(recipeSearch)) {
                        recipeSearchList.add(recipeSearch);

                        listRecipeSearch.postValue(recipeSearchList);
                    }



                } else {
                    try {
                        System.out.println("onResponceError" + response.errorBody().string() + response.message() + call.toString());
                        System.out.println("onResponceErrorUrl" +   response.raw().request().url() );
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
    /*    callback222 = new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                RecipeState.getProgressBar().setValue(false);
                if (response.body() != null) {

                  //  RecipeSearch recipeSearch= response.body();
                    try {
                        System.out.println("onResponce" + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //  recipeState.postValue(recipeSearch);

                } else {
                    try {
                        System.out.println("onResponceError" + response.errorBody().string() + response.message() + call.toString());
                        System.out.println("onResponceErrorUrl" +   response.raw().request().url() );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                RecipeState.getProgressBar().setValue(false);
                System.out.println("onFailure" + t.toString());
            }
        };*/

    }
    public void getRecipe(String url) {
        RecipeState.getProgressBar().setValue(true);

        url = url.replaceAll(BASEURL,"");


        retrofitInterface.recipeNextPage(url).enqueue(callback);
    }


    public void getRecipe(boolean showGlobalProgressBar) {
        if (!connectOk()) {
            return;
        }


        RecipeState.getProgressBar().setValue(showGlobalProgressBar);
      //   param.put("ingr", "chicken");
         retrofitInterface.recipe(APP_ID_RECIPE, APP_KEY_RECIPE, type.getParams()).enqueue(callback);
      //  retrofitInterface.recipeId("recipe_04d73a0b27e84a6680cd370eeecbb636",APP_ID, APP_KEY, param).enqueue(callback);
      //  retrofitInterface.foodParser(APP_ID_FOOD, APP_KEY_FOOD, param).enqueue(callback);
    }
    public void getRecipe(Map<String, Object> params, boolean showGlobalProgressBar) {
        if (!connectOk()) {
            return;
        }
        RecipeState.getProgressBar().setValue(showGlobalProgressBar);

        String query = "";
        for(Map.Entry m:params.entrySet()) {

            if (m.getValue() instanceof List){

            for (String id : (List<String>) m.getValue()) {
                query += m.getKey() +"="+ id  + "&";
            }



        }
            if  (m.getValue() instanceof String)
            {
                query+=m.getKey()+"="+(String)m.getValue()  + "&";
            }
        }
        query+="type"+"="+"public"  + "&";
        query+="random"+"="+"true"  + "&";
        query ="recipes/v2?"+query;
        query = query.substring(0, query.length() - 1);

        retrofitInterface.recipeFilter(query,APP_ID_RECIPE, APP_KEY_RECIPE).enqueue(callback);

    }
    @Override
    protected void onNetwork() {
      //  if (!callBackOk) getRecipe();
    }


}
