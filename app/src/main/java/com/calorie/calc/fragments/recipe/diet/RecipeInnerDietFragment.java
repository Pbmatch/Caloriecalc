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

public class RecipeInnerDietFragment extends RecipeListFragment<DietMainPageType> {
    List<DietMainPageType> dietMainPageTypes = new ArrayList<>();
    TextView textViewtext;
    public RecipeInnerDietFragment(RecipeType type) {
        super(type);
    }

    @Override
    public void startLoadData() {
     if( dietMainPageTypes.isEmpty()){
        dietMainPageTypes.add(DietMainPageType.ALL);
        dietMainPageTypes.add(DietMainPageType.GLUTEN_FREE);
        dietMainPageTypes.add(DietMainPageType.KETOGONIC);
        dietMainPageTypes.add(DietMainPageType.VEGAN );
        dietMainPageTypes.add(DietMainPageType. VEGATARIAN);
        dietMainPageTypes.add(DietMainPageType. PESTERIAN);
        dietMainPageTypes.add(DietMainPageType.  PALEO );}
        infoListAdapter.setInfoItemList(dietMainPageTypes);
    }

    @Override
    public void setListener() {
     infoListAdapter.setOnItemSelectedListener(new OnClickGesture<DietMainPageType>() {
         @Override
         public void selected(DietMainPageType selectedItem) {

            // RecipeState.getDietType().setValue(selectedItem);
            NavigationHelper.openDietFragment(getActivity().getSupportFragmentManager(),new DietFragment(selectedItem));
         }
     });

        RecipeState.getDietType().observe(getViewLifecycleOwner(), new Observer<DietMainPageType>() {
            @Override
            public void onChanged(DietMainPageType dietMainPageType) {
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
