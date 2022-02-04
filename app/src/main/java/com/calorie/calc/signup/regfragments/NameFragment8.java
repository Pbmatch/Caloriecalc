package com.calorie.calc.signup.regfragments;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;

public class NameFragment8 extends NamePassFragment {
    public NameFragment8(FragmentType type) {
        super(type);
    }

    @Override
    void setViews() {
        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());
         binding.editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(binding.editText, InputMethodManager.SHOW_IMPLICIT);
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
        user.setName(binding.editText.getText().toString());
        super.onPause();
    }
}
