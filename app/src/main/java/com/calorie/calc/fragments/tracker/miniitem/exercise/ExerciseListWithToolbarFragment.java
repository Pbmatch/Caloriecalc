package com.calorie.calc.fragments.tracker.miniitem.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.fragments.tracker.ExerciseAdapter;


public class ExerciseListWithToolbarFragment extends ExerciseListFragment {
   RecyclerView recyclerView;
    ExerciseAdapter exerciseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracer_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView =view.findViewById(R.id.rec_view );

         exerciseAdapter = new ExerciseAdapter(recyclerView,getContext(),getActivity().getSupportFragmentManager());
         MainActivity.getUser().getExerciseItemList().observe(getViewLifecycleOwner(), exerciseAdapter);

    }
}