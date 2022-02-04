package com.calorie.calc.signup.regfragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.calorie.calc.R;
import com.calorie.calc.signup.AuthBaseFragment;
import com.calorie.calc.signup.BaseFragment;
import com.calorie.calc.signup.RegistrationBaseFragment;
import com.calorie.calc.signup.StartFragment;
import com.calorie.calc.signup.SuccesFragment;

public class NavigationHelperReg extends com.calorie.calc.NavigationHelper {
    public static void openRegistrationFragments(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewActivityReg, new RegistrationBaseFragment())
                .addToBackStack("base")
                .commit();
    }
    public static void openAuthorizationFragments(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewActivityReg, new AuthBaseFragment())
                .addToBackStack("base")
                .commit();
    }
    public static void openStartFragment(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewActivityReg, StartFragment.newInstance())

                .commit();
    }
    public static void openSuccesFragment(final FragmentManager fragmentManager, Fragment fragment) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewActivityReg, fragment)
                .commit();
    }
    public static void openNextFragment(final FragmentManager fragmentManager, Fragment fragment) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewRegBase, fragment)
                .addToBackStack(null)
                .commit();
    }

}
