package com.calorie.calc.fragments.recipe;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.diet.DietMainPageType;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;

public class RecipeInnerDishFragment extends RecipeListFragment<RecipeAndLinks> {

    public TextView textViewTitle;
    public TextView textViewText;
    public String textTitle;


    public RecipeInnerDishFragment(RecipeType type) {
        super(type);
        recipeState = type.getRecipeState();
    }


    @Override
    public void startLoadData() {
        if (recipeRecipient == null)
            recipeRecipient = new RecipeRecipient(getContext(), recipeState, type);

        if (infoListAdapter == null || infoListAdapter.getItemsList() == null || infoListAdapter.getItemsList().size() == 0) {
            recipeRecipient.getRecipe();
        }

        RecipeState.getDietType().observe(getViewLifecycleOwner(), new Observer<DietMainPageType>() {
            @Override
            public void onChanged(DietMainPageType dietMainPageType) {


                if (recipeRecipient.getType().getDietType().equals(dietMainPageType)) return;
                type.setDietPlanAndBuild(dietMainPageType);
                recipeRecipient.setType(type);
                recipeRecipient.getRecipe();
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
                NavigationHelper.openRecipeVerticalMainFragment(getParentFragment().getParentFragmentManager(), new RecipeVerticalFragment(recipeState));
            }
        });

    }

    @Override
    public void setListener() {
        recipeState.observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinks>>() {
            @Override
            public void onChanged(List<RecipeAndLinks> recipeAndLinks) {
                if (recipeAndLinks.size() == 0) {
                    ViewBinding viewBinding = ListRecipeHeaderItemBinding
                            .inflate(getLayoutInflater(), itemsList, false);
                    infoListAdapter.setHeader(viewBinding.getRoot());
                } else {
                    infoListAdapter.setHeader(null);
                }
                infoListAdapter.setInfoItemList(recipeAndLinks);
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
    public boolean isHorizontalItem() {
        return true;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.HORIZONTAL;
    }


}
