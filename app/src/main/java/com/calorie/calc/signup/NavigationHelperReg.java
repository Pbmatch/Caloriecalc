package com.calorie.calc.signup;

import androidx.fragment.app.FragmentManager;

import com.calorie.calc.R;
import com.calorie.calc.signup.regfragments.DateFragment;
import com.calorie.calc.signup.regfragments.GenderFragment3;
import com.calorie.calc.signup.regfragments.GoalFragment1;
import com.calorie.calc.signup.regfragments.LifestyleFragment2;

  class NavigationHelperReg extends com.calorie.calc.NavigationHelper {
    public static void openBaseRegFragment(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewActivityReg, BaseFragment.newInstance())
                .addToBackStack("base")
                .commit();
    }
    public static void openStartFragment(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewActivityReg, StartFragment.newInstance())

                .commit();
    }
    public static void openGoalFragment1(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewRegBase, GoalFragment1.newInstance())
                .addToBackStack(null)
                .commit();
    }
    public static void openLifeStyleFragment2(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewRegBase, LifestyleFragment2.newInstance())
                .addToBackStack(null)
                .commit();
    }
    public static void openGenderFragment3(final FragmentManager fragmentManager) {

        defaultTransaction(fragmentManager)
                .replace(R.id.fragmentContainerViewRegBase, GenderFragment3.newInstance())
                .addToBackStack(null)
                .commit();
    }
      public static void openDateFragment3(final FragmentManager fragmentManager) {

          defaultTransaction(fragmentManager)
                  .replace(R.id.fragmentContainerViewRegBase, DateFragment.newInstance())
                  .addToBackStack(null)
                  .commit();
      }
}
