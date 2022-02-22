package com.calorie.calc;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;

import java.util.List;

public class RecipeStateAdapter {
    static private MutableLiveData<List<RecipeAndLinks>> recipeState = new MutableLiveData<List<RecipeAndLinks>>();

    public static MutableLiveData<List<RecipeAndLinks>> getRecipeState() {
        return recipeState;
    }
}
