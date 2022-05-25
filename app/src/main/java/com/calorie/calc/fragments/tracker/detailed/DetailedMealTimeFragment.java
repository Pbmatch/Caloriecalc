package com.calorie.calc.fragments.tracker.detailed;

import static com.calorie.calc.utils.MeasureUtils.getEnergyString;
import static com.calorie.calc.utils.MeasureUtils.getStringFromDouble;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDetailedMealTimeBinding;
import com.calorie.calc.databinding.ListHeaderNutrientItemBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.tracker.MealTime;
import com.calorie.calc.info_list.InfoListAdapter;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.SemiCircleArcProgressBar;
import com.calorie.calc.utils.progressbar.CalculateProgressIndicator;
import com.calorie.calc.utils.progressbar.LinearProgressIndicatorHandler;

import java.util.List;


public class DetailedMealTimeFragment extends ListFragment<RecipeAndLinksItem> implements BackPressable {


    private  MealTime mealTime;
    private  TextView textViewEnergy;

    LinearProgressIndicatorHandler fatProgress;
    LinearProgressIndicatorHandler proteinProgress;
    LinearProgressIndicatorHandler carbProgress;
    private SemiCircleArcProgressBar semiCircleArcProgressBar;
    private  FragmentDetailedMealTimeBinding binding;
    private Button buttonAdd;
    private Button buttonFastAdd;
    private RecyclerView recyclerViewNutrient;
    public InfoListAdapter<Nutrient> infoListAdapterNutrients;



    public DetailedMealTimeFragment(MealTime mealTime) {
        this.mealTime = mealTime;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (infoListAdapterNutrients == null) {
            infoListAdapterNutrients = new InfoListAdapter<Nutrient>(getContext());
        }
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




        buttonAdd=binding.button;
        buttonFastAdd=binding.buttonAddLite;
        recyclerViewNutrient =binding.recViewRecipe;


        semiCircleArcProgressBar=binding.semiCircleArcProgressBar;
        textViewEnergy= binding.textViewTotalEnergy;

        fatProgress = new LinearProgressIndicatorHandler(binding.linearProgressFat,R.color.progress_center,getContext(),binding.textViewProgressCenterFat);
        proteinProgress = new LinearProgressIndicatorHandler(binding.linearProgressProtein,R.color.progress_left,getContext(),binding.textViewProgressStartProtein);
        carbProgress = new LinearProgressIndicatorHandler(binding.linearProgressCarb,R.color.progress_right,getContext(),binding.textViewProgressEndCarb);
        infoListAdapter.setUseTrackerVariant(true);
        initProgressBar();
    }
    void initProgressBar()
    {
        semiCircleArcProgressBar.setProgressChangeListener(new SemiCircleArcProgressBar.OnProgressChangeListener() {
            @Override
            public void onChange(int progress) {
                if(progress>99)
                {semiCircleArcProgressBar.setProgressBarColor(R.color.red);}
                else
                {semiCircleArcProgressBar.setProgressBarColor(R.color.progress_on);}
            }
        });


        textViewEnergy.setText(getStringFromDouble(mealTime.getTotalEnergy()) + "из"+"\n" +getEnergyString(mealTime.getEnercKcal().getQuantity(),getContext()));
        fatProgress.setProgress(mealTime.getTotalFat() ,mealTime.getFat().getQuantity());
        proteinProgress.setProgress(mealTime.getTotalProcNt() ,mealTime.getProcnt().getQuantity());
        carbProgress.setProgress(mealTime.getTotalChockDf(),mealTime.getChocdf().getQuantity());
        semiCircleArcProgressBar.setPercent(CalculateProgressIndicator.getProgress(mealTime.getTotalEnergy(),mealTime.getEnercKcal().getQuantity()));


    }



    @Override
    public void startLoadData() {
        mealTime.getRecipeAndLinksItems().observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinksItem>>() {
            @Override
            public void onChanged(List<RecipeAndLinksItem> recipeAndLinksItems) {

                infoListAdapter.setInfoItemList(recipeAndLinksItems);
            }
        });
        infoListAdapterNutrients.setInfoItemList(mealTime.getNutrientListForAllAddedMeals());
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
        return RecyclerView.VERTICAL;
    }

    @Override
    public void initViews(View rootView) {
        recyclerViewNutrient = rootView.findViewById(R.id.rec_view_recipe);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(getLayoutManagerOrientation());
        infoListAdapterNutrients.setNutrient(true);
        recyclerViewNutrient.setLayoutManager(layoutManager);
        infoListAdapterNutrients.setUseRecipeHorizontalItem(isHorizontalItem());
        recyclerViewNutrient.setAdapter(infoListAdapterNutrients);
        if(getListFooter()!=null)
            infoListAdapterNutrients.setFooter(getListFooter().getRoot());
        if(getListHeaderNutrient()!=null) {
            infoListAdapterNutrients.setHeader(getListHeaderNutrient().getRoot());

        }
    }

    public ViewBinding getListHeaderNutrient() {
        ListHeaderNutrientItemBinding viewBinding = ListHeaderNutrientItemBinding
                .inflate(getLayoutInflater(), recyclerViewNutrient, false);
        viewBinding.textViewTitle.setText("Калории");
        viewBinding.textViewCount.setText(
                String.format("%.2f",mealTime.getTotalEnergy()));


        return viewBinding;
        /* infoListAdapter.setHeader(viewBinding.getRoot());;*/
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