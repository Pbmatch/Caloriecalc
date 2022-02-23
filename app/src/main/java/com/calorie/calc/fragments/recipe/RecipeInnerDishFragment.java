package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;


import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.edamam.network.RecipeRecipient;

import java.util.List;

public class RecipeInnerDishFragment extends RecipeInnerHorizFragment<RecipeAndLinks>{


    public RecipeInnerDishFragment(RecipeMainType type) {
        super(type);
    }

    @Override
    void startLoadData() {
        RecipeRecipient recipeRecipient = new RecipeRecipient(getContext(),recipeState,type);
        recipeRecipient.getRecipe();
    }

    @Override
    void setListener() {
        recipeState.observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinks>>() {
            @Override
            public void onChanged(List<RecipeAndLinks> recipeAndLinks) {
                if(recipeAndLinks.size()==0)
                {
                    ViewBinding viewBinding = ListRecipeHeaderItemBinding
                            .inflate(getLayoutInflater(), itemsList, false);
                    infoListAdapter.setHeader(viewBinding.getRoot());
                }
                else {infoListAdapter.setHeader(null);}
                infoListAdapter.addInfoItemList(recipeAndLinks);
            }
        });
    }


}
