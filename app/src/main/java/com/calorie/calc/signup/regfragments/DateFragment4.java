package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDateBinding;
import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.utils.DataPickerToDate;

import java.util.Date;


public class DateFragment4 extends InsideBaseFragment {


     FragmentDateBinding binding;

    public DateFragment4(FragmentType type) {
        super(type);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date, container, false);
    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        binding = FragmentDateBinding.bind(rootView);
        binding.datePickerActions.setMaxDate(new Date().getTime());
        binding.textViewText.setText(Html.fromHtml(getString(user.getLifestyle().getResourceText())));
    }

    @Override
    public void onPause() {
        user.setBirthDate(DataPickerToDate.getDateFromDatePicker(binding.datePickerActions));
        super.onPause();

    }
}