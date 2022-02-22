package com.calorie.calc.fragments.recipe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRecipeMainBinding;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoListAdapter;

import java.util.List;


public class RecipeInnerHorizFragment extends Fragment {


  private   RecyclerView itemsList;
    private FragmentRecipeMainBinding binding;
    private InfoListAdapter infoListAdapter;
    private TextView textViewTitle;
    private TextView textViewAll;
    MutableLiveData<List<RecipeAndLinks>> recipeState;

    public RecipeInnerHorizFragment(TextView textViewTitle, TextView textViewAll, MutableLiveData<List<RecipeAndLinks>> recipeState) {
        this.textViewTitle = textViewTitle;
        this.textViewAll = textViewAll;
        this.recipeState = recipeState;
    }

    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (infoListAdapter == null) {
            infoListAdapter = new InfoListAdapter(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recipe_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding= FragmentRecipeMainBinding.bind(view);
        initViews();
    }

    @Override
    public void onResume() {

        super.onResume();

        recipeState.observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinks>>() {
            @Override
            public void onChanged(List<RecipeAndLinks> recipeAndLinks) {

                infoListAdapter.addInfoItemList(recipeAndLinks);
            }
        });

    }

    void initViews()
    {
        itemsList= binding.recViewBreakfast;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        itemsList.setLayoutManager(layoutManager);
            infoListAdapter.setUseRecipeHorizontalItem(true);
            itemsList.setAdapter(infoListAdapter);


    }
}