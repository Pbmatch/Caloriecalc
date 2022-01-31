package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;


public class EmailFragment extends Fragment {


    public EmailFragment() {
        // Required empty public constructor
    }


    public static EmailFragment newInstance( ) {
        EmailFragment fragment = new EmailFragment();
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

        return inflater.inflate(R.layout.fragment_email, container, false);
    }
}