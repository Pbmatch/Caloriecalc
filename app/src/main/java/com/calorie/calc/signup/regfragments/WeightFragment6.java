package com.calorie.calc.signup.regfragments;

import com.calorie.calc.R;

public class WeightFragment6 extends HeightWeightFragment {
    public WeightFragment6(FragmentType type) {
        super(type);
    }

    @Override
    void setViews() {
        binding.datePickerActions.setMaxValue(450);
        binding.datePickerActions.setMinValue(15);
        binding.datePickerActions.setValue(60);
        binding.textViewTitle.setText(R.string.registration_weight);
        binding.textViewUnit.setText(R.string.registration_weight_unit);
    }


    @Override
    public void onPause() {
        user.setWeight(binding.datePickerActions.getValue());
        super.onPause();
    }
}
