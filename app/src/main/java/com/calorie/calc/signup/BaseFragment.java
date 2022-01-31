package com.calorie.calc.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRegBaseBinding;
import com.calorie.calc.utils.BackPressable;


public class BaseFragment extends Fragment implements BackPressable {


    FragmentRegBaseBinding binding;
    public BaseFragment() {

    }


    public static BaseFragment newInstance() {
        BaseFragment fragment = new BaseFragment();
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

        View view= inflater.inflate(R.layout.fragment_reg_base, container, false);
        Toolbar toolbar =   view.findViewById(R.id.srt_toolbar);



        //for crate home button
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle();
        NavigationHelperReg.openGoalFragment1(getChildFragmentManager());
        initViews(view, savedInstanceState);
    }



    void initViews(final View rootView, final Bundle savedInstanceState)
    {
        binding = FragmentRegBaseBinding.bind(rootView);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.progressBar.setCompletedSegments(2);
                NavigationHelperReg.openLifeStyleFragment2(getChildFragmentManager());
            }
        });

        binding.progressBar.setCompletedSegments(1);
    }

    void setTitle()
    {
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {

            actionBar.setTitle(R.string.registration_actionBar);
        }

    }

    @Override
    public boolean onBackPressed() {
        final Fragment fragmentPanel = getChildFragmentManager()
                .findFragmentById(R.id.fragmentContainerViewRegBase);

        if (fragmentPanel instanceof BackPressable&&getChildFragmentManager().getBackStackEntryCount()>1) {
            return ((BackPressable) fragmentPanel).onBackPressed();

        }
     return false;
    }
}