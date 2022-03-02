package com.calorie.calc.fragments.recipe;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.scrolling.ScrollingFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;


public class RecipeVerticalFragment extends RecipeListFragment<RecipeAndLinks> implements BackPressable {

    public RecipeVerticalFragment(MutableLiveData<List<RecipeAndLinks>> recipeState)
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

    }

    @Override
    public void startLoadData() {

    }

    @Override
    public  void setListener() {

                infoListAdapter.addInfoItemList(recipeState.getValue());

        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinks>() {
            @Override
            public void selected(RecipeAndLinks selectedItem) {
                NavigationHelper.openDietFragment(getActivity().getSupportFragmentManager(),new ScrollingFragment(selectedItem));
            }
        });
    }

    @Override
    public boolean isHorizontalItem() {
        return false;
    }

    @Override
    public  int getLayoutManagerOrientation() {
       return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void initViews(View rootView) {

    }

    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }
}