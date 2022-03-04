package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.diet.DietType;

import java.util.List;

public class RecipeState {
    public static    MutableLiveData<List<RecipeAndLinks>> recipeAndLinksMutableLiveData = new MutableLiveData<>();
    public static    MutableLiveData<Boolean> progressBar = new MutableLiveData<>();
    public static    MutableLiveData<List<RecipeAndLinks>> productLiveData = new MutableLiveData<>();

    public static    MutableLiveData<DietType> dietType = new MutableLiveData<>();
    public static MutableLiveData<List<RecipeAndLinks>> getRecipeAndLinksMutableLiveData() {
        return recipeAndLinksMutableLiveData;
    }
    public static MutableLiveData<DietType> getDietType() {
        return dietType;
    }

    public static MutableLiveData<Boolean> getProgressBar() {
        return progressBar;
    }

    public static MutableLiveData<List<RecipeAndLinks>> getProductLiveData() {
        return productLiveData;
    }


}
