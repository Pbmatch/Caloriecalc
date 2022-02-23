package com.calorie.calc.fragments.recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeInnerDietFragment extends RecipeInnerHorizFragment<DietType>{
    public RecipeInnerDietFragment(RecipeMainType type) {
        super(type);
    }

    @Override
    void startLoadData() {
        List<DietType> dietTypes = new ArrayList<>();
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

    }
}
