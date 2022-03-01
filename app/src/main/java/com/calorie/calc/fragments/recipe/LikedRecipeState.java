package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;

import java.util.List;

public class LikedRecipeState {
    public static    MutableLiveData<List<RecipeAndLinks>> recipeAndLinksMutableLiveData = new MutableLiveData<>();
    public static    MutableLiveData<Boolean> progressBar = new MutableLiveData<>();


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
}
