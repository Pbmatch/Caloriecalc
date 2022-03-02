package com.calorie.calc.fragments.recipe;

import static com.calorie.calc.fragments.recipe.RecipeType.BREAKFAST;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRecipeMainBinding;
import com.calorie.calc.fragments.recipe.diet.DietType;


public class RecipeMainFragment extends Fragment {



    FragmentRecipeMainBinding binding;

    public RecipeMainFragment() {

    }

    @Override
    public void onAttach(@NonNull final Context context) {

        super.onAttach(context);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_recipe_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding= FragmentRecipeMainBinding.bind(view);
        RecipeState.getProgressBar().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    binding.progressBarLoad.setVisibility(View.VISIBLE);
                else binding.progressBarLoad.setVisibility(View.GONE);
            }
        });
        RecipeState.getProgressBar().setValue(false);

    }



    void initViews( )
    {

        if(RecipeState.getDietType().getValue()==null)
        {
        DietType.ALL.setSelect(true);
        RecipeState.getDietType().setValue(DietType.ALL);}
        buildLists(RecipeState.getDietType().getValue());
        openFragments();


    }
    void buildLists(DietType type)
    {
        RecipeType.setDietPlanToAll(type);


    }
    void openFragments()
    {
      //  NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDietFragment(DIET_PLAN),DIET_PLAN.getContainer());
      //  NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDishFragment(POPULAR_RECIPE),POPULAR_RECIPE.getContainer());
       // NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerAddedDishFragment(ADDED_RECIPE),ADDED_RECIPE.getContainer());
        NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDishFragment(BREAKFAST),BREAKFAST.getContainer());
       //  NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDishFragment(DINNER),DINNER.getContainer());
        // NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDishFragment(SNACKS),SNACKS.getContainer());
    }

}
