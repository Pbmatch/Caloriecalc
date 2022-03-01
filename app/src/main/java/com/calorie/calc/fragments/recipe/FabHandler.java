package com.calorie.calc.fragments.recipe;

import android.content.Context;

import com.calorie.calc.R;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
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
            if( LikedRecipeState.getRecipeAndLinksMutableLiveData().getValue()==null)
                LikedRecipeState.getRecipeAndLinksMutableLiveData().setValue(new ArrayList<>());
            LikedRecipeState.getRecipeAndLinksMutableLiveData().getValue().add(recipeAndLinks);
        }
        else
        {
            fab.setImageDrawable(context.getDrawable(R.drawable.favoriteblank));
            recipeAndLinks.setLiked(false);
            if( LikedRecipeState.getRecipeAndLinksMutableLiveData().getValue()==null)
                LikedRecipeState.getRecipeAndLinksMutableLiveData().setValue(new ArrayList<>());
            LikedRecipeState.getRecipeAndLinksMutableLiveData().getValue().remove(recipeAndLinks);
        }
    }
    public  static boolean getFabState(RecipeAndLinks recipeAndLinks) {
        if (LikedRecipeState.getRecipeAndLinksMutableLiveData().getValue() != null) {
            List<RecipeAndLinks> list = LikedRecipeState.getRecipeAndLinksMutableLiveData().getValue();
            for (RecipeAndLinks item : list) {
                if (item.getRecipe().getLabel().equals(recipeAndLinks.getRecipe().getLabel()))
                    return true;
            }


        }
        return false;
    }

}
