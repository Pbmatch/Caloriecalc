package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRegGoal1Binding;


public class GoalFragment1 extends RegBaseFragment {

     FragmentRegGoal1Binding binding;
    public GoalFragment1() {

    }

    public static Fragment newInstance() {
        if(fragment==null)
        {
            fragment= new GoalFragment1();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reg_goal1, container, false);
    }


    protected void initViews(final View rootView, final Bundle savedInstanceState)
    {
        binding = FragmentRegGoal1Binding.bind(rootView);
        binding.checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)binding.cardview1.setCardBackgroundColor(getContext().getColor(R.color.button_green));
                else binding.cardview1.setCardBackgroundColor(getContext().getColor(R.color.white));
            }
        });
        binding.checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)binding.cardview2.setCardBackgroundColor(getContext().getColor(R.color.button_green));
                else binding.cardview2.setCardBackgroundColor(getContext().getColor(R.color.white));
            }
        });
        binding.checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)binding.cardview3.setCardBackgroundColor(getContext().getColor(R.color.button_green));
                else binding.cardview3.setCardBackgroundColor(getContext().getColor(R.color.white));
            }
        });

    }
}