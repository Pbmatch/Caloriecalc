package com.calorie.calc.fragments.tracker.miniitem.bodysize;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.fragments.tracker.miniitem.MiniItemCreateFragment;
import com.calorie.calc.utils.OptionsUnit;

import java.util.Date;


public class BodyCreateSizeFragment extends MiniItemCreateFragment {

    @Override
    public String getUnitText() {
        return OptionsUnit.getBodySizeUnit(getContext());
    }

    @Override
    public boolean checkButtonEnable() {
        return editText.getText().toString().length() > 0
                && !editText.getText().toString().equals("0")
                && editTextName.getText().toString().length() > 0;

    }

    @Override
    public boolean checkEnabled(String s) {
        return !s.equals("0") && editTextName.getText().toString().length() != 0;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_body_create, container, false);
    }

    @Override
    public void onClick(View v) {
        BodySizeItem selectedItem = new BodySizeItem(editTextName.getText().toString(),
                R.drawable.measurements, R.drawable.measurementsbig);
        selectedItem.setDate(new Date());
        selectedItem.setCountOfUnit(Integer.getInteger(editText.getText().toString(), 0));
        MainActivity.getUser().getBodySizeItemList().getValue().add(selectedItem);
        getParentFragmentManager().popBackStack();
    }
}