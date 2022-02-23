package com.calorie.calc.fragments.recipe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRecipeInnerHorizBinding;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoListAdapter;

import java.util.List;


public abstract class RecipeInnerHorizFragment<T> extends Fragment {


    protected   RecyclerView itemsList;
    private FragmentRecipeInnerHorizBinding binding;
    protected InfoListAdapter<T> infoListAdapter;
    protected RecipeMainType type;
    private String textTitle;

    MutableLiveData<List<RecipeAndLinks>> recipeState;

    public RecipeInnerHorizFragment(RecipeMainType type) {

        this.type=type;
        this.recipeState = type.getRecipeState();
    }


    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);
        this.textTitle = getString(type.getTitleRecource());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (infoListAdapter == null) {
            infoListAdapter = new InfoListAdapter<T>(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recipe_inner_horiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding= FragmentRecipeInnerHorizBinding.bind(view);
        initViews();
        setListener();
        startLoadData();

    }
   abstract void startLoadData();

    abstract void setListener();


    @Override
    public void onResume() {

        super.onResume();



    }

    void initViews()
    {
        itemsList= binding.recipeInnerRecView;
        binding.recipeInnerTextViewTitle.setText(textTitle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        itemsList.setLayoutManager(layoutManager);
            infoListAdapter.setUseRecipeHorizontalItem(true);
            itemsList.setAdapter(infoListAdapter);


    }
}