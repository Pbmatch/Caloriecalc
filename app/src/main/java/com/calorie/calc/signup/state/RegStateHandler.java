package com.calorie.calc.signup.state;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.User;

public class RegStateHandler {
    static private MutableLiveData<User> userState = new MutableLiveData<User>();
    static private MutableLiveData<ButtonState> buttonState = new MutableLiveData<ButtonState>();
    static private MutableLiveData<RegFragmentState> fragmentStateMutableLiveData = new MutableLiveData<RegFragmentState>();
    public static MutableLiveData<ButtonState> getButtonState() {
        return buttonState;
    }

    public static MutableLiveData<User> getUserState() {
        return userState;
    }

    public static MutableLiveData<RegFragmentState> getFragmentStateMutableLiveData() {
        return fragmentStateMutableLiveData;
    }
}
