package com.calorie.calc.fragments.recipe.scrolling;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentNavigationRecipeBinding;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.utils.BackPressable;
import com.google.android.material.navigation.NavigationBarView;


public class NavigationFragment extends Fragment implements BackPressable, NavigationBarView.OnItemSelectedListener {

    RecipeAndLinks recipeAndLinks;
    private Fragment scrollingFragment;
    private WebViewFragment webView;
    String url;

    private Fragment activeFragment;
    FragmentNavigationRecipeBinding binding;

    public NavigationFragment(RecipeAndLinks recipeAndLinks) {
        this.recipeAndLinks = recipeAndLinks;
        url=recipeAndLinks.getRecipe().getUrl();
        scrollingFragment = new ScrollingFragment(recipeAndLinks);
        webView = new WebViewFragment(url);
        activeFragment = scrollingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("public void onCreate");

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("public void onCreateView");
        return inflater.inflate(R.layout.fragment_navigation_recipe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("public void onViewCreated");
        binding = FragmentNavigationRecipeBinding.bind(view);
        binding.bottomNavigation.setOnItemSelectedListener(this);

        NavigationState.getOnNavigationClick().setValue(false);
        initFragments();
        binding.fab.setTag(false);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean state =(Boolean) v.getTag();
                if(state)
                {
                    NavigationState.getOnNavigationClick().setValue(false);
                  binding.fab.setTag(false);
                   binding.fab.setImageResource(R.drawable.add);
                }
                else
                {
                    binding.bottomNavigation.setSelectedItemId(binding.bottomNavigation.getMenu().getItem(0).getItemId());
                    NavigationState.getOnNavigationClick().setValue(true);
                    binding.fab.setImageResource(R.drawable.close_fab);
                   binding.fab.setTag(true);
                }

            }
        });


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        System.out.println("public void public void onAttach" );
    }

    private void initFragments() {
        System.out.println("public void initFragments"+getChildFragmentManager().getFragments().size());
        if(getChildFragmentManager().getFragments().size()==0)
        {

            getChildFragmentManager().beginTransaction().
                    add(R.id.mainfragment_container, webView, getString(R.string.manual)).hide(webView).
                    add(R.id.mainfragment_container, scrollingFragment, getString(R.string.description)).commit();}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menu_description:
                return loadFragment(scrollingFragment);

            case R.id.menu_manual:
                webView.startLoadUrl();
                return loadFragment(webView);
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
        System.out.println("onBackPressed"+"NavigationFragment");

        if (activeFragment instanceof BackPressable) {

           if( ((BackPressable) activeFragment).onBackPressed())
            return true;
            else
            {
                return false;
              //  getParentFragmentManager().popBackStack();
            }

        }





        return false;
    }
}