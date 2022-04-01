package com.calorie.calc.fragments.tracker.miniitem.bodysize;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.utils.BackPressable;

import java.util.Date;

public class BodyUpdateFragment extends BodySetSizeFragment implements BackPressable {
    boolean singleItem=false;
    public BodyUpdateFragment(BodySizeItem selectedItem) {
        super(selectedItem);
    }
    public BodyUpdateFragment(BodySizeItem selectedItem,Boolean singleItem) {
        super(selectedItem);
        this.singleItem=singleItem;
    }
    @Override
    public String getTextForButton() {

        return getString(R.string.update_button);
    }

    @Override
    public void setDataToUser() {
        selectedItem.setCountOfUnit(Integer.parseInt(editText.getText().toString()));
        selectedItem.setDate(new Date());
        if(!singleItem)
        MainActivity.getUser().getBodySizeItemList().notifyDataSetChanged();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText.setText(String.valueOf(selectedItem.getCountOfUnit()));
        toolbarImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
    @Override
    public void onClick(View v) {
        editText.setEnabled(false);
        setDataToUser();

        getActivity().onBackPressed();
    }
}
