package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GenderFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GenderFragment3 extends Fragment {



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GenderFragment3() {
        // Required empty public constructor
    }


    public static GenderFragment3 newInstance( ) {
        GenderFragment3 fragment = new GenderFragment3();
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
        return inflater.inflate(R.layout.fragment_reg_gender3, container, false);
    }
}