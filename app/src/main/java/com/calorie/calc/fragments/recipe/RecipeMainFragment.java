package com.calorie.calc.fragments.recipe;

import static com.calorie.calc.fragments.recipe.RecipeMainType.ADDED_RECIPE;
import static com.calorie.calc.fragments.recipe.RecipeMainType.BREAKFAST;
import static com.calorie.calc.fragments.recipe.RecipeMainType.DIET_PLAN;
import static com.calorie.calc.fragments.recipe.RecipeMainType.DINNER;
import static com.calorie.calc.fragments.recipe.RecipeMainType.POPULAR_RECIPE;
import static com.calorie.calc.fragments.recipe.RecipeMainType.SNACKS;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.RecipeStateAdapter;
import com.calorie.calc.databinding.FragmentRecipeMainBinding;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoListAdapter;

import java.util.List;


public class RecipeMainFragment extends Fragment {


    RecyclerView itemsList;
    FragmentRecipeMainBinding binding;
    protected InfoListAdapter infoListAdapter;
    public RecipeMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (infoListAdapter == null) {
            infoListAdapter = new InfoListAdapter(getContext());
        }
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
        LikedRecipeState.getProgressBar().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                    binding.progressBarLoad.setVisibility(View.VISIBLE);
                else binding.progressBarLoad.setVisibility(View.GONE);
            }
        });
        LikedRecipeState.getProgressBar().setValue(false);
        initViews();
    }

    @Override
    public void onResume() {

        super.onResume();
        System.out.println("onResume" );
        RecipeStateAdapter.getRecipeState().observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinks>>() {
            @Override
            public void onChanged(List<RecipeAndLinks> recipeAndLinks) {
                System.out.println("onChanged"+recipeAndLinks.size());
                infoListAdapter.addInfoItemList(recipeAndLinks);
            }
        });

    }

    void initViews( )
    {

        if(LikedRecipeState.getDietType().getValue()==null)
        {
        DietType.ALL.setSelect(true);
        LikedRecipeState.getDietType().setValue(DietType.ALL);}
        buildLists(LikedRecipeState.getDietType().getValue());
        openFragments();


    }
    void buildLists(DietType type)
    {
        DIET_PLAN.build(type.getMap());
        POPULAR_RECIPE.build(type.getMap());
        ADDED_RECIPE.build(type.getMap());
        BREAKFAST.build(type.getMap());
        DINNER.build(type.getMap());
        SNACKS.build(type.getMap());

    }
    void openFragments()
    {
        NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDietFragment(DIET_PLAN),DIET_PLAN.getContainer());
      //  NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDishFragment(POPULAR_RECIPE),POPULAR_RECIPE.getContainer());
       // NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerAddedDishFragment(ADDED_RECIPE),ADDED_RECIPE.getContainer());
        NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDishFragment(BREAKFAST),BREAKFAST.getContainer());
         NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDishFragment(DINNER),DINNER.getContainer());
        // NavigationHelper.openFragment(getChildFragmentManager(),new RecipeInnerDishFragment(SNACKS),SNACKS.getContainer());
    }

}
