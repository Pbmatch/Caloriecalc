package com.calorie.calc.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentSuccesBinding;
import com.calorie.calc.signup.regfragments.RegBaseFragment;


public class SuccesFragment extends RegBaseFragment {

    FragmentSuccesBinding binding;
    public SuccesFragment(FragmentType type) {
        super(type);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        binding = FragmentSuccesBinding.bind(rootView);
        binding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_succes, container, false);
    }
}