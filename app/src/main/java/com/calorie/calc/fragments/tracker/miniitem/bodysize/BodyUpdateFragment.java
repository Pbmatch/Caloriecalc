package com.calorie.calc.fragments.tracker.miniitem.bodysize;

import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;

import java.util.Date;

public class BodyUpdateFragment extends BodySetSizeFragment{
    public BodyUpdateFragment(BodySizeItem selectedItem) {
        super(selectedItem);
    }

    @Override
    public String getTextForButton() {
        return getString(R.string.update_button);
    }

    @Override
    public void setDataToUser() {
        selectedItem.setCountOfUnit(Integer.getInteger(editText.getText().toString(),0));
        selectedItem.setDate(new Date());
    }
}
