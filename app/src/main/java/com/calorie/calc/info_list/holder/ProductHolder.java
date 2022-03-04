package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Ingredient;
import com.calorie.calc.info_list.InfoItemBuilder;

public class ProductHolder extends InfoItemHolder<Ingredient> {
    private CheckBox checkBox;
    private  TextView itemContView;
    private ConstraintLayout csl;
    ProductHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        checkBox = itemView.findViewById(R.id.checkBoxTitle);
        itemContView = itemView.findViewById(R.id.textViewCount);
        csl=itemView.findViewById(R.id.item_constraintL);
    }
    public ProductHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_ingredient_checkbox_item, parent);
    }

    @Override
    public void updateFromItem(Ingredient infoItem,int pos) {

        checkBox.setText(infoItem.getFood());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                infoItem.setAddToProductChecked(isChecked);
            }
        });
        String quan = String.format("%.2f",infoItem.getQuantity());
        String result=quan +" "+ infoItem.getMeasure();
        itemContView.setText(result);
        if(pos % 2 != 0) {
            csl.setBackgroundColor(itemBuilder.getContext().getColor(R.color.item_ingredient));
        }
    }

    @Override
    public void updateState(Ingredient infoItem) {

    }
}