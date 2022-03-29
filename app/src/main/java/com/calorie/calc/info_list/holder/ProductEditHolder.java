package com.calorie.calc.info_list.holder;

import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Ingredient;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;

public class ProductEditHolder extends InfoItemHolder<Ingredient> {
    private CheckBox checkBox;
    private TextView itemContView;
    private ConstraintLayout csl;
    ProductEditHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        checkBox = itemView.findViewById(R.id.checkBoxTitle);
        itemContView = itemView.findViewById(R.id.textViewCount);
        csl=itemView.findViewById(R.id.item_constraintL);
    }
    public ProductEditHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_ingredient_checkbox_item, parent);
    }

    @Override
    public void updateFromItem(Ingredient infoItem,int pos) {
        checkBox.setText(infoItem.getFood());
        checkBox.setChecked(infoItem.isPurchased());
        if(infoItem.isPurchased())
            checkBox.setPaintFlags(checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {    // Устанавливаем флаг зачёркивания
                    System.out.println("onCheckedChanged");
                    buttonView.setPaintFlags(buttonView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    infoItem.setPurchased(true);

                } else {    // Убираем флаг зачёркивания
                    buttonView.setPaintFlags(buttonView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    infoItem.setPurchased(false);
                }
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