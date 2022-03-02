package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.info_list.InfoItemBuilder;

public class NutrientHolder extends InfoItemHolder<Nutrient>{
    private TextView itemTitleView;
    private  TextView itemContView;
     NutrientHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
         itemTitleView = itemView.findViewById(R.id.textViewTitle);
         itemContView = itemView.findViewById(R.id.textViewCount);
    }
    public NutrientHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_nutrient_item, parent);
    }
    @Override
    public void updateFromItem(Nutrient infoItem, int position) {
        itemTitleView.setText(infoItem.getLabel());
        String quan = String.format("%.2f",infoItem.getQuantity());
        String result=quan +" "+ infoItem.getUnit();
        itemContView.setText(result);
    }

    @Override
    public void updateState(Nutrient infoItem) {

    }
}
