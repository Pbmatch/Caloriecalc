package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;

import java.util.List;

public class RecipeInnerAddedDishFragment extends RecipeInnerHorizFragment<RecipeAndLinks>{

    static private  MutableLiveData<List<RecipeAndLinks>> likedRecipeState = new MutableLiveData<List<RecipeAndLinks>>();
    public RecipeInnerAddedDishFragment(RecipeMainType type) {
        super(type);
    }

    @Override
    void startLoadData() {
        likedRecipeState.observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinks>>() {
            @Override
            public void onChanged(List<RecipeAndLinks> recipeAndLinks) {
                if(recipeAndLinks.size()==0)
                {
                    ViewBinding viewBinding = ListRecipeHeaderItemBinding
                            .inflate(getLayoutInflater(), itemsList, false);
                    infoListAdapter.setHeader(viewBinding.getRoot());
                }
                else {infoListAdapter.setHeader(null);
                }
                infoListAdapter.addInfoItemList(recipeAndLinks);
            }
        });
    }

    @Override
    void setListener() {

    }

    @Override
    boolean isHorizontalItem() {
        return true;
    }

    @Override
    int getLayoutManagerOrientation() {
        return LinearLayoutManager.HORIZONTAL;
    }
}
