package com.calorie.calc.signup.fragmentbuilders;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;

public abstract class FragmentBuilder<T> implements Observer<T> {
    protected Context context;
    protected LifecycleOwner owner;
    protected Fragment nextFragment;
    public FragmentBuilder(Context context, LifecycleOwner owner) {
        this.context = context;
        this.owner = owner;

    }

    public abstract Fragment getNextFragment();


}
