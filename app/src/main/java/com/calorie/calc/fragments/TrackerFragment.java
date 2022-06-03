package com.calorie.calc.fragments;

import static com.calorie.calc.NavigationHelper.openTracerMainFragment;
import static com.calorie.calc.utils.MeasureUtils.getEnergyString;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.calorie.calc.MainActivity;
import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.databinding.FragmentTrackerBinding;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.tracker.Calculator;
import com.calorie.calc.fragments.tracker.MainTrackerFragment;
import com.calorie.calc.fragments.tracker.MealTime;
import com.calorie.calc.fragments.tracker.detailed.DetailedFragment;
import com.calorie.calc.utils.SemiCircleArcProgressBar;
import com.calorie.calc.utils.progressbar.CalculateProgressIndicator;
import com.calorie.calc.utils.progressbar.LinearProgressIndicatorMainPageHandler;

import java.util.List;


public class TrackerFragment extends Fragment implements Observer<List<RecipeAndLinksItem>> {

    private LinearProgressIndicatorMainPageHandler fatProgress;
    private LinearProgressIndicatorMainPageHandler proteinProgress;
    private LinearProgressIndicatorMainPageHandler carbProgress;
    private Calculator calculator;
    private SemiCircleArcProgressBar semiCircleArcProgressBar;

    private FragmentTrackerBinding binding;
    public TrackerFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        openTracerMainFragment(getChildFragmentManager(),new MainTrackerFragment());
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentTrackerBinding.bind(view);
        semiCircleArcProgressBar=binding.semiCircleArcProgressBar;
        binding.textViewDetailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new DetailedFragment());
            }
        });

        fatProgress = new LinearProgressIndicatorMainPageHandler(binding.linearProgressFat,R.color.progress_center,getContext(),binding.textViewProgressCenterFat);
        proteinProgress = new LinearProgressIndicatorMainPageHandler(binding.linearProgressProtein,R.color.progress_left,getContext(),binding.textViewProgressStartProtein);
        carbProgress = new LinearProgressIndicatorMainPageHandler(binding.linearProgressCarb,R.color.progress_right,getContext(),binding.textViewProgressEndCarb);


          calculator = new Calculator();
        setProgress();
        for(MealTime mealTime:MealTime.values())
        {
            mealTime.getRecipeAndLinksItems().observe(getViewLifecycleOwner(),this);
        }
        MainActivity.getUser().getExerciseItemList().observe(getViewLifecycleOwner(), new Observer<List<ExerciseItem>>() {
            @Override
            public void onChanged(List<ExerciseItem> exerciseItems) {
                double energy=0;
                for(ExerciseItem item:exerciseItems)
                {
                    energy=energy+item.getEnergy();

                }
                String burned=getString(R.string.burned_lite) +
                        "\n" +getEnergyString(energy,getContext());
                binding.textViewBurned.setText(burned);
                exercise=energy;
                setProgress();
            }
        });

    }
    double exercise =0;

    @Override
    public void onChanged(List<RecipeAndLinksItem> recipeAndLinksItems) {
        setProgress();
    }
    void setProgress()
    {
        fatProgress.setProgress(calculator.getTotalDay(MealTime::getTotalFat),calculator.getFullPlanFat().getQuantity() );
        proteinProgress.setProgress(calculator.getTotalDay(mealTime -> mealTime.getTotalProcNt()),calculator.getFullPlanProcnt().getQuantity());
        carbProgress.setProgress(calculator.getTotalDay(mealTime -> mealTime.getTotalChockDf()),calculator.getFullPlanChocdf().getQuantity());
        double energy=calculator.getTotalDay(mealTime -> mealTime.getTotalEnergy());
        String eaten=getString(R.string.eaten) +
                "\n" +getEnergyString(energy,getContext());
        binding.textViewEaten.setText(eaten);
         double mainEnergyDouble = calculator.getTotalDay(mealTime -> mealTime.getTotalEnergy())-exercise;
         double remain = calculator.getFullEnercKcal().getQuantity()-mainEnergyDouble;
        String mainEnergyString= "Осталось" + "\n" +getEnergyString(remain,getContext()) +
                "\n" +"Всего"+getEnergyString(calculator.getFullEnercKcal().getQuantity(),getContext())
                ;
        binding.textViewTotalEnergy.setText(mainEnergyString);

        semiCircleArcProgressBar.setPercent(CalculateProgressIndicator.getProgress(mainEnergyDouble,calculator.getFullEnercKcal().getQuantity()));

    }


}