package com.calorie.calc.fragments.recipe;

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
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.info_list.InfoListAdapter;

import java.util.List;


public abstract class RecipeListFragment<T> extends Fragment {


    public RecyclerView itemsList;
    public InfoListAdapter<T> infoListAdapter;
    public RecipeType type;
    public MutableLiveData<List<T>> recipeState;
    RecipeRecipient recipeRecipient;

    public RecipeListFragment(RecipeType type) {

        this.type = type;
    }

    public RecipeListFragment(MutableLiveData<List<T>> recipeState) {
        this.recipeState = recipeState;
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
        initViews(view);
        initList(view);
        setListener();
        startLoadData();

    }

    public abstract void startLoadData();

    public abstract void setListener();


    @Override
    public void onResume() {

        super.onResume();

    }

    public abstract boolean isHorizontalItem();

    public abstract int getLayoutManagerOrientation();

    public abstract void initViews(View rootView);

    public void initList(View rootView) {

        itemsList = rootView.findViewById(R.id.rec_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(getLayoutManagerOrientation());
        itemsList.setLayoutManager(layoutManager);
        infoListAdapter.setUseRecipeHorizontalItem(isHorizontalItem());
        itemsList.setAdapter(infoListAdapter);


    }
}