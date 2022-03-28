package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.fragments.recipe.diet.DietMainPageType;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.query.QueryHandler;

import java.util.List;

public class RecipeState {
    private static MutableLiveData<List<RecipeAndLinksItem>> recipeAndLinksMutableLiveData = new MutableLiveData<>();
    private static MutableLiveData<Boolean> progressBar = new MutableLiveData<>();
    private static MutableLiveData<List<RecipeAndLinksItem>> productLiveData = new MutableLiveData<>();
    private static MutableLiveData<QueryHandler> queryLiveData = new MutableLiveData<>();
    private static MutableLiveData<DietMainPageType> dietType = new MutableLiveData<>();
    private static MutableLiveData<Boolean> onRefreshMainRecipe = new MutableLiveData<>();
    private static MutableLiveData<Boolean> openFindFragment = new MutableLiveData<>();

    public static MutableLiveData<Boolean> getOnRefreshMainRecipe() {
        return onRefreshMainRecipe;
    }

    public static MutableLiveData<List<RecipeAndLinksItem>> getRecipeAndLinksMutableLiveData() {
        return recipeAndLinksMutableLiveData;
    }

    public static MutableLiveData<DietMainPageType> getDietType() {
        return dietType;
    }

    public static MutableLiveData<Boolean> getProgressBar() {
        return progressBar;
    }

    public static MutableLiveData<List<RecipeAndLinksItem>> getProductLiveData() {
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
