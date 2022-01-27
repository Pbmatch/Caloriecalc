package com.calorie.calc.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRegBaseBinding;
import com.calorie.calc.databinding.FragmentRegGoal1Binding;


public class RegistrationsBaseFragment extends Fragment {


    FragmentRegBaseBinding binding;
    public RegistrationsBaseFragment() {

    }


    public static RegistrationsBaseFragment newInstance() {
        RegistrationsBaseFragment fragment = new RegistrationsBaseFragment();
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
        return inflater.inflate(R.layout.fragment_reg_base, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle();
        NavigationHelperRegistration.openGoalFragment1(getChildFragmentManager());
        initViews(view, savedInstanceState);
    }

    void initViews(final View rootView, final Bundle savedInstanceState)
    {
        binding = FragmentRegBaseBinding.bind(rootView);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelperRegistration.openLifeStyleFragment2(getChildFragmentManager());
            }
        });
    }

    void setTitle()
    {
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.registration_actionBar);
        }

    }
}