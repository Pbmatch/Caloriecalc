package com.calorie.calc.signup.regfragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.calorie.calc.User;
import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;
import com.calorie.calc.utils.BackPressable;

public abstract class RegBaseFragment  extends Fragment implements BackPressable {
    protected    User user;
    protected FragmentType type;

    public RegBaseFragment(FragmentType type) {
        this.type = type;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user=RegStateHandler.getUserState().getValue();

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onResume() {
        super.onResume();

        RegStateHandler.getFragmentStateMutableLiveData().setValue(new RegFragmentState.FragmetType(type));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view, savedInstanceState);
    }
  protected abstract void initViews(final View rootView, final Bundle savedInstanceState);

    @Override
    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }

    public FragmentType getType() {
        return type;
    }

    public   enum FragmentType
    {
        GOAL(1),
        LIFESTYLE(2),
        GENDER(3),
        DATE(4),
        HEIGHT(5),
        WEIGHT(6),
        NEEDWEIGHT(7),
        NAME(8),
        EMAIL(9),
        PASS(10),
        CONFIRMPASS(11),
        SUCCES(12),
        AUTH_EMAIL(1),
        AUTH_PASS(2),
        REMIND_EMAIL(3),
        REMIND_MAIL_SUCCES(6),
        SUCCES_AUTH(4),
        SUCCES_REMIND(5)
        ;

        int number;

        FragmentType(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
}
