package com.calorie.calc.fragments.recipe.liked;

import android.content.Context;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FabHandler {
    public  static void fabClickState(RecipeAndLinks recipeAndLinks, Context context, FloatingActionButton fab)
    {



        if(!recipeAndLinks.isLiked())
        {
            fab.setImageDrawable(context.getDrawable(R.drawable.favorite));
            recipeAndLinks.setLiked(true);
            if( RecipeState.getRecipeAndLinksMutableLiveData().getValue()==null)
                RecipeState.getRecipeAndLinksMutableLiveData().setValue(new ArrayList<>());
            RecipeState.getRecipeAndLinksMutableLiveData().getValue().add(recipeAndLinks);
        }
        else
        {
            fab.setImageDrawable(context.getDrawable(R.drawable.favoriteblank));
            recipeAndLinks.setLiked(false);
            if( RecipeState.getRecipeAndLinksMutableLiveData().getValue()==null)
                RecipeState.getRecipeAndLinksMutableLiveData().setValue(new ArrayList<>());
            RecipeState.getRecipeAndLinksMutableLiveData().getValue().remove(recipeAndLinks);
        }
    }
    public  static boolean getFabState(RecipeAndLinks recipeAndLinks) {
        if (RecipeState.getRecipeAndLinksMutableLiveData().getValue() != null) {
            List<RecipeAndLinks> list = RecipeState.getRecipeAndLinksMutableLiveData().getValue();
            for (RecipeAndLinks item : list) {
                if (item.getRecipe().getLabel().equals(recipeAndLinks.getRecipe().getLabel()))
                    return true;
            }


        }
        return false;
    }

}
