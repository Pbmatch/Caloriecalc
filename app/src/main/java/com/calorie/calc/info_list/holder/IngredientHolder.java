package com.calorie.calc.info_list.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Ingredient;
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
        String quan = String.format("%.2f",infoItem.getQuantity());
        String result=quan +" "+ infoItem.getMeasure();
        itemContView.setText(result);
        if(pos % 2 != 0) {
            csl.setBackgroundColor(itemBuilder.getContext().getColor(R.color.item_ingredient));
        }
        else
        {
            csl.setBackgroundColor(itemBuilder.getContext().getColor(R.color.white));
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemBuilder.getOnRecipeClickListener()!=null)
                    itemBuilder.getOnRecipeClickListener().selected(infoItem);
            }
        });
    }

    @Override
    public void updateState(Ingredient infoItem) {

    }
}
