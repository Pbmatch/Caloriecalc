package com.calorie.calc.signup.state;

import com.calorie.calc.signup.InsideBaseFragment;

public class RegFragmentState {

    InsideBaseFragment.FragmentType type;


    public RegFragmentState(InsideBaseFragment.FragmentType type) {
        this.type = type;
    }

    public InsideBaseFragment.FragmentType getType() {
        return type;
    }

    public void setType(InsideBaseFragment.FragmentType type) {
        this.type = type;
    }


    public static  class FragmetType extends RegFragmentState

    {

        public FragmetType(InsideBaseFragment.FragmentType type) {
            super(type);
        }
    }
}
