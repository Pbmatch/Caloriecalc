package com.calorie.calc.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentStartBinding;
import com.calorie.calc.signup.regfragments.NavigationHelperReg;


public class StartFragment extends Fragment {

   FragmentStartBinding binding;
    public StartFragment() {
        // Required empty public constructor
    }


    public static StartFragment newInstance( ) {
        StartFragment fragment = new StartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_start, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view, savedInstanceState);
    }
    void initViews(final View rootView, final Bundle savedInstanceState)
    {
        binding = FragmentStartBinding.bind(rootView);
        binding.buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavigationHelperReg.openRegistrationFragments(getParentFragmentManager());


            }
        });
        binding.textViewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelperReg.openAuthorizationFragments(getParentFragmentManager());
            }
        });

    }
}