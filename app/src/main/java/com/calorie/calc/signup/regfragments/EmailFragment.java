package com.calorie.calc.signup.regfragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentEmailBinding;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;


public class EmailFragment  extends RegBaseFragment {

    public   FragmentEmailBinding binding;
    public EmailFragment(FragmentType type) {
        super(type);
    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
    binding=FragmentEmailBinding.bind(rootView);
    setViews();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_email, container, false);
    }
    void setViews() {
        ((AppCompatActivity)getContext()).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());

        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0)
                    RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());
                else RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());
            }
        });
    }
    @Override
    public void onPause() {
        onSettingPause();
        ((AppCompatActivity)getContext()).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        super.onPause();
    }
    public void onSettingPause()
    {user.setEmail(binding.editText.getText().toString());
        }
}