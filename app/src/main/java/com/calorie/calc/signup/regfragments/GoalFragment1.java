package com.calorie.calc.signup.regfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.cardview.widget.CardView;

import com.calorie.calc.R;
import com.calorie.calc.User;
import com.calorie.calc.databinding.FragmentRegGoal1Binding;
import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;

import java.util.ArrayList;
import java.util.List;


public class GoalFragment1 extends InsideBaseFragment {

    FragmentRegGoal1Binding binding;
    List<CheckBox> ckeckList = new ArrayList<>();

    public GoalFragment1(FragmentType type) {
        super(type);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reg_goal1, container, false);
    }


    protected void initViews(final View rootView, final Bundle savedInstanceState) {
        binding = FragmentRegGoal1Binding.bind(rootView);
        binding.checkBox1.setTag(User.GoalWeight.UP);
        binding.checkBox2.setTag(User.GoalWeight.SUPPORT);
        binding.checkBox3.setTag(User.GoalWeight.DOWN);
        setCheckBox(binding.checkBox1, binding.cardview1);
        setCheckBox(binding.checkBox2, binding.cardview2);
        setCheckBox(binding.checkBox3, binding.cardview3);
        ckeckList.add(binding.checkBox1);
        ckeckList.add(binding.checkBox2);
        ckeckList.add(binding.checkBox3);
        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());

    }

    void setCheckBox(CheckBox checkBox, CardView view) {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    view.setCardBackgroundColor(getContext().getColor(R.color.button_green));
                    user.setGoalWeight((User.GoalWeight) checkBox.getTag());
                    for (CheckBox box : ckeckList) {
                        if (!box.equals(buttonView)) {
                            box.setChecked(false);
                        }
                    }

                } else view.setCardBackgroundColor(getContext().getColor(R.color.white));
                RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());
            }
        });
    }


}