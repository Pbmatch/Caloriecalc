package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.User;
import com.calorie.calc.databinding.FragmentRegGender3Binding;
import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;


public class GenderFragment3 extends InsideBaseFragment {

      FragmentRegGender3Binding binding;
    public GenderFragment3(FragmentType type) {
        super(type);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
      binding = FragmentRegGender3Binding.bind(rootView);
        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());
      binding.imageViewFemale.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              binding.imageViewFemale.setImageResource(R.drawable.femalegreen);
              binding.imageViewMan.setImageResource(R.drawable.man);
              user.setGender(User.Gender.FEMALE);
              RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());
          }
      });
        binding.imageViewMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageViewFemale.setImageResource(R.drawable.female);
                binding.imageViewMan.setImageResource(R.drawable.mangreen);
                user.setGender(User.Gender.MALE);
                RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg_gender3, container, false);
    }
}