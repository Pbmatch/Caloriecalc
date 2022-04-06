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
import com.calorie.calc.fragments.recipe.holders.RecipeSearchItem;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.utils.OnClickGesture;

import java.util.ArrayList;
import java.util.List;

public class RecipeInnerDishFragment extends RecipeListFragment<RecipeAndLinksItem> {

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
            recipeRecipient.getRecipe(true);
            isLoading.set(true);


        }

        RecipeState.getDietType().observe(getViewLifecycleOwner(), new Observer<DietMainPageType>() {
            @Override
            public void onChanged(DietMainPageType dietMainPageType) {

                if (recipeRecipient.getType().getDietType().equals(dietMainPageType)) return;
                type.setDietPlanAndBuild(dietMainPageType);
                recipeRecipient.setType(type);
                recipeRecipient.setReloadContent(true);
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
        RecipeState.getOnRefreshMainRecipe().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                System.out.println("getOnRefreshMainRecipe().observe");
                if(aBoolean){
                    reloadContent();
                    RecipeState.getOnRefreshMainRecipe().postValue(false);
                }

            }
        });
        textViewTitle = rootView.findViewById(R.id.recipe_inner_textViewTitle);

        textViewText = rootView.findViewById(R.id.recipe_inner_textViewText);
        textViewTitle.setVisibility(View.INVISIBLE);
        textViewText.setVisibility(View.INVISIBLE);
        textViewTitle.setText(textTitle);
        textViewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                itemsList.setLayoutManager(layoutManager );
                infoListAdapter.setUseRecipeHorizontalItem(false);
               recipeSearch.getValue().setHits(infoListAdapter.getItemsList());*/
                NavigationHelper.openRecipeVerticalMainFragment(getParentFragment().getParentFragmentManager(), new RecipeVerticalFragment( recipeSearch,type));
            }
        });

    }

    @Override
    public ViewBinding getListHeader() {
        return null;
    }

    @Override
    protected ViewBinding getListFooter() {
        return PignateHorizontalFooterBinding.inflate(getActivity().getLayoutInflater(), itemsList, false);
    }

    @Override
    public void setListener() {
        if(recipeSearch!=null)
        recipeSearch.observe(getViewLifecycleOwner(), new Observer<List<RecipeSearchItem>>() {
            @Override
            public void onChanged(List<RecipeSearchItem> listRecipeSearchItems) {
                if(textViewTitle.getVisibility()==View.INVISIBLE)
                {
                textViewTitle.setVisibility(View.VISIBLE);
                textViewText.setVisibility(View.VISIBLE);
                }
                List<RecipeAndLinksItem> recipeAndLinkItems =new ArrayList<>();
                for(RecipeSearchItem itemRec: listRecipeSearchItems)
                {
                    recipeAndLinkItems.addAll(itemRec.getHits());
                }



                if (recipeAndLinkItems.size() == 0) {
                    ViewBinding viewBinding = ListRecipeHeaderItemBinding
                            .inflate(getLayoutInflater(), itemsList, false);
                    infoListAdapter.setHeader(viewBinding.getRoot());
                } else {
                    infoListAdapter.setHeader(null);
                }
               if(!recipeRecipient.isReloadContent()){
                for (RecipeAndLinksItem item: recipeAndLinkItems)
                {

                    if(!infoListAdapter.getItemsList().contains(item))
                    {infoListAdapter.addItemToItemList(item,infoListAdapter.getItemsList().size());}
                }
               }
               else
               {
                   infoListAdapter.setInfoItemList(recipeAndLinkItems);
                   recipeRecipient.setReloadContent(false);
               }


                    isLoading.set(false);


                showListFooter(false);
            }

        });


        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinksItem>() {
            @Override
            public void selected(RecipeAndLinksItem selectedItem) {
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
        recipeRecipient.setReloadContent(true);
        recipeRecipient.getRecipe(false);
    }
}
