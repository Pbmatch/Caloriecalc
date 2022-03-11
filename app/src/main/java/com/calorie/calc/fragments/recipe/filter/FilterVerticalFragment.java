package com.calorie.calc.fragments.recipe.filter;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.RecipeVerticalFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.query.QueryHandler;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;
import com.google.android.flexbox.FlexboxLayout;

import java.util.List;

public class FilterVerticalFragment extends RecipeVerticalFragment implements BackPressable {

    FlexboxLayout flexboxLayout;
    public FilterVerticalFragment( )
    {
        super();
        recipeState = new MutableLiveData<>();
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
            recipeRecipient = new RecipeRecipient(getContext(), recipeState, type);

        if (infoListAdapter == null || infoListAdapter.getItemsList() == null || infoListAdapter.getItemsList().size() == 0) {
            QueryHandler queryHandler = new QueryHandler();

            recipeRecipient.getRecipe(  queryHandler.build("chicken"));
        }
    }

    @Override
    public  void setListener() {
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