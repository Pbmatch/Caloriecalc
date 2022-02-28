package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;

import java.util.List;

public class LikedRecipeState {
    public static    MutableLiveData<List<RecipeAndLinks>> recipeAndLinksMutableLiveData = new MutableLiveData<>();

    public static MutableLiveData<List<RecipeAndLinks>> getRecipeAndLinksMutableLiveData() {
        return recipeAndLinksMutableLiveData;
    }
}
