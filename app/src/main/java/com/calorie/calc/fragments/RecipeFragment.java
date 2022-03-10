package com.calorie.calc.fragments;

import static com.calorie.calc.NavigationHelper.openRecipeMainFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRecipeBinding;
import com.calorie.calc.fragments.recipe.RecipeMainFragment;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.filter.FilterFragment;
import com.calorie.calc.fragments.recipe.liked.LikedFragment;
import com.calorie.calc.fragments.recipe.product.ProductContainerFragment;
import com.calorie.calc.utils.BackPressable;

import java.util.ArrayList;


public class RecipeFragment extends Fragment implements BackPressable {


    FragmentRecipeBinding binding;

    public RecipeFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        openRecipeMainFragment(getChildFragmentManager(),new RecipeMainFragment());
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    @Override
    public void onStop() {

        super.onStop();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       //TODO Перенести инициализацию спискка продуктов
        if(RecipeState.getProductLiveData().getValue()==null)
        {RecipeState.getProductLiveData().setValue(new ArrayList<>());}

        binding = FragmentRecipeBinding.bind(view);
        binding.editTextTextPersonName.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(event.getAction() == MotionEvent.ACTION_UP) {
                if(event.getRawX() >= (binding.editTextTextPersonName.getRight() - binding.editTextTextPersonName.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    // your action here

                    return true;
                }
            }
            return false;
        });
        binding.imageViewFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openDietFragment(getParentFragment().getParentFragmentManager(),new LikedFragment(RecipeState.getRecipeAndLinksMutableLiveData()));
            }
        });
        binding.imageViewShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openDietFragment(getParentFragment().getParentFragmentManager(),new ProductContainerFragment());
            }
        });

        binding.imageViewFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openDietFragment(getParentFragment().getParentFragmentManager(),new FilterFragment());
            }
        });

      /*  binding.imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoiceToText.start(getActivity(),getContext());
            }
        });*/

    }

    @Override
    public boolean onBackPressed() {
        final Fragment fragmentPanel = getChildFragmentManager()
                .findFragmentById(R.id.recipe_container);
        if (fragmentPanel instanceof BackPressable) {

            ((BackPressable) fragmentPanel).onBackPressed();
            return true;
        }
        return false;
    }
}