package com.calorie.calc.fragments.recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;


public class LikedFragment extends RecipeInnerHorizFragment<RecipeAndLinks> {


    public LikedFragment(MutableLiveData<List<RecipeAndLinks>> recipeState) {
        super(recipeState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liked, container, false);
    }

    @Override
    void startLoadData() {

    }

    @Override
    void setListener() {
        infoListAdapter.addInfoItemList(recipeState.getValue());

        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinks>() {
            @Override
            public void selected(RecipeAndLinks selectedItem) {
                NavigationHelper.openDietFragment(getActivity().getSupportFragmentManager(),new ScrollingFragment(selectedItem));
            }
        });
    }

    @Override
    boolean isHorizontalItem() {
        return false;
    }

    @Override
    int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }
}