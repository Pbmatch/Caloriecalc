package com.calorie.calc.fragments;

import static com.calorie.calc.NavigationHelper.openTracerMainFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.fragments.tracker.MainTrackerFragment;


public class TrackerFragment extends Fragment {


    public TrackerFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        openTracerMainFragment(getChildFragmentManager(),new MainTrackerFragment());
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracker, container, false);
    }
}