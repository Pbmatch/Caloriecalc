package com.calorie.calc.fragments.tracker.detailed;

import static com.calorie.calc.utils.MeasureUtils.getEnergyString;
import static com.calorie.calc.utils.MeasureUtils.getStringFromDouble;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDetailedBinding;
import com.calorie.calc.databinding.ListHeaderNutrientItemBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.holders.recipeholders.TotalNutrients;
import com.calorie.calc.fragments.tracker.Calculator;
import com.calorie.calc.fragments.tracker.MealTime;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.SemiCircleArcProgressBar;
import com.calorie.calc.utils.progressbar.CalculateProgressIndicator;
import com.calorie.calc.utils.progressbar.LinearProgressIndicatorHandler;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;


public class DetailedFragment extends ListFragment<Nutrient> implements BackPressable, Observer<List<RecipeAndLinksItem>> {

   private ViewPager2 viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView imageViewToolbarBack;
    private TextView toolbarTextViewTitle;
    private ImageView imageViewToolbarShare;
    private  FragmentDetailedBinding binding;

    private LinearProgressIndicatorHandler fatProgress;
    private LinearProgressIndicatorHandler proteinProgress;
    private LinearProgressIndicatorHandler carbProgress;
    private Calculator calculator;
    private SemiCircleArcProgressBar semiCircleArcProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculator = new Calculator();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detailed, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentDetailedBinding.bind(view);
        semiCircleArcProgressBar=binding.semiCircleArcProgressBar;
        viewPagerAdapter = new ViewPagerAdapter(this);
        imageViewToolbarBack =view.findViewById(R.id.toolbarImageViewBack);
        toolbarTextViewTitle =view.findViewById(R.id.toolbarTextViewTitle);
        imageViewToolbarShare  =view.findViewById(R.id.imageViewShare);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText( MealTime.values()[position].getTitle())
        ).attach();
        imageViewToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        fatProgress = new LinearProgressIndicatorHandler(binding.linearProgressFat,R.color.progress_center,getContext(),binding.textViewProgressCenterFat);
        proteinProgress = new LinearProgressIndicatorHandler(binding.linearProgressProtein,R.color.progress_left,getContext(),binding.textViewProgressStartProtein);
        carbProgress = new LinearProgressIndicatorHandler(binding.linearProgressCarb,R.color.progress_right,getContext(),binding.textViewProgressEndCarb);
        for(MealTime mealTime:MealTime.values())
        {
            mealTime.getRecipeAndLinksItems().observe(getViewLifecycleOwner(),this);
        }
        setProgress();

    }

    @Override
    public void startLoadData() {
       // infoListAdapter.setInfoItemList(calculator.getNutrientListForMealTimes(false));
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
        infoListAdapter.setNutrient(true);
    }

    @Override
    public ViewBinding getListHeader() {
         ListHeaderNutrientItemBinding viewBinding = ListHeaderNutrientItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.textViewTitle.setText("Калории");


        viewBinding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                infoListAdapter.setInfoItemList(calculator.getNutrientListForMealTimes(isChecked));
                for(Nutrient nutrient:infoListAdapter.getItemsList())
                {
                    if(nutrient!=null&&nutrient.getClass().equals(TotalNutrients.EnercKcal.class))
                    {
                        viewBinding.textViewCount.setText(getStringFromDouble(nutrient.getSummQuantity())+nutrient.getUnit());
                    }
                }


            }
        });

        viewBinding.switch1.setChecked(true);

        return viewBinding;
    }

    void setProgress()
    {
        fatProgress.setProgress(calculator.getTotalDay(MealTime::getTotalFat),calculator.getFullPlanFat().getQuantity() );
        proteinProgress.setProgress(calculator.getTotalDay(mealTime -> mealTime.getTotalProcNt()),calculator.getFullPlanProcnt().getQuantity());
        carbProgress.setProgress(calculator.getTotalDay(mealTime -> mealTime.getTotalChockDf()),calculator.getFullPlanChocdf().getQuantity());
        double mainEnergyDouble = calculator.getTotalDay(mealTime -> mealTime.getTotalEnergy());
        String mainEnergyString= getEnergyString(mainEnergyDouble,getContext()) +" "+getString(R.string.from) +
                "\n" +getEnergyString(calculator.getFullEnercKcal().getQuantity(),getContext())
                ;
        binding.textViewTotalEnergy.setText(mainEnergyString);
        semiCircleArcProgressBar.setPercent(CalculateProgressIndicator.getProgress(mainEnergyDouble,calculator.getFullEnercKcal().getQuantity()));
        infoListAdapter.setInfoItemList(calculator.getNutrientListForMealTimes(false));
    }


    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onChanged(List<RecipeAndLinksItem> recipeAndLinksItems) {
        setProgress();
    }

    @Override
    public void reloadContent() {

    }


    public class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // Return a NEW fragment instance in createFragment(int)
            Fragment fragment = new PagerMealTimeDetailedFragment(MealTime.values()[position]);

            return fragment;
        }

        @Override
        public int getItemCount() {
            return MealTime.values().length;
        }
    }

}