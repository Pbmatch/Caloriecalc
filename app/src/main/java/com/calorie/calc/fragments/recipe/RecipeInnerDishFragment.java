package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.databinding.ListRecipeHeaderItemBinding;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;

public class RecipeInnerDishFragment extends RecipeInnerHorizFragment<RecipeAndLinks>{


    public RecipeInnerDishFragment(RecipeMainType type) {
        super(type);
    }

    @Override
    void startLoadData() {
        RecipeRecipient recipeRecipient = new RecipeRecipient(getContext(),recipeState,type);
        if(infoListAdapter==null||infoListAdapter.getItemsList()==null||infoListAdapter.getItemsList().size()==0)
        {// recipeRecipient.getRecipe();}
        }

        LikedRecipeState.getDietType().observe(getViewLifecycleOwner(), new Observer<DietType>() {
            @Override
            public void onChanged(DietType dietType) {
                System.out.println(" LikedRecipeState.getDietType().observe");

                type.build(dietType.getMap());
                recipeRecipient.setType(type);
                recipeRecipient.getRecipe();
            }
        });
    }

    @Override
    void setListener() {
        recipeState.observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinks>>() {
            @Override
            public void onChanged(List<RecipeAndLinks> recipeAndLinks) {
                if(recipeAndLinks.size()==0)
                {
                    ViewBinding viewBinding = ListRecipeHeaderItemBinding
                            .inflate(getLayoutInflater(), itemsList, false);
                    infoListAdapter.setHeader(viewBinding.getRoot());
                }
                else {infoListAdapter.setHeader(null);}
                infoListAdapter.setInfoItemList(recipeAndLinks);
            }
        });
        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinks>() {
            @Override
            public void selected(RecipeAndLinks selectedItem) {
                NavigationHelper.openDietFragment(getActivity().getSupportFragmentManager(),new ScrollingFragment(selectedItem));
            }
        });
    }

    @Override
    boolean isHorizontalItem() {
        return true;
    }

    @Override
    int getLayoutManagerOrientation() {
        return LinearLayoutManager.HORIZONTAL;
    }


}
