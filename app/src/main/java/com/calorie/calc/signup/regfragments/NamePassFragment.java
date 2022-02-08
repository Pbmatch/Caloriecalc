package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentNameBinding;
import com.calorie.calc.signup.InsideBaseFragment;


public abstract class NamePassFragment extends InsideBaseFragment {

      FragmentNameBinding binding;
    public NamePassFragment(FragmentType type) {
        super(type);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        binding = FragmentNameBinding.bind(rootView);
        setViews();
    }
    abstract void setViews();
}