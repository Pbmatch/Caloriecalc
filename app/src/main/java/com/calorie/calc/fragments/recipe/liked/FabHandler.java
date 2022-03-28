package com.calorie.calc.fragments.recipe.liked;

import android.content.Context;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FabHandler {
    public  static void fabClickState(RecipeAndLinksItem recipeAndLinksItem, Context context, FloatingActionButton fab)
    {



        if(!recipeAndLinksItem.isLiked())
        {
            fab.setImageDrawable(context.getDrawable(R.drawable.favorite));
            recipeAndLinksItem.setLiked(true);
            if( RecipeState.getRecipeAndLinksMutableLiveData().getValue()==null)
                RecipeState.getRecipeAndLinksMutableLiveData().setValue(new ArrayList<>());
            RecipeState.getRecipeAndLinksMutableLiveData().getValue().add(recipeAndLinksItem);
        }
        else
        {
            fab.setImageDrawable(context.getDrawable(R.drawable.favoriteblank));
            recipeAndLinksItem.setLiked(false);
            if( RecipeState.getRecipeAndLinksMutableLiveData().getValue()==null)
                RecipeState.getRecipeAndLinksMutableLiveData().setValue(new ArrayList<>());
            RecipeState.getRecipeAndLinksMutableLiveData().getValue().remove(recipeAndLinksItem);
        }
    }
    public  static boolean getFabState(RecipeAndLinksItem recipeAndLinksItem) {
        if (RecipeState.getRecipeAndLinksMutableLiveData().getValue() != null) {
            List<RecipeAndLinksItem> list = RecipeState.getRecipeAndLinksMutableLiveData().getValue();
            for (RecipeAndLinksItem item : list) {
                if (item.getRecipe().getLabel().equals(recipeAndLinksItem.getRecipe().getLabel()))
                    return true;
            }


        }
        return false;
    }

}
