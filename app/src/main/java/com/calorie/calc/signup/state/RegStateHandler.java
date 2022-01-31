package com.calorie.calc.signup.state;

import androidx.lifecycle.MutableLiveData;

public class RegStateHandler {
    static private MutableLiveData<ButtonState> buttonState = new MutableLiveData<ButtonState>();

    public static MutableLiveData<ButtonState> getButtonState() {
        return buttonState;
    }
}
