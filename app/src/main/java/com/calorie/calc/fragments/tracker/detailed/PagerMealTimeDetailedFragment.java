package com.calorie.calc.fragments.tracker.detailed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentPagerMealTimeDetailedBinding;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.tracker.MealTime;
import com.calorie.calc.utils.progressbar.LinearProgressIndicatorHandler;

import java.util.List;


public class PagerMealTimeDetailedFragment extends Fragment {


    private  MealTime mealTime;

    public PagerMealTimeDetailedFragment( MealTime mealTime) {

        this.mealTime = mealTime;
    }
    private LinearProgressIndicatorHandler fatProgress;
    private LinearProgressIndicatorHandler proteinProgress;
    private LinearProgressIndicatorHandler carbProgress;
    private LinearProgressIndicatorHandler energProgress;


       FragmentPagerMealTimeDetailedBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager_meal_time_detailed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding= FragmentPagerMealTimeDetailedBinding.bind(view);

        energProgress=fatProgress = new LinearProgressIndicatorHandler(binding.linearProgressCalorie,R.color.progress_on,getContext(),null);
        fatProgress = new LinearProgressIndicatorHandler(binding.linearProgressFat,R.color.progress_center,getContext(),binding.textViewProgressFatBottom);
        proteinProgress = new LinearProgressIndicatorHandler(binding.linearProgressProtein,R.color.progress_left,getContext(),binding.textViewProgressProteinBottom);
        carbProgress = new LinearProgressIndicatorHandler(binding.linearProgressCarb,R.color.progress_right,getContext(),binding.textViewProgressCarbBottom);
        mealTime.getRecipeAndLinksItems().observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinksItem>>() {
            @Override
            public void onChanged(List<RecipeAndLinksItem> recipeAndLinksItems) {
                initProgressBar();
            }
        });
        initProgressBar();
    }
    void initProgressBar()
    {


        energProgress.setProgress(mealTime.getTotalEnergy() ,mealTime.getPlanEnercKcal().getQuantity());
        fatProgress.setProgress(mealTime.getTotalFat() ,mealTime.getPlanFat().getQuantity());
        proteinProgress.setProgress(mealTime.getTotalProcNt() ,mealTime.getPlanProcnt().getQuantity());
        carbProgress.setProgress(mealTime.getTotalChockDf(),mealTime.getPlanChocdf().getQuantity());



    }

}