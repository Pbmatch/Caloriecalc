package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentHeightWeightBinding;
import com.calorie.calc.signup.InsideBaseFragment;


public abstract class HeightWeightFragment extends InsideBaseFragment {

    FragmentHeightWeightBinding binding;

    public HeightWeightFragment(FragmentType type) {
        super(type);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_height_weight, container, false);
    }


    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        binding = FragmentHeightWeightBinding.bind(rootView);

        setViews();
    }
    abstract void setViews();
}