package com.calorie.calc.signup.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentSuccesBinding;
import com.calorie.calc.databinding.FragmentSuccessAuthBinding;
import com.calorie.calc.signup.SuccesFragment;
import com.calorie.calc.signup.regfragments.RegBaseFragment;

public class SuccesAuthFragment extends RegBaseFragment {

    FragmentSuccessAuthBinding binding;
    public SuccesAuthFragment(FragmentType type) {
        super(type);
    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        binding=FragmentSuccessAuthBinding.bind(rootView);
        binding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_success_auth, container, false);
    }
}
