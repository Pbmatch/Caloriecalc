package com.calorie.calc.fragments.tracker;

import static com.calorie.calc.NavigationHelper.openFoodIntakeContainerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.R;


public class MainTrackerFragment extends Fragment {

   RecyclerView recyclerViewExercise;
    RecyclerView recyclerViewBodySize;
    RecyclerView recyclerViewFoto;

   PhysicalExerciseAdapter physicalExerciseAdapter;
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

        physicalExerciseAdapter = new PhysicalExerciseAdapter(recyclerViewExercise,getContext(),getActivity().getSupportFragmentManager());
        bodySizeAdapter=new BodySizeAdapter(recyclerViewBodySize,getContext(),getActivity().getSupportFragmentManager());
        fotoAdapter=new FotoAdapter(recyclerViewFoto,getContext(),getActivity().getSupportFragmentManager());

        openFoodIntakeContainerFragment(getChildFragmentManager(),new FoodIntakeContainerFragment());
    }
}