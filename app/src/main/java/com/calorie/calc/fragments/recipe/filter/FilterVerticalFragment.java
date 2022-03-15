package com.calorie.calc.fragments.recipe.filter;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.RecipeVerticalFragment;
import com.calorie.calc.fragments.recipe.holders.RecipeSearch;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.query.QueryHandler;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;
import com.google.android.flexbox.FlexboxLayout;

public class FilterVerticalFragment extends RecipeVerticalFragment implements BackPressable {

    FlexboxLayout flexboxLayout;


    public FilterVerticalFragment( )
    {
        super();

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        flexboxLayout = view.findViewById(R.id.flex_box);
       super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void startLoadData() {
        if (recipeRecipient == null)
            recipeRecipient = new RecipeRecipient(getContext(), recipeSearch, type);

        if (infoListAdapter == null || infoListAdapter.getItemsList() == null || infoListAdapter.getItemsList().size() == 0) {
            QueryHandler queryHandler = new QueryHandler();

            recipeRecipient.getRecipe(  queryHandler.build("chicken"));
        }
    }

    @Override
    public  void setListener() {
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
                infoListAdapter.setInfoItemList(recipeSearch.getHits());
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
        return false;
    }

    @Override
    public  int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void initViews(View rootView) {

    }

    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }
}