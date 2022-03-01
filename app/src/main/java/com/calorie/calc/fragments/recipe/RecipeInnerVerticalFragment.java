package com.calorie.calc.fragments.recipe;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;


public class RecipeInnerVerticalFragment extends RecipeInnerHorizFragment<RecipeAndLinks> implements BackPressable {

    public RecipeInnerVerticalFragment(MutableLiveData<List<RecipeAndLinks>> recipeState)
    {
        super(recipeState);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewText.setVisibility(View.GONE);
        textViewTitle.setVisibility(View.GONE);
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

    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }
}