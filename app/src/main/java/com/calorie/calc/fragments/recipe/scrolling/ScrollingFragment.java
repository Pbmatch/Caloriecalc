package com.calorie.calc.fragments.recipe.scrolling;

import static com.calorie.calc.NavigationHelper.openScrollingAddFragments;
import static com.calorie.calc.NavigationHelper.openScrollingDataFragments;
import static com.calorie.calc.fragments.recipe.liked.FabHandler.fabClickState;
import static com.calorie.calc.fragments.recipe.liked.FabHandler.getFabState;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentScrollingBinding;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Recipe;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoListAdapter;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.PicassoHelper;
import com.calorie.calc.utils.RecipeInverter;
import com.calorie.calc.utils.ShareHandler;

import java.util.ArrayList;
import java.util.List;

public class ScrollingFragment extends Fragment implements BackPressable {

    public static final int DEFAULT_CONTROLS_DURATION = 300; // 300 millis
    FragmentScrollingBinding binding;
    InfoListAdapter<Nutrient> energyInfoListAdapter;
    RecipeAndLinks recipeAndLinks;
    Recipe item;


    InfoListAdapter<Nutrient> nutrientInfoListAdapter;
    public ScrollingFragment(RecipeAndLinks item) {

        this.recipeAndLinks = item;
        RecipeInverter.invert(recipeAndLinks);
        this.item=item.getRecipe();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openScrollingDataFragments(getChildFragmentManager(),recipeAndLinks);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      /*   Window w = getActivity().getWindow();

        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/
        return inflater.inflate(R.layout.fragment_scrolling, container, false);

    }

    @Override
    public void onStop() {
        super.onStop();

     /*   Window w = getActivity().getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);*/
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentScrollingBinding.bind(view);
        initView();
    }
    void initView()
    {
        NavigationState.getOnNavigationClick().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
             if(aBoolean)
                { openScrollingAddFragments(getChildFragmentManager());}
                else
                    {

                        onBackPressed();
                    }
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabClickState(recipeAndLinks,getContext(),binding.fab);
            }
        });
        if(getFabState(recipeAndLinks))
        {
            binding.fab.setImageDrawable(getContext().getDrawable(R.drawable.favorite));
            recipeAndLinks.setLiked(true);
        }
        else {binding.fab.setImageDrawable(getContext().getDrawable(R.drawable.favoriteblank));  recipeAndLinks.setLiked(false);}

        binding.textViewTitle.setText(item.getLabel());
        String time="";
        if(item.getTotalTime()!=0.0)
        binding.textViewTime.setText(String.valueOf(item.getTotalTime()));
        else
        {
            String quan = String.format("%.2f",item.getTotalWeight());
            binding.textViewTime.setText(quan+" g");
        }
        if(item.getImage()!=null)
            PicassoHelper.loadRecipe(item.getImage()) .fit()
                    .centerCrop().into(binding.expandedImage);
        StringBuilder ingredients= new StringBuilder();
        for(String str:item.getIngredientLines())
        {
            if(ingredients.length()>0)
            {
                ingredients.append("\n");
            }
            ingredients.append(str);
        }



        setEnergy();

        setNutreints();

        initToolbar();

    }
    void initToolbar()
    {
        binding.toolbarContainer.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              getParentFragmentManager().popBackStack();
            }
        });
        binding.toolbarContainer.imageViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareHandler.send(getContext(),recipeAndLinks.getRecipe().getUrl());
            }
        });
    }



    void setEnergy()
    {

        List<Nutrient> energyList=new ArrayList<>();

        energyList.add( item.getTotalNutrients().getEnercKcal());
        energyList.add(item.getTotalNutrients().getFat());
        energyList.add(item.getTotalNutrients().getChocdf());
        energyList.add(item.getTotalNutrients().getProcnt());
        if (energyInfoListAdapter == null) {
            energyInfoListAdapter = new InfoListAdapter<Nutrient>(getContext());
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.recViewEnergy.setLayoutManager(layoutManager);
        energyInfoListAdapter.setUseRecipeHorizontalItem(true);
        binding.recViewEnergy.setAdapter(energyInfoListAdapter);
        energyInfoListAdapter.setInfoItemList(energyList);

    }
    void setNutreints()
    {
        if (nutrientInfoListAdapter == null) {
            nutrientInfoListAdapter = new InfoListAdapter<Nutrient>(getContext());
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recViewNutrients.setLayoutManager(layoutManager);
        nutrientInfoListAdapter.setNutrient(true);
        binding.recViewNutrients.setAdapter(nutrientInfoListAdapter);
        nutrientInfoListAdapter.setInfoItemList(getNutrientList(true));
        binding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    nutrientInfoListAdapter.setInfoItemList(getNutrientList(isChecked));
            }
        });
    }
    public List<Nutrient> getNutrientList(boolean checked) {
        if(checked)
        {
           return item.getTotalNutrients().getNutrientList();
        }
        else  return item.getTotalDaily().getNutrientList();

    }

    @Override
    public boolean onBackPressed() {

        final Fragment fragmentPanel = getChildFragmentManager()
                .findFragmentById(R.id.container_data_view);
        if (fragmentPanel instanceof BackPressable) {

                ((BackPressable) fragmentPanel).onBackPressed();
                return true;
        }

        return false;
    }
}