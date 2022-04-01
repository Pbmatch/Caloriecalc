package com.calorie.calc.fragments.tracker;

import static com.calorie.calc.NavigationHelper.openFoodIntakeContainerFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;


public class MainTrackerFragment extends Fragment {

   RecyclerView recyclerViewExercise;
    RecyclerView recyclerViewBodySize;
    RecyclerView recyclerViewFoto;

   ExerciseAdapter exerciseAdapter;
   BodySizeAdapter bodySizeAdapter;
    FotoAdapter fotoAdapter;

    public MainTrackerFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main_tracker, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewExercise =view.findViewById(R.id.rec_view_activ);
        recyclerViewFoto=view.findViewById(R.id.rec_view_foto);
        recyclerViewBodySize = view.findViewById(R.id.rec_view_bodysize);
        System.out.println("onViewCreated"  );
        exerciseAdapter = new ExerciseAdapter(recyclerViewExercise,getContext(),getActivity().getSupportFragmentManager());
        bodySizeAdapter=new BodySizeAdapter(recyclerViewBodySize,getContext(),getActivity().getSupportFragmentManager());
        MainActivity.getUser().getBodySizeItemList().observe(getViewLifecycleOwner(), bodySizeAdapter);
        MainActivity.getUser().getExerciseItemList().observe(getViewLifecycleOwner(), exerciseAdapter);
        fotoAdapter=new FotoAdapter(recyclerViewFoto,getContext(),getActivity().getSupportFragmentManager());

        openFoodIntakeContainerFragment(getChildFragmentManager(),new FoodIntakeContainerFragment());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        System.out.println("onAttach"  );
        super.onAttach(context);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        System.out.println("onHiddenChanged" +hidden);

        super.onHiddenChanged(hidden);
    }

    @Override
    public void onResume() {
        System.out.println("onRESUME");
        super.onResume();
    }
}