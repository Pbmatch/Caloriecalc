package com.calorie.calc.signup.fragmentbuilders;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.regfragments.SuccesRegFragment;
import com.calorie.calc.signup.regfragments.PassConfirmFragment11;
import com.calorie.calc.signup.regfragments.DateFragment4;
import com.calorie.calc.signup.regfragments.EmailFragment;
import com.calorie.calc.signup.regfragments.GenderFragment3;
import com.calorie.calc.signup.regfragments.GoalFragment1;
import com.calorie.calc.signup.regfragments.HeightFragment5;
import com.calorie.calc.signup.regfragments.LifestyleFragment2;
import com.calorie.calc.signup.regfragments.NameFragment8;
import com.calorie.calc.signup.regfragments.NeedWeightFragment7;
import com.calorie.calc.signup.regfragments.PassFragment10;
import com.calorie.calc.signup.regfragments.WeightFragment6;
import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;

public class RegBuilder extends FragmentBuilder<RegFragmentState>
{

    public RegBuilder(Context context, LifecycleOwner owner) {
        super(context,owner);

        RegStateHandler.getFragmentStateMutableLiveData().observe(owner, this);
    }
    @Override
    public void onChanged(RegFragmentState regFragmentState) {
       switch (regFragmentState.getType())
       {
           case GOAL:{ nextFragment = new LifestyleFragment2(InsideBaseFragment.FragmentType.LIFESTYLE); break;}
           case LIFESTYLE:{nextFragment = new GenderFragment3(InsideBaseFragment.FragmentType.GENDER);break;}
           case GENDER:{nextFragment = new DateFragment4(InsideBaseFragment.FragmentType.DATE);break;}
           case DATE:{nextFragment = new HeightFragment5(InsideBaseFragment.FragmentType.HEIGHT);break;}
           case HEIGHT:{nextFragment = new WeightFragment6(InsideBaseFragment.FragmentType.WEIGHT);break;}
           case WEIGHT:{nextFragment = new NeedWeightFragment7(InsideBaseFragment.FragmentType.NEEDWEIGHT);break;}
           case NEEDWEIGHT:{nextFragment = new NameFragment8(InsideBaseFragment.FragmentType.NAME);break;}
           case NAME:{nextFragment = new EmailFragment(InsideBaseFragment.FragmentType.EMAIL);break;}
           case EMAIL:{nextFragment = new PassFragment10(InsideBaseFragment.FragmentType.PASS);break;}
           case PASS:{nextFragment = new PassConfirmFragment11(InsideBaseFragment.FragmentType.CONFIRMPASS);break;}
           case CONFIRMPASS:{nextFragment = new SuccesRegFragment(InsideBaseFragment.FragmentType.SUCCES);break;}
           case SUCCES:{ break; }
       }
    }
    @Override
    public Fragment getNextFragment() {
        if(nextFragment==null) return new GoalFragment1(InsideBaseFragment.FragmentType.GOAL);
        return nextFragment;
    }
}


