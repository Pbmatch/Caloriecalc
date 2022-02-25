package com.calorie.calc.fragments.recipe;

import static com.calorie.calc.utils.MeasureUtils.getIngrTitleString;
import static com.calorie.calc.utils.ViewUtilsKt.animateRotation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentScrollingBinding;
import com.calorie.calc.databinding.ListFooterIngredientItemBinding;
import com.calorie.calc.databinding.ListHeaderIngredientItemBinding;
import com.calorie.calc.edamam.holders.recipeholders.Ingredient;
import com.calorie.calc.edamam.holders.recipeholders.Nutrient;
import com.calorie.calc.edamam.holders.recipeholders.Recipe;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoListAdapter;
import com.calorie.calc.utils.PicassoHelper;

import java.util.ArrayList;
import java.util.List;

public class ScrollingFragment extends Fragment {

    public static final int DEFAULT_CONTROLS_DURATION = 300; // 300 millis
    FragmentScrollingBinding binding;

    RecipeAndLinks recipeAndLinks;
    Recipe item;
    InfoListAdapter<Nutrient> nutrientInfoListAdapter;
    InfoListAdapter<Ingredient> ingredientInfoListAdapter;
    public ScrollingFragment(RecipeAndLinks item) {
        this.recipeAndLinks = item;
        this.item=item.getRecipe();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       /* Window w = getActivity().getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/
        return inflater.inflate(R.layout.fragment_scrolling, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentScrollingBinding.bind(view);
        initView();
    }
    void initView()
    {
        binding.textViewTitle.setText(item.getLabel());
        binding.textViewTime.setText(String.valueOf(item.getTotalTime()));
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


        binding.textViewText.setText(ingredients);
        setEnergy();
        setIngredients();
        binding.detailControlsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTitleAndSecondaryControls();
            }
        });


    }
    private void toggleTitleAndSecondaryControls() {
        if (binding.containerWebView.getVisibility() == View.GONE) {

            Fragment fragment = getChildFragmentManager().findFragmentById(R.id.container_web_view);
            if(fragment==null)
                NavigationHelper.openWebViewFragment(getChildFragmentManager(),item.getUrl());

            animateRotation(binding.detailControlsView,
                    DEFAULT_CONTROLS_DURATION, 180);
            binding.containerWebView.setVisibility(View.VISIBLE);
        } else {

            animateRotation(binding.detailControlsView,
                    DEFAULT_CONTROLS_DURATION, 0);
            binding.containerWebView.setVisibility(View.GONE);
        }
        // view pager height has changed, update the tab layout

    }
    void setIngredients()
    {
        if (ingredientInfoListAdapter == null) {
            ingredientInfoListAdapter = new InfoListAdapter<Ingredient>(getContext());
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recViewIngred.setLayoutManager(layoutManager);
        ingredientInfoListAdapter.setUseRecipeHorizontalItem(true);
        binding.recViewIngred.setAdapter(ingredientInfoListAdapter);
        ListHeaderIngredientItemBinding viewBinding = ListHeaderIngredientItemBinding
                .inflate(getLayoutInflater(), binding.recViewIngred, false);
        viewBinding.textViewText.setText(getIngrTitleString(item.getYield()));
        ingredientInfoListAdapter.setHeader(viewBinding.getRoot());


        ViewBinding viewBindingFooter = ListFooterIngredientItemBinding
                .inflate(getLayoutInflater(), binding.recViewIngred, false);

        ingredientInfoListAdapter.setFooter(viewBindingFooter.getRoot());
        ingredientInfoListAdapter.showFooter(true);

        ingredientInfoListAdapter.setInfoItemList(item.getIngredients());


    }
    void setEnergy()
    {

        List<Nutrient> nutrientList=new ArrayList<>();
        nutrientList.add( item.getTotalNutrients().getEnercKcal());
        nutrientList.add(item.getTotalNutrients().getFat());
        nutrientList.add(item.getTotalNutrients().getChocdf());
        nutrientList.add(item.getTotalNutrients().getProcnt());
        if (nutrientInfoListAdapter == null) {
            nutrientInfoListAdapter = new InfoListAdapter<Nutrient>(getContext());
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.recViewKkal.setLayoutManager(layoutManager);
        nutrientInfoListAdapter.setUseRecipeHorizontalItem(true);
        binding.recViewKkal.setAdapter(nutrientInfoListAdapter);
        nutrientInfoListAdapter.setInfoItemList(nutrientList);

    }
}