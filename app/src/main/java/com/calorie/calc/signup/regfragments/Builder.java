package com.calorie.calc.signup.regfragments;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import com.calorie.calc.signup.FragmentBuilder;
import com.calorie.calc.signup.SuccesFragment;
import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;

public class Builder extends FragmentBuilder<RegFragmentState>
{

    public Builder(Context context, LifecycleOwner owner) {
        super(context,owner);

        RegStateHandler.getFragmentStateMutableLiveData().observe(owner, this);
    }
    @Override
    public void onChanged(RegFragmentState regFragmentState) {
       switch (regFragmentState.getType())
       {
           case GOAL:{ nextFragment = new LifestyleFragment2(RegBaseFragment.FragmentType.LIFESTYLE); break;}
           case LIFESTYLE:{nextFragment = new GenderFragment3(RegBaseFragment.FragmentType.GENDER);break;}
           case GENDER:{nextFragment = new DateFragment4(RegBaseFragment.FragmentType.DATE);break;}
           case DATE:{nextFragment = new HeightFragment5(RegBaseFragment.FragmentType.HEIGHT);break;}
           case HEIGHT:{nextFragment = new WeightFragment6(RegBaseFragment.FragmentType.WEIGHT);break;}
           case WEIGHT:{nextFragment = new NeedWeightFragment7(RegBaseFragment.FragmentType.NEEDWEIGHT);break;}
           case NEEDWEIGHT:{nextFragment = new NameFragment8(RegBaseFragment.FragmentType.NAME);break;}
           case NAME:{nextFragment = new EmailFragment(RegBaseFragment.FragmentType.EMAIL);break;}
           case EMAIL:{nextFragment = new PassFragment10(RegBaseFragment.FragmentType.PASS);break;}
           case PASS:{nextFragment = new ConfirmPassFragment11(RegBaseFragment.FragmentType.CONFIRMPASS);break;}
           case CONFIRMPASS:{nextFragment = new SuccesFragment(RegBaseFragment.FragmentType.SUCCES);break;}
           case SUCCES:{ break; }
       }
    }
    @Override
    public Fragment getNextFragment() {
        if(nextFragment==null) return new GoalFragment1(RegBaseFragment.FragmentType.GOAL);
        return nextFragment;
    }
}


