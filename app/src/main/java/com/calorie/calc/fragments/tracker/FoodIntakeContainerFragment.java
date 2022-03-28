package com.calorie.calc.fragments.tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.utils.BackPressable;

import java.util.ArrayList;
import java.util.List;

public class FoodIntakeContainerFragment extends ListFragment<Fragment> implements BackPressable {


    public FoodIntakeContainerFragment() {
        super();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {
        return null;
    }

    @Override
    public void startLoadData() {
        // super.startLoadData();


        List<Fragment> fragmentList = new ArrayList<>();
       // fragmentList.add(new FoodIntakeFragment(getChildFragmentManager()));
       fragmentList.add(new FoodIntakeFragment(getChildFragmentManager(),MealTime.BREAKFAST));
        fragmentList.add(new FoodIntakeFragment(getChildFragmentManager(),MealTime.DINNER));
        fragmentList.add(new FoodIntakeFragment(getChildFragmentManager(),MealTime.LUNCH));
       fragmentList.add(new FoodIntakeFragment(getChildFragmentManager(),MealTime.SNACK));

        infoListAdapter.setInfoItemList(fragmentList);

    }


    @Override
    public void setListener() {

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
        return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void initViews(View rootView) {

    }


    @Override
    public void reloadContent() {

    }

    @Override
    public boolean onBackPressed() {
        // getParentFragmentManager().popBackStack();
        return false;
    }
}