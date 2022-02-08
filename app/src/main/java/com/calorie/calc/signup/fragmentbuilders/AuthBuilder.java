package com.calorie.calc.signup.fragmentbuilders;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.authfragments.EmailAuthFragment;
import com.calorie.calc.signup.authfragments.PassAuthFragment;
import com.calorie.calc.signup.authfragments.EmailRemindFragment;
import com.calorie.calc.signup.authfragments.SuccesAuthFragment;
import com.calorie.calc.signup.authfragments.SuccessRemindFragment;
import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;

public class AuthBuilder extends FragmentBuilder<RegFragmentState> {
    public AuthBuilder(Context context, LifecycleOwner owner) {
        super(context, owner);
        RegStateHandler.getFragmentStateMutableLiveData().observe(owner, this);
    }

    @Override
    public Fragment getNextFragment() {
        if(nextFragment==null) return new EmailAuthFragment(InsideBaseFragment.FragmentType.AUTH_EMAIL);
        return nextFragment;
    }


    @Override
    public void onChanged(RegFragmentState regFragmentState) {
        switch (regFragmentState.getType())
        {
            case AUTH_EMAIL:{ nextFragment = new PassAuthFragment(InsideBaseFragment.FragmentType.AUTH_PASS); break;}
            case AUTH_PASS:{nextFragment = new SuccesAuthFragment(InsideBaseFragment.FragmentType.SUCCES_AUTH);break;}

            case REMIND_MAIL_SUCCES:{nextFragment = new SuccessRemindFragment(InsideBaseFragment.FragmentType.SUCCES_REMIND);break;}
            case REMIND_EMAIL:{nextFragment = new EmailRemindFragment(InsideBaseFragment.FragmentType.REMIND_MAIL_SUCCES);break;}


        }
    }
}
