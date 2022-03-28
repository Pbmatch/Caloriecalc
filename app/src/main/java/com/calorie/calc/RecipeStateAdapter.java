package com.calorie.calc;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;

import java.util.List;

public class RecipeStateAdapter {
    static private MutableLiveData<List<RecipeAndLinksItem>> recipeState = new MutableLiveData<List<RecipeAndLinksItem>>();

    public static MutableLiveData<List<RecipeAndLinksItem>> getRecipeState() {
        return recipeState;
    }
}
