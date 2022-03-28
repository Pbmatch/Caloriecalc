package com.calorie.calc.fragments.recipe;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;

import java.util.List;

public class RecipeInnerAddedDishFragment extends RecipeListFragment<RecipeAndLinksItem> {

    static private  MutableLiveData<List<RecipeAndLinksItem>> likedRecipeState = new MutableLiveData<List<RecipeAndLinksItem>>();
    public RecipeInnerAddedDishFragment(RecipeType type) {
        super(type);
    }

    @Override
    public  void startLoadData() {
        likedRecipeState.observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinksItem>>() {
            @Override
            public void onChanged(List<RecipeAndLinksItem> recipeAndLinkItems) {
                if(recipeAndLinkItems.size()==0)
                {
                    ViewBinding viewBinding = ListRecipeHeaderItemBinding
                            .inflate(getLayoutInflater(), itemsList, false);
                    infoListAdapter.setHeader(viewBinding.getRoot());
                }
                else {infoListAdapter.setHeader(null);
                }
                infoListAdapter.addInfoItemList(recipeAndLinkItems);

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
    public void loadMoreItems() {

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
