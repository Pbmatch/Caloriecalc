package com.calorie.calc.signup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.calorie.calc.R;
import com.calorie.calc.signup.AuthOutsideBaseFragment;
import com.calorie.calc.signup.RegistrationOutsideBaseFragment;
import com.calorie.calc.signup.StartFragment;

public class NavigationHelperRegistration extends com.calorie.calc.NavigationHelper {
    public static void openRegistrationFragments(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewActivityReg, new RegistrationOutsideBaseFragment())
                .addToBackStack("base")
                .commit();
    }
    public static void openAuthorizationFragments(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewActivityReg, new AuthOutsideBaseFragment())
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
