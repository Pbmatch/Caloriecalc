package com.calorie.calc.fragments.tracker.miniitem.bodysize;

import com.calorie.calc.MainActivity;
import com.calorie.calc.data.BodySizeItem;

import java.util.Date;

public class BodyWeightFragment extends BodyUpdateFragment{
    public BodyWeightFragment(BodySizeItem selectedItem) {
        super(selectedItem,true);
    }

    @Override
    public void setDataToUser() {
        selectedItem.setCountOfUnit(Integer.parseInt(editText.getText().toString()));
        System.out.println("setDataToUser"+selectedItem.getCountOfUnit());
        selectedItem.setDate(new Date());
        MainActivity.getUser().getWeightItem().setValue(selectedItem);



    }

}
