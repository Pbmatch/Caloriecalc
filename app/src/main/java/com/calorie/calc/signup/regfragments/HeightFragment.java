package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;


public class HeightFragment extends Fragment {



    public HeightFragment() {
        // Required empty public constructor
    }


    public static HeightFragment newInstance( ) {
        HeightFragment fragment = new HeightFragment();
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
        return inflater.inflate(R.layout.fragment_height, container, false);
    }
}