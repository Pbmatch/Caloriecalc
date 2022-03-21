package com.calorie.calc.fragments.recipe.filter;

import static com.calorie.calc.utils.MeasureUtils.getDishCount;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.RecipeVerticalFragment;
import com.calorie.calc.fragments.recipe.holders.RecipeSearch;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.query.QueryHandler;
import com.calorie.calc.fragments.recipe.query.QueryType;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.utils.OnClickGesture;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterVerticalFragment extends RecipeVerticalFragment  {

    FlexboxLayout flexboxLayout;
    boolean observer=false;
    Map<String, Object> build;

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

       /* if (infoListAdapter == null || infoListAdapter.getItemsList() == null || infoListAdapter.getItemsList().size() == 0) {
            QueryHandler queryHandler = RecipeState.getQueryLiveData().getValue();

            System.out.println("startLoadData()");
            recipeRecipient.getRecipe(  queryHandler.build(),true);
        }*/
    }

    @Override
    public  void setListener() {
        recipeSearch.observe(getViewLifecycleOwner(),new Observer<List<RecipeSearch>>() {
            @Override
            public void onChanged(List<RecipeSearch> listRecipeSearch) {

                List<RecipeAndLinks> recipeAndLinks = new ArrayList<>();
                for (RecipeSearch itemRec : listRecipeSearch) {
                    recipeAndLinks.addAll(itemRec.getHits());
                }


                System.out.println(" public void onChangedVert" + recipeAndLinks.size());
                if(!recipeRecipient.isReloadContent()){
                    for (RecipeAndLinks item:recipeAndLinks)
                    {

                        if(!infoListAdapter.getItemsList().contains(item))
                        {infoListAdapter.addItemToItemList(item,infoListAdapter.getItemsList().size());}
                    }
                }
                else
                {
                    infoListAdapter.setInfoItemList(recipeAndLinks);
                    recipeRecipient.setReloadContent(false);
                }

                isLoading.set(false);

                if (listRecipeSearch.size() > 0){
                    RecipeSearch item = listRecipeSearch.get(listRecipeSearch.size()-1);
                    if (item.getCount() == 0) {
                        emptyLinearLayout.setVisibility(View.VISIBLE);
                    } else {
                        emptyLinearLayout.setVisibility(View.GONE);
                    }

                    textView.setText(getDishCount(getContext(), item.getCount()));
                }

            }


        });

        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinks>() {
            @Override
            public void selected(RecipeAndLinks selectedItem) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(), new NavigationFragment(selectedItem));
            }
        });

        RecipeState.getQueryLiveData().observe(getViewLifecycleOwner(), new Observer<QueryHandler>() {
            @Override
            public void onChanged(QueryHandler queryHandler) {
                if(build==null||!build.equals(queryHandler.build()))
                {
                    build= queryHandler.build();
                    recipeRecipient.setReloadContent(true);
                    recipeRecipient.getRecipe(  queryHandler.build(),true);
                }

                setView(flexboxLayout,queryHandler.getListForButton());
            }
        });
        super.setListener();

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
    @Override
    public void loadMoreItems() {
        System.out.println("loadMoreItems()");
        if(!isLoading.get())
        {
            QueryHandler queryHandler = RecipeState.getQueryLiveData().getValue();
            recipeRecipient.getRecipe(  queryHandler.build(),true);
            showListFooter(true);
            isLoading.set(true);
        }

    }

    @Override
    public void reloadContent() {
        System.out.println("reloadContent()()");
        recipeRecipient.setReloadContent(true);
        QueryHandler queryHandler = RecipeState.getQueryLiveData().getValue();
        recipeRecipient.getRecipe(  queryHandler.build(),true);
        swipeRefreshLayout.setRefreshing(false);
    }
}