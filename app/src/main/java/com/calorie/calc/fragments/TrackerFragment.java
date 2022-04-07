package com.calorie.calc.fragments;

import static com.calorie.calc.NavigationHelper.openTracerMainFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.fragments.tracker.MainTrackerFragment;
import com.calorie.calc.fragments.tracker.detailed.DetailedFragment;


public class TrackerFragment extends Fragment {

    TextView textViewDetailed;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewDetailed=view.findViewById(R.id.textView_detailed);
        textViewDetailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new DetailedFragment());
            }
        });
    }
}