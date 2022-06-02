package com.calorie.calc.fragments.tracker.detailed;

import static com.calorie.calc.utils.MeasureUtils.getEnergyString;
import static com.calorie.calc.utils.MeasureUtils.getStringFromDouble;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDetailedMealTimeBinding;
import com.calorie.calc.databinding.ListHeaderNutrientItemBinding;
import com.calorie.calc.databinding.ToolbarMiniListBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.holders.recipeholders.TotalNutrients;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.fragments.tracker.MealTime;
import com.calorie.calc.fragments.tracker.miniitem.exercise.DeleteDialog;
import com.calorie.calc.info_list.InfoListAdapter;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;
import com.calorie.calc.utils.SemiCircleArcProgressBar;
import com.calorie.calc.utils.progressbar.CalculateProgressIndicator;
import com.calorie.calc.utils.progressbar.LinearProgressIndicatorHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class DetailedMealTimeFragment extends ListFragment<RecipeAndLinksItem> implements BackPressable {


    private  MealTime mealTime;
    private  TextView textViewEnergy;
    private  ToolbarMiniListBinding toolbarMiniListBinding;

    private LinearProgressIndicatorHandler fatProgress;
    private LinearProgressIndicatorHandler proteinProgress;
    private LinearProgressIndicatorHandler carbProgress;
    private SemiCircleArcProgressBar semiCircleArcProgressBar;
    private  FragmentDetailedMealTimeBinding binding;
    private Button buttonAdd;
    private Button buttonFastAdd;
    private RecyclerView recyclerViewNutrient;
    public InfoListAdapter<Nutrient> infoListAdapterNutrients;

   //нутриентхолдер изменить он делит на колво порций
    //обработать калорийность и порции
    //обработать нажатие и долгое нажатие, добавить диалоговое окно и в удалении продуктов тоже


    //todo закидка рецепта в счетчик меняет его изнутри
    //кривой диалог удаления

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
        setToolbar();
    }
    void initProgressBar()
    {
        semiCircleArcProgressBar.setProgressChangeListener(new SemiCircleArcProgressBar.OnProgressChangeListener() {
            @Override
            public void onChange(int progress) {
                if(progress>99)
                {
                    semiCircleArcProgressBar.setProgressBarColor(getContext().getColor(R.color.red));
                }
                else
                {
                    semiCircleArcProgressBar.setProgressBarColor(getContext().getColor(R.color.progress_on));
                }
            }
        });


        textViewEnergy.setText(getStringFromDouble(mealTime.getTotalEnergy()) + " из"+"\n" +getEnergyString(mealTime.getEnercKcal().getQuantity(),getContext()));
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
                infoListAdapterNutrients.setInfoItemList(mealTime.getNutrientListForAllAddedMeals(true));
                initProgressBar();
            }
        });
       // infoListAdapterNutrients.setInfoItemList(mealTime.getNutrientListForAllAddedMeals(false));
    }

    @Override
    public void setListener() {
        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinksItem>() {
            @Override
            public void selected(RecipeAndLinksItem selectedItem) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new NavigationFragment(selectedItem));
            }

            @Override
            public void held(RecipeAndLinksItem selectedItem) {
                DeleteDialog dialog = new DeleteDialog(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mealTime.getRecipeAndLinksItems().removeItem(selectedItem);

                    }
                });
                dialog.show(getParentFragmentManager(),"");

                super.held(selectedItem);
            }
        });

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
        toolbarMiniListBinding=ToolbarMiniListBinding.bind(rootView.findViewById(R.id.toolbarId));
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


        viewBinding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                infoListAdapterNutrients.setInfoItemList(mealTime.getNutrientListForAllAddedMeals(isChecked));
                for(Nutrient nutrient:infoListAdapterNutrients.getItemsList())
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
        /* infoListAdapter.setHeader(viewBinding.getRoot());;*/
    }
    private void setToolbar()
    {
        toolbarMiniListBinding.toolbarImageViewRight.setImageResource(R.drawable.share);
        toolbarMiniListBinding.toolbarImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        toolbarMiniListBinding.toolbarTextViewTitle.setText(mealTime.getTitle());
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd-MMMM-yyyy"
                );
        String formattedDate = formatter.format(date);
        toolbarMiniListBinding.toolbarTextViewText.setText(formattedDate);

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