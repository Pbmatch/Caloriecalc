package com.calorie.calc.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentMainBinding;
import com.calorie.calc.utils.BackPressable;
import com.google.android.material.navigation.NavigationBarView;


public class MainFragment extends Fragment implements BackPressable, NavigationBarView.OnItemSelectedListener {

    private Fragment trackerFragment = new TrackerFragment();
    private Fragment recipeFragment = new RecipeFragment();
    private Fragment sportFragment = new SportFragment();
    private Fragment profileFragment = new ProfileFragment();
    private Fragment activeFragment = trackerFragment;
    FragmentMainBinding binding;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        initFragments();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentMainBinding.bind(view);
        binding.bottomNavigation.setOnItemSelectedListener(this);

    }

    private void initFragments() {
        if(getChildFragmentManager().getFragments().size()==0)
        {
            System.out.println("initFragments");
            getChildFragmentManager().beginTransaction().
            add(R.id.mainfragment_container, profileFragment, getString(R.string.profile)).hide(profileFragment).
            add(R.id.mainfragment_container, sportFragment, getString(R.string.sport)).hide(sportFragment).
                add(R.id.mainfragment_container, recipeFragment, getString(R.string.recipe)).hide(recipeFragment).
            add(R.id.mainfragment_container, trackerFragment, getString(R.string.tracker)).commit();}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menu_tracker:
               return loadFragment(trackerFragment);

            case R.id.menu_recipes:
                return loadFragment(recipeFragment);

            case R.id.menu_sport:
                return loadFragment(sportFragment);

            case R.id.menu_profile:
                return loadFragment(profileFragment);
        }

        return false;
    }

    private boolean loadFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().hide(activeFragment).show(fragment).commit();
        activeFragment = fragment;
       return true;

    }

    @Override
    public boolean onBackPressed() {


        if (activeFragment instanceof BackPressable) {

            return ((BackPressable) activeFragment).onBackPressed();
         //   return true;
        }



        return false;
    }
}