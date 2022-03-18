package com.calorie.calc.signup.regfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDateBinding;
import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;
import com.calorie.calc.utils.DataPickerToDate;

import java.util.Calendar;
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
       // binding.datePickerActions.setMaxDate(new Date().getTime());
        Date dateNow = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        binding.datePickerActions.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {

              if(dateNow.after(  DataPickerToDate.getDateFromDatePicker(binding.datePickerActions)))
                { RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());}
                else
                { RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());}



            }
        });


    }

    @Override
    public void onPause() {
        user.setBirthDate(DataPickerToDate.getDateFromDatePicker(binding.datePickerActions));
        super.onPause();

    }
}