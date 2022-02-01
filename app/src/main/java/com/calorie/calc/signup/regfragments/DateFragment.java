package com.calorie.calc.signup.regfragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDateBinding;
import com.calorie.calc.databinding.FragmentRegGoal1Binding;


public class DateFragment extends RegBaseFragment {


     FragmentDateBinding binding;
    public DateFragment() {
        // Required empty public constructor
    }


    public static DateFragment newInstance( ) {
        DateFragment fragment = new DateFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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


    }
}