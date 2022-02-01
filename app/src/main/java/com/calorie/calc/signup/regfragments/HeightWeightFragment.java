package com.calorie.calc.signup.regfragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentHeightWeightBinding;


class HeightWeightFragment extends RegBaseFragment {

    FragmentHeightWeightBinding binding;

    public HeightWeightFragment() {
        // Required empty public constructor
    }


    public static HeightWeightFragment newInstance( ) {

        return new HeightWeightFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_height_weight, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        binding = FragmentHeightWeightBinding.bind(rootView);


    }
}