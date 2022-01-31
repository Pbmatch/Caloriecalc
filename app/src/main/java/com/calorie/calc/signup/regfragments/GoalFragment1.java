package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRegGoal1Binding;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;

import java.util.ArrayList;
import java.util.List;


public class GoalFragment1 extends RegBaseFragment {

     FragmentRegGoal1Binding binding;
     List<CheckBox> ckeckList = new ArrayList<>();
    public GoalFragment1() {

    }

    public static Fragment newInstance() {
        GoalFragment1 fragment = new GoalFragment1();
        Bundle args = new Bundle();

        fragment.setArguments(args);
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
        setCheckBox(binding.checkBox1,binding.cardview1);
        setCheckBox(binding.checkBox2,binding.cardview2);
        setCheckBox(binding.checkBox3,binding.cardview3);
        ckeckList.add(binding.checkBox1);
        ckeckList.add(binding.checkBox2);
        ckeckList.add(binding.checkBox3);
        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());

    }
    void setCheckBox(CheckBox checkBox, CardView view)
    {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {   view.setCardBackgroundColor(getContext().getColor(R.color.button_green));
                for(CheckBox box:ckeckList)
                {
                    if(!box.equals(buttonView)) {box.setChecked(false); }
                }

                }


                else view.setCardBackgroundColor(getContext().getColor(R.color.white));
                RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());
            }
        });
    }


}