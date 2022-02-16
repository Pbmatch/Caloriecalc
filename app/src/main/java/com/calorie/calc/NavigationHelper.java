package com.calorie.calc;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.calorie.calc.signup.fragments.MainFragment;
import com.jakewharton.processphoenix.ProcessPhoenix;

public class NavigationHelper {
    private static final String MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT";

    @SuppressLint("CommitTransaction")
    protected static FragmentTransaction defaultTransaction(final FragmentManager fragmentManager) {
        return fragmentManager.beginTransaction()
                .setCustomAnimations(R.animator.custom_fade_in, R.animator.custom_fade_out,
                        R.animator.custom_fade_in, R.animator.custom_fade_out);
    }
    public static void restartApp(final Activity activity) {
        ProcessPhoenix.triggerRebirth(activity.getApplicationContext());
    }
    protected static void openMainFragment(final FragmentManager fragmentManager) {
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        defaultTransaction(fragmentManager)
                .replace(R.id.main_activ_container, new MainFragment())
                .addToBackStack(MAIN_FRAGMENT_TAG)
                .commit();
    }
}
