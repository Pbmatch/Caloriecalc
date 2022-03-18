package com.calorie.calc.fragments.recipe;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.databinding.PignateHorizontalFooterBinding;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.diet.DietMainPageType;
import com.calorie.calc.fragments.recipe.holders.RecipeSearch;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.utils.OnClickGesture;

public class RecipeInnerDishFragment extends RecipeListFragment<RecipeAndLinks> {

    public TextView textViewTitle;
    public TextView textViewText;
    public String textTitle;
    DietMainPageType dietMainPageTy;

    public RecipeInnerDishFragment(RecipeType type) {
        super(type);
        recipeSearch = new MutableLiveData<>();

    }


    @Override
    public void startLoadData() {
        if (recipeRecipient == null)
            recipeRecipient = new RecipeRecipient(getContext(), recipeSearch, type);

        if (infoListAdapter == null || infoListAdapter.getItemsList() == null || infoListAdapter.getItemsList().size() == 0) {
            recipeRecipient.getRecipe(false);
            showListFooter(true);
        }

        RecipeState.getDietType().observe(getViewLifecycleOwner(), new Observer<DietMainPageType>() {
            @Override
            public void onChanged(DietMainPageType dietMainPageType) {

                if (recipeRecipient.getType().getDietType().equals(dietMainPageType)) return;
                type.setDietPlanAndBuild(dietMainPageType);
                recipeRecipient.setType(type);
                System.out.println("getDietType().observe()Horizontal");
                recipeRecipient.getRecipe(true);
            }
        });
    }

    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);
        if (type != null)
            this.textTitle = getString(type.getTitleRecource());

    }

    public void initViews(View rootView) {

        textViewTitle = rootView.findViewById(R.id.recipe_inner_textViewTitle);
        textViewText = rootView.findViewById(R.id.recipe_inner_textViewText);
        textViewTitle.setText(textTitle);
        textViewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipeSearch.getValue().setHits(infoListAdapter.getItemsList());
                NavigationHelper.openRecipeVerticalMainFragment(getParentFragment().getParentFragmentManager(), new RecipeVerticalFragment(recipeSearch,type));
            }
        });

    }
    @Override
    protected ViewBinding getListFooter() {
        return PignateHorizontalFooterBinding.inflate(getActivity().getLayoutInflater(), itemsList, false);
    }

    @Override
    public void setListener() {
        if(recipeSearch!=null)
        recipeSearch.observe(getViewLifecycleOwner(), new Observer<RecipeSearch>() {
            @Override
            public void onChanged(RecipeSearch recipeSearch) {

                if (recipeSearch.getHits().size() == 0) {
                    ViewBinding viewBinding = ListRecipeHeaderItemBinding
                            .inflate(getLayoutInflater(), itemsList, false);
                    infoListAdapter.setHeader(viewBinding.getRoot());
                } else {
                    infoListAdapter.setHeader(null);
                }
                if(isLoading.get())
                {
                    infoListAdapter.addInfoItemList(recipeSearch.getHits());
                    isLoading.set(false);

                }
                else
                    infoListAdapter.setInfoItemList(recipeSearch.getHits());

                showListFooter(false);
            }

        });


        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinks>() {
            @Override
            public void selected(RecipeAndLinks selectedItem) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(), new NavigationFragment(selectedItem));
            }
        });
    }

    @Override
    public void loadMoreItems() {

        if(!isLoading.get())
        {
            System.out.println("loadMoreItems()Horizontal");
            recipeRecipient.getRecipe(false);
            showListFooter(true);
            isLoading.set(true);
        }
    }

    @Override
    public boolean isHorizontalItem() {
        return true;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.HORIZONTAL;
    }


    @Override
    public void reloadContent() {
        System.out.println("reloadcontent()Horizontal");
        recipeRecipient.getRecipe(false);
    }
}
