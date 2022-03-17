package com.calorie.calc.fragments.recipe.filter;

import static com.calorie.calc.utils.MeasureUtils.getDishCount;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.RecipeVerticalFragment;
import com.calorie.calc.fragments.recipe.holders.RecipeSearch;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.query.QueryHandler;
import com.calorie.calc.fragments.recipe.query.QueryType;
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
            QueryHandler queryHandler = RecipeState.getQueryLiveData().getValue();

            recipeRecipient.getRecipe(  queryHandler.build());
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
                textView.setText(getDishCount(getContext(),recipeSearch.getCount()));
                infoListAdapter.setInfoItemList(recipeSearch.getHits());

            }

        });
        RecipeState.getQueryLiveData().observe(getViewLifecycleOwner(), new Observer<QueryHandler>() {
            @Override
            public void onChanged(QueryHandler queryHandler) {

                recipeRecipient.getRecipe(  queryHandler.build());
                setView(flexboxLayout,queryHandler.getListForButton());
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

    void setView( FlexboxLayout view, List<QueryType> list) {
        view.removeAllViews();

        for (QueryType type : list) {
            if (type.getButton(getContext()).getParent() != null) {
                ((ViewGroup) type.getButton(getContext()).getParent()).removeView(type.getButton(getContext())); // <- fix
            }
            type.getButton(getContext()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    type.setInclude(false);
                    ((ViewGroup) type.getButton(getContext()).getParent()).removeView(type.getButton(getContext())); // <- fix
                    reloadContent();


                }
            });

            view.addView(type.getButton(getContext()));


        }
    }

    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }
    @Override
    public void reloadContent() {
        QueryHandler queryHandler = RecipeState.getQueryLiveData().getValue();
        recipeRecipient.getRecipe(  queryHandler.build());
        swipeRefreshLayout.setRefreshing(false);
    }
}