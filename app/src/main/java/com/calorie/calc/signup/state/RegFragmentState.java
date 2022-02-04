package com.calorie.calc.signup.state;

import com.calorie.calc.signup.regfragments.RegBaseFragment;

public class RegFragmentState {

    RegBaseFragment.FragmentType type;


    public RegFragmentState(RegBaseFragment.FragmentType type) {
        this.type = type;
    }

    public RegBaseFragment.FragmentType getType() {
        return type;
    }

    public void setType(RegBaseFragment.FragmentType type) {
        this.type = type;
    }


    public static  class FragmetType extends RegFragmentState

    {

        public FragmetType(RegBaseFragment.FragmentType type) {
            super(type);
        }
    }
}
