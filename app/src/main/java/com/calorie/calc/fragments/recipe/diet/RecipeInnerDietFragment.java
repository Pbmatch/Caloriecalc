package com.calorie.calc.fragments.recipe.diet;

import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.RecipeListFragment;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.RecipeType;
import com.calorie.calc.utils.OnClickGesture;

import java.util.ArrayList;
import java.util.List;

public class RecipeInnerDietFragment extends RecipeListFragment<DietType> {
    List<DietType> dietTypes = new ArrayList<>();
    TextView textViewtext;
    public RecipeInnerDietFragment(RecipeType type) {
        super(type);
    }

    @Override
    public void startLoadData() {
     if( dietTypes .isEmpty()){
        dietTypes.add(DietType.ALL);
        dietTypes.add(DietType.GLUTEN_FREE);
        dietTypes.add(DietType.KETOGONIC);
        dietTypes.add(DietType.VEGAN );
        dietTypes.add(DietType. VEGATARIAN);
        dietTypes.add(DietType. PESTERIAN);
        dietTypes.add(DietType.  PALEO );}
        infoListAdapter.setInfoItemList(dietTypes);
    }

    @Override
    public void setListener() {
     infoListAdapter.setOnItemSelectedListener(new OnClickGesture<DietType>() {
         @Override
         public void selected(DietType selectedItem) {

            // RecipeState.getDietType().setValue(selectedItem);
            NavigationHelper.openDietFragment(getActivity().getSupportFragmentManager(),new DietFragment(selectedItem));
         }
     });

        RecipeState.getDietType().observe(getViewLifecycleOwner(), new Observer<DietType>() {
            @Override
            public void onChanged(DietType dietType) {
                infoListAdapter.notifyDataSetChanged();
            }
        });



    }

    @Override
    public  boolean isHorizontalItem() {
        return true;
    }

    @Override
    public  int getLayoutManagerOrientation() {
        return LinearLayoutManager.HORIZONTAL;
    }

    @Override
    public void initViews(View rootView) {
        textViewtext=rootView.findViewById(R.id. recipe_inner_textViewText);
        textViewtext.setVisibility(View.GONE);
    }
}
