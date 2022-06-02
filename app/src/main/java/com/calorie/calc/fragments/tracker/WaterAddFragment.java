package com.calorie.calc.fragments.tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.WaterMiniItem;
import com.calorie.calc.fragments.tracker.miniitem.MiniItemSetFragment;
import com.calorie.calc.utils.BackPressable;

import java.util.Date;

public class WaterAddFragment  extends MiniItemSetFragment<WaterMiniItem> implements BackPressable {


    public WaterAddFragment(WaterMiniItem selectedItem) {
        super(selectedItem);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body_setsize, container, false);
    }

    @Override
    public String getTextForButton() {

        return getString(R.string.save);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(selectedItem.getCountOfUnit()!=0)
            editText.setText(String.valueOf(selectedItem.getCountOfUnit()));

        toolbarImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }
    @Override
    public void setDataToUser() {

        selectedItem.setDate(new Date());

        MainActivity.getUser().getWaterItem().getValue().setCountOfUnit(Integer.parseInt(editText.getText().toString()));

                MainActivity.getUser().getWaterItem().setValue( MainActivity.getUser().getWaterItem().getValue());

    }

    @Override
    public void onClick(View v) {
        editText.setEnabled(false);
        setDataToUser();
       getActivity().onBackPressed();
    }
    @Override
    public boolean onBackPressed() {
        return false;

    }
}