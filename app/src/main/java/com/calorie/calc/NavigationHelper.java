package com.calorie.calc;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.calorie.calc.fragments.MainFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.scrolling.InnerAddFragment;
import com.calorie.calc.fragments.recipe.scrolling.InnerDataFragment;
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
                 .replace(R.id.main_activ_container, new MainFragment(),MAIN_FRAGMENT_TAG)
                //.replace(R.id.main_activ_container, new ScrollingFragment())
                 .addToBackStack(MAIN_FRAGMENT_TAG)
                .commit();
    }
    public static void openRecipeMainFragment(final FragmentManager fragmentManager, Fragment fragment) {


           defaultTransaction(fragmentManager)
                   .replace(R.id.recipe_container, fragment,"main")
                   .addToBackStack("main")
                   .commit();

    }
    public static void openRecipeVerticalMainFragment(final FragmentManager fragmentManager, Fragment fragment) {


            defaultTransaction(fragmentManager)
                    .replace(R.id.recipe_container, fragment,"vertic")
                    .addToBackStack("vertic")
                    .commit();





    }
    public static void openFragment(final FragmentManager fragmentManager, Fragment fragment,int container) {

        defaultTransaction(fragmentManager)
                .replace(container, fragment,"eee")
                 .addToBackStack("verrrtic")
                .commit();
    }
    public static void openSeeFragment(final FragmentManager fragmentManager, Fragment fragment,int container) {

        defaultTransaction(fragmentManager)
                .replace(container, fragment)
                //.addToBackStack("verrrtic")
                .commit();
    }
    public static void openDietFragment(final FragmentManager fragmentManager, Fragment fragment ) {

        defaultTransaction(fragmentManager)
                .replace(R.id.main_activ_container, fragment)
               .addToBackStack(null)
                .commit();
    }
    public static void openNavigationFragment(final FragmentManager fragmentManager, Fragment fragment ) {

        defaultTransaction(fragmentManager)
                .replace(R.id.main_activ_container, fragment)
                 .addToBackStack(null)
                .commit();
    }


    public static void openScrollingDataFragments(final FragmentManager fragmentManager, RecipeAndLinks item) {

        defaultTransaction(fragmentManager)
                .replace(R.id.container_data_view, new InnerDataFragment(item))
                .addToBackStack(null)
                .commit();
    }
    public static void openScrollingAddFragments(final FragmentManager fragmentManager  ) {

        defaultTransaction(fragmentManager)
                .replace(R.id.container_data_view,new  InnerAddFragment())
                .addToBackStack(null)
                .commit();
    }
    public static void openAddProductFragment(final FragmentManager fragmentManager,Fragment fragment  ) {

        defaultTransaction(fragmentManager)
                .replace(R.id.main_activ_container,fragment)
                .addToBackStack(null)
                .commit();
    }
}
