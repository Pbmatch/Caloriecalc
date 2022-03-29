package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;

public class NutrientHolder extends InfoItemHolder<Nutrient> {
    private TextView itemTitleView;
    private  TextView itemContView;
    private ConstraintLayout csl;
     NutrientHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
         itemTitleView = itemView.findViewById(R.id.textViewTitle);
         itemContView = itemView.findViewById(R.id.textViewCount);
         csl=itemView.findViewById(R.id.item_constraintL);
    }
    public NutrientHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_nutrient_item, parent);
    }
    @Override
    public void updateFromItem(Nutrient infoItem, int position) {
        itemTitleView.setText(infoItem.getLabel());

        String quan = String.format("%.2f",infoItem.getQuantity()/infoItem.getPortion());
        String result=quan +" "+ infoItem.getUnit();
        itemContView.setText(result);
        if(position % 2 != 0) {
            csl.setBackgroundColor(itemBuilder.getContext().getColor(R.color.item_ingredient));
        }
    }

    @Override
    public void updateState(Nutrient infoItem) {

    }
}
