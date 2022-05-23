package com.calorie.calc.fragments.tracker.detailed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentPagerMealTimeDetailedBinding;
import com.google.android.material.progressindicator.LinearProgressIndicator;


public class PagerMealTimeDetailedFragment extends Fragment {


   private TextView textViewFat;
    private TextView textViewProtein;
    private  TextView textViewCarb;
    private LinearProgressIndicator progressIndicatorFat;
    private LinearProgressIndicator progressIndicatorProtein;
    private LinearProgressIndicator progressIndicatorCarb;
    private LinearProgressIndicator progressIndicatorEnergy;
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
        textViewFat=binding.textViewProgressFatBottom;
        textViewProtein=binding.textViewProgressProteinBottom;
        textViewCarb=binding.textViewProgressCarbBottom;
        progressIndicatorEnergy=binding.linearProgressCalorie;
        progressIndicatorProtein=binding.linearProgressProtein;
        progressIndicatorCarb=binding.linearProgressCarb;
        progressIndicatorFat=binding.linearProgressFat;
    }
}