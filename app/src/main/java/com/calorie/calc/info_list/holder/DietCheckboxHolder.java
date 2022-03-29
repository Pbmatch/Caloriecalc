package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;
import android.widget.CheckBox;

import com.calorie.calc.R;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;

public class DietCheckboxHolder extends InfoItemHolder<String> {

    CheckBox checkBox;
     DietCheckboxHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
    }
    public DietCheckboxHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_diet_check_item, parent);
        checkBox = itemView.findViewById(R.id.checkBox);
    }

    @Override
    public void updateFromItem(String infoItem, int position) {
         checkBox.setText(infoItem);

    }

    @Override
    public void updateState(String infoItem) {

    }
}
