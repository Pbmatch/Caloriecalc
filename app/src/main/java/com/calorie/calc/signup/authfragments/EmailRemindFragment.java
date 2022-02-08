package com.calorie.calc.signup.authfragments;

import android.content.Context;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.calorie.calc.R;

import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.regfragments.EmailFragment;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;


public class EmailRemindFragment extends EmailFragment {


    public EmailRemindFragment(FragmentType type) {
        super(type);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        super.initViews(rootView, savedInstanceState);
        binding.textViewTitle.setText(R.string.authorization_remind_title);
        binding.textViewTitle.setTextAppearance(R.style.text_title_min);
        binding.buttonGoogle.setVisibility(View.GONE);
        binding.textViewText.setVisibility(View.GONE);

    }

    @Override
    public void addKeyboardListener() {

    }
}