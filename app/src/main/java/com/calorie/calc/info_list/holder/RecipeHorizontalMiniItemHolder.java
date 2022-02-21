package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoItemBuilder;

public class RecipeHorizontalMiniItemHolder extends InfoItemHolder {

    public RecipeHorizontalMiniItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_horizontal_item, parent);
    }
     RecipeHorizontalMiniItemHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
    }

    @Override
    public void updateFromItem(RecipeAndLinks infoItem) {

    }

    @Override
    public void updateState(RecipeAndLinks infoItem) {

    }

}