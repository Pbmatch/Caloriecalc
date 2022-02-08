package com.calorie.calc.signup.regfragments;

import android.os.Bundle;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.calorie.calc.R;
import com.calorie.calc.User;
import com.calorie.calc.databinding.FragmentRegLifestyle2Binding;
import com.calorie.calc.signup.InsideBaseFragment;


public class LifestyleFragment2 extends InsideBaseFragment {


    FragmentRegLifestyle2Binding binding;

    public LifestyleFragment2(FragmentType type) {
        super(type);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_reg_lifestyle2, container, false);
    }


  protected   void initViews(final View rootView, final Bundle savedInstanceState)
    {
        binding = FragmentRegLifestyle2Binding.bind(rootView);
        binding.radio1.setTag(User.Lifestyle.NO_SPORT);
        binding.radio2.setTag(User.Lifestyle.SPORT_1_2);
        binding.radio3.setTag(User.Lifestyle.SPORT_3_5);
        binding.radio4.setTag(User.Lifestyle.SPORT_EVERYDAY);

        binding.radio1.setText(Html.fromHtml(getString(((User.Lifestyle)binding.radio1.getTag()).getResourceText())));
        binding.radio2.setText(Html.fromHtml(getString(((User.Lifestyle)binding.radio2.getTag()).getResourceText())));
        binding.radio3.setText(Html.fromHtml(getString(((User.Lifestyle)binding.radio3.getTag()).getResourceText())));
        binding.radio4.setText(Html.fromHtml(getString(((User.Lifestyle)binding.radio4.getTag()).getResourceText())));
    }

    @Override
    public void onPause() {
        System.out.println("ONPAUSE");
       user.setLifestyle((User.Lifestyle)getSelectedButton().getTag());
        System.out.println(user.getLifestyle());
        super.onPause();
    }

  RadioButton getSelectedButton()
  {
     if(binding.radio1.isChecked()) return binding.radio1 ;
      if(binding.radio2.isChecked()) return binding.radio2 ;
      if(binding.radio3.isChecked()) return binding.radio3 ;
        return binding.radio4 ;
  }
}