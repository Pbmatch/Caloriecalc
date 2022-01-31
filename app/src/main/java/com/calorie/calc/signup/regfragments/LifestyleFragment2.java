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
import com.calorie.calc.databinding.FragmentRegLifestyle2Binding;


public class LifestyleFragment2 extends RegBaseFragment {


    FragmentRegLifestyle2Binding binding;
    public LifestyleFragment2() {

    }


    public static LifestyleFragment2 newInstance( ) {
        LifestyleFragment2 fragment = new LifestyleFragment2();
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

        return inflater.inflate(R.layout.fragment_reg_lifestyle2, container, false);
    }


  protected   void initViews(final View rootView, final Bundle savedInstanceState)
    {
        binding = FragmentRegLifestyle2Binding.bind(rootView);
        binding.radio1.setText(Html.fromHtml(getString(R.string.registration_lifestyle_1)));
        binding.radio2.setText(Html.fromHtml(getString(R.string.registration_lifestyle_2)));
        binding.radio3.setText(Html.fromHtml(getString(R.string.registration_lifestyle_3)));
        binding.radio4.setText(Html.fromHtml(getString(R.string.registration_lifestyle_4)));
    }
}