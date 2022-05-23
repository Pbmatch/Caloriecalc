package com.calorie.calc.fragments.tracker.detailed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDetailedMealTimeBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.TotalNutrients;
import com.calorie.calc.fragments.tracker.MealTime;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.SemiCircleArcProgressBar;
import com.calorie.calc.utils.progressbar.CalculateProgressIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;


public class DetailedMealTimeFragment extends ListFragment<Nutrient> implements BackPressable {


    private  MealTime mealTime;
    private  TextView textViewEnergy;
    private TextView textViewFat;
    private TextView textViewProtein;
    private TextView textViewCarb;
    private LinearProgressIndicator progressIndicatorFat;
    private LinearProgressIndicator progressIndicatorProtein;
    private LinearProgressIndicator progressIndicatorCarb;
    private SemiCircleArcProgressBar semiCircleArcProgressBar;
    private  FragmentDetailedMealTimeBinding binding;
    private Button buttonAdd;
    private Button buttonFastAdd;
    private RecyclerView recyclerViewRecipe;




    public DetailedMealTimeFragment(MealTime mealTime) {
        this.mealTime = mealTime;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_meal_time, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {
        return null;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentDetailedMealTimeBinding.bind(view);
        textViewEnergy= binding.textViewTotalEnergy;
        textViewProtein=binding.textViewProgressStartProtein;
        textViewFat=binding.textViewProgressCenterFat;
        textViewCarb=binding.textViewProgressEndCarb;
        progressIndicatorFat=binding.linearProgressFat;
        progressIndicatorProtein=binding.linearProgressProtein;
        progressIndicatorCarb=binding.linearProgressCarb;
        semiCircleArcProgressBar=binding.semiCircleArcProgressBar;
        buttonAdd=binding.button;
        buttonFastAdd=binding.buttonAddLite;
        recyclerViewRecipe=binding.recViewRecipe;

        textViewEnergy.setText("Всего"+mealTime.getEnercKcal().getQuantity() + "Съедено"+mealTime.getDone(new TotalNutrients().new EnercKcal()).getQuantity());
        initProgressBar();
    }
    void initProgressBar()
    {
        progressIndicatorFat.setProgress(CalculateProgressIndicator.getProgress(mealTime.getDone(new TotalNutrients().new Fat()).getQuantity(),mealTime.getFat().getQuantity()));
        progressIndicatorProtein.setProgress(CalculateProgressIndicator.getProgress(mealTime.getDone(new TotalNutrients().new Procnt()).getQuantity(),mealTime.getProcnt().getQuantity()));
        progressIndicatorCarb.setProgress(CalculateProgressIndicator.getProgress(mealTime.getDone(new TotalNutrients().new Chocdf()).getQuantity(),mealTime.getChocdf().getQuantity()));
        semiCircleArcProgressBar.setPercent(CalculateProgressIndicator.getProgress(mealTime.getDone(new TotalNutrients().new EnercKcal()).getQuantity(),mealTime.getEnercKcal().getQuantity()));
    }

    @Override
    public void startLoadData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadMoreItems() {

    }

    @Override
    public boolean isHorizontalItem() {
        return false;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return 0;
    }

    @Override
    public void initViews(View rootView) {

    }

    @Override
    public ViewBinding getListHeader() {
        return null;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }


    @Override
    public void reloadContent() {

    }
}