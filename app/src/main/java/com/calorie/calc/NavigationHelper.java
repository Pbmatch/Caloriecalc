package com.calorie.calc;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jakewharton.processphoenix.ProcessPhoenix;

public class NavigationHelper {
    @SuppressLint("CommitTransaction")
    protected static FragmentTransaction defaultTransaction(final FragmentManager fragmentManager) {
        return fragmentManager.beginTransaction()
                .setCustomAnimations(R.animator.custom_fade_in, R.animator.custom_fade_out,
                        R.animator.custom_fade_in, R.animator.custom_fade_out);
    }
    public static void restartApp(final Activity activity) {
        ProcessPhoenix.triggerRebirth(activity.getApplicationContext());
    }
}
