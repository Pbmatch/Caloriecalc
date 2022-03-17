package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.fragments.recipe.diet.DietMainPageType;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.query.QueryHandler;

import java.util.List;

public class RecipeState {
    public static MutableLiveData<List<RecipeAndLinks>> recipeAndLinksMutableLiveData = new MutableLiveData<>();
    public static MutableLiveData<Boolean> progressBar = new MutableLiveData<>();
    public static MutableLiveData<List<RecipeAndLinks>> productLiveData = new MutableLiveData<>();
    public static MutableLiveData<QueryHandler> queryLiveData = new MutableLiveData<>();
    public static MutableLiveData<DietMainPageType> dietType = new MutableLiveData<>();
    public static MutableLiveData<Boolean> onRefreshMainRecipe = new MutableLiveData<>();
    public static MutableLiveData<Boolean> openFindFragment = new MutableLiveData<>();

    public static MutableLiveData<Boolean> getOnRefreshMainRecipe() {
        return onRefreshMainRecipe;
    }

    public static MutableLiveData<List<RecipeAndLinks>> getRecipeAndLinksMutableLiveData() {
        return recipeAndLinksMutableLiveData;
    }

    public static MutableLiveData<DietMainPageType> getDietType() {
        return dietType;
    }

    public static MutableLiveData<Boolean> getProgressBar() {
        return progressBar;
    }

    public static MutableLiveData<List<RecipeAndLinks>> getProductLiveData() {
        return productLiveData;
    }

    public static MutableLiveData<Boolean> getOpenFindFragment() {
        return openFindFragment;
    }

    public static MutableLiveData<QueryHandler> getQueryLiveData() {
        if (queryLiveData.getValue() == null)
            queryLiveData.setValue(new QueryHandler());

        return queryLiveData;
    }

}
