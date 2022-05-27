package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;

import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.info_list.InfoItemBuilder;

public class NutrientMainHolder extends NutrientHolder{
    NutrientMainHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
    }

    public NutrientMainHolder(InfoItemBuilder infoItemBuilder, ViewGroup parent) {
        super(infoItemBuilder, parent);
    }

    @Override
    public String getQuan(Nutrient infoItem) {
        return String.format("%.2f",infoItem.getSummQuantity());
    }
}
