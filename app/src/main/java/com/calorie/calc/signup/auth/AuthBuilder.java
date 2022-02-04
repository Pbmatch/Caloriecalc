package com.calorie.calc.signup.auth;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import com.calorie.calc.signup.FragmentBuilder;
import com.calorie.calc.signup.regfragments.DateFragment4;
import com.calorie.calc.signup.regfragments.GenderFragment3;
import com.calorie.calc.signup.regfragments.HeightFragment5;
import com.calorie.calc.signup.regfragments.LifestyleFragment2;
import com.calorie.calc.signup.regfragments.RegBaseFragment;
import com.calorie.calc.signup.regfragments.WeightFragment6;
import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;

public class AuthBuilder extends FragmentBuilder<RegFragmentState> {
    public AuthBuilder(Context context, LifecycleOwner owner) {
        super(context, owner);
        RegStateHandler.getFragmentStateMutableLiveData().observe(owner, this);
    }

    @Override
    public Fragment getNextFragment() {
        if(nextFragment==null) return new AuthEmailFragment(RegBaseFragment.FragmentType.AUTH_EMAIL);
        return nextFragment;
    }


    @Override
    public void onChanged(RegFragmentState regFragmentState) {
        switch (regFragmentState.getType())
        {
            case AUTH_EMAIL:{ nextFragment = new PassAuthFragment(RegBaseFragment.FragmentType.AUTH_PASS); break;}
            case AUTH_PASS:{nextFragment = new SuccesAuthFragment(RegBaseFragment.FragmentType.SUCCES_AUTH);break;}

            case REMIND_MAIL_SUCCES:{nextFragment = new SuccessRemindFragment(RegBaseFragment.FragmentType.SUCCES_REMIND);break;}
            case REMIND_EMAIL:{nextFragment = new RemindMailFragment(RegBaseFragment.FragmentType.REMIND_MAIL_SUCCES);break;}


        }
    }
}
