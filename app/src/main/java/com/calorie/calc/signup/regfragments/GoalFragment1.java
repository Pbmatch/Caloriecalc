package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRegGoal1Binding;


public class GoalFragment1 extends Fragment {

     FragmentRegGoal1Binding binding;
    public GoalFragment1() {

    }


    public static GoalFragment1 newInstance( ) {
        GoalFragment1 fragment = new GoalFragment1();
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

        return inflater.inflate(R.layout.fragment_reg_goal1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view, savedInstanceState);
    }
    void initViews(final View rootView, final Bundle savedInstanceState)
    {
        binding = FragmentRegGoal1Binding.bind(rootView);
        binding.checkBox1.setText(Html.fromHtml(getString(R.string.registration_lifestyle_1_title)));
    }
}