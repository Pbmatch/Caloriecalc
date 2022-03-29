package com.calorie.calc.fragments.tracker.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.ListFragment;

public class ExerciseListFragment extends ListFragment {


    public ExerciseListFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_body_list, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {
        return null;
    }

    @Override
    public void startLoadData() {

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
        return 0;
    }

    @Override
    public void initViews(View rootView) {

    }

    @Override
    public void reloadContent() {

    }
}