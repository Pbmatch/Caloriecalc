package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.databinding.PignateFooterBinding;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.holders.RecipeSearch;

import java.util.List;


public abstract class RecipeListFragment<T> extends ListFragment<T>{



    public RecipeType type;
    public  RecipeRecipient recipeRecipient;
    public MutableLiveData<List< RecipeSearch>> recipeSearch= new MutableLiveData<>();

    public RecipeListFragment(RecipeType type) {

        this.type = type;
    }

    public RecipeListFragment(MutableLiveData<List< RecipeSearch>> recipeSearch  ,RecipeType type) {
        this.type = type;
        this.recipeSearch = recipeSearch;
    }
    public RecipeListFragment( ) {


    }


    @Override
    protected ViewBinding getListFooter() {
        return PignateFooterBinding.inflate(getActivity().getLayoutInflater(), itemsList, false);
    }
    public void setLoading(boolean bool)
    {
        showListFooter(bool);
    }

}