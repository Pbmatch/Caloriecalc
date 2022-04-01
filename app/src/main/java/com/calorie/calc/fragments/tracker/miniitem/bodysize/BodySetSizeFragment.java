package com.calorie.calc.fragments.tracker.miniitem.bodysize;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.fragments.tracker.miniitem.MiniItemSetFragment;

import java.util.Date;


public class BodySetSizeFragment extends MiniItemSetFragment<BodySizeItem> {

    public BodySetSizeFragment(BodySizeItem selectedItem) {
        super(selectedItem);
    }

    @Override
    public String getTextForButton()
    {
        return   getString(R.string.add_button);
    }
    @Override
    public  void setDataToUser()
    {
        selectedItem.setCountOfUnit(Integer.parseInt(editText.getText().toString()));
        selectedItem.setDate(new Date());

        MainActivity.getUser().getBodySizeItemList().additem(selectedItem);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body_setsize, container, false);
    }


}