package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.edamam.holders.recipeholders.Ingredient;
import com.calorie.calc.info_list.InfoItemBuilder;

public class IngredientHolder extends InfoItemHolder<Ingredient> {
    private TextView itemTitleView;
    private  TextView itemContView;
    private ConstraintLayout csl;
      IngredientHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
          itemTitleView = itemView.findViewById(R.id.textViewTitle);
          itemContView = itemView.findViewById(R.id.textViewCount);
          csl=itemView.findViewById(R.id.item_constraintL);
    }
    public IngredientHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_ingredient_item, parent);
    }

    @Override
    public void updateFromItem(Ingredient infoItem,int pos) {
        itemTitleView.setText(infoItem.getFood());
        String result=String.valueOf(infoItem.getQuantity()) +" "+ infoItem.getMeasure();
        itemContView.setText(result);
        if(pos % 2 != 0) {
            csl.setBackgroundColor(itemBuilder.getContext().getColor(R.color.item_ingredient));
        }
    }

    @Override
    public void updateState(Ingredient infoItem) {

    }
}
