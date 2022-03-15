package com.calorie.calc.fragments.recipe;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;

import java.util.List;

public class RecipeInnerAddedDishFragment extends RecipeListFragment<RecipeAndLinks> {

    static private  MutableLiveData<List<RecipeAndLinks>> likedRecipeState = new MutableLiveData<List<RecipeAndLinks>>();
    public RecipeInnerAddedDishFragment(RecipeType type) {
        super(type);
    }

    @Override
    public  void startLoadData() {
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
    public void initViews(View rootView)
    {

       /* textViewTitle = rootView.findViewById(R.id.recipe_inner_textViewTitle);
        textViewText = rootView.findViewById(R.id.recipe_inner_textViewText);
        textViewTitle.setText(textTitle);
        textViewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openRecipeVerticalMainFragment(getParentFragment().getParentFragmentManager(),new RecipeVerticalFragment(recipeState));
            }
        });*/

    }
    @Override
    public  void setListener() {

    }

    @Override
    public  boolean isHorizontalItem() {
        return true;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.HORIZONTAL;
    }

    @Override
    public void reloadContent() {

    }
}
