package com.calorie.calc.signup.regfragments;

import com.calorie.calc.R;

public class HeightFragment5 extends HeightWeightFragment {
    public HeightFragment5(FragmentType type) {
        super(type);
    }

    @Override
    void setViews() {
        binding.datePickerActions.setMaxValue(230);
        binding.datePickerActions.setMinValue(30);
        binding.datePickerActions.setValue(160);
        binding.textViewTitle.setText(R.string.registration_height);
    }

    @Override
    public void onPause() {
        user.setHeight(binding.datePickerActions.getValue());
        super.onPause();
    }
}
