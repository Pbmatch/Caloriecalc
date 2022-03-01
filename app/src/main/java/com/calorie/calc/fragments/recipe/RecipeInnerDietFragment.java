package com.calorie.calc.fragments.recipe;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.utils.OnClickGesture;

import java.util.ArrayList;
import java.util.List;

public class RecipeInnerDietFragment extends RecipeInnerHorizFragment<DietType>{
    public RecipeInnerDietFragment(RecipeMainType type) {
        super(type);
    }

    @Override
    void startLoadData() {
        List<DietType> dietTypes = new ArrayList<>();
        dietTypes.add(DietType.ALL);
        dietTypes.add(DietType.GLUTEN_FREE);
        dietTypes.add(DietType.KETOGONIC);
        dietTypes.add(DietType.VEGAN );
        dietTypes.add(DietType. VEGATARIAN);
        dietTypes.add(DietType. PESTERIAN);
        dietTypes.add(DietType.  PALEO );
        infoListAdapter.addInfoItemList(dietTypes);
    }

    @Override
    void setListener() {
     infoListAdapter.setOnItemSelectedListener(new OnClickGesture<DietType>() {
         @Override
         public void selected(DietType selectedItem) {

            // LikedRecipeState.getDietType().setValue(selectedItem);
            NavigationHelper.openDietFragment(getActivity().getSupportFragmentManager(),new DietFragment(selectedItem));
         }
     });

        LikedRecipeState.getDietType().observe(getViewLifecycleOwner(), new Observer<DietType>() {
            @Override
            public void onChanged(DietType dietType) {
                infoListAdapter.notifyDataSetChanged();
            }
        });

        textViewText.setVisibility(View.GONE);

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
