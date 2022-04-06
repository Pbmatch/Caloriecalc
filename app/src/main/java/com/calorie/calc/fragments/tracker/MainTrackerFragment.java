package com.calorie.calc.fragments.tracker;

import static com.calorie.calc.NavigationHelper.openFoodIntakeContainerFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.MainActivity;
import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.data.NoteItem;


public class MainTrackerFragment extends Fragment {

   RecyclerView recyclerViewExercise;
    RecyclerView recyclerViewBodySize;
    RecyclerView recyclerViewFoto;
    ConstraintLayout csl_note;

   ExerciseAdapter exerciseAdapter;
   BodySizeAdapter bodySizeAdapter;
    FotoAdapter fotoAdapter;
    TextView textViewNote;

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
        textViewNote=view.findViewById(R.id.textView_note_text);
        csl_note =view.findViewById(R.id.csl_note);
        System.out.println("onViewCreated"  );
        exerciseAdapter = new ExerciseAdapter(recyclerViewExercise,getContext(),getActivity().getSupportFragmentManager());
        bodySizeAdapter=new BodySizeAdapter(recyclerViewBodySize,getContext(),getActivity().getSupportFragmentManager());
        MainActivity.getUser().getWeightItem().observe(getViewLifecycleOwner(), bodySizeAdapter.getWeightObserver());
        MainActivity.getUser().getBodySizeItemList().observe(getViewLifecycleOwner(), bodySizeAdapter);
        MainActivity.getUser().getExerciseItemList().observe(getViewLifecycleOwner(), exerciseAdapter);
        fotoAdapter=new FotoAdapter(recyclerViewFoto,getContext(),getActivity().getSupportFragmentManager());

        openFoodIntakeContainerFragment(getChildFragmentManager(),new FoodIntakeContainerFragment());

        note();
    }
    void note()
    {
        csl_note.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new NoteFragment());

        }
    });
        MainActivity.getUser().getNoteItem().observe(getViewLifecycleOwner(), new Observer<NoteItem>() {
            @Override
            public void onChanged(NoteItem noteItem) {
                if(noteItem.getText().isEmpty())
                {
                    textViewNote.setText(getString(R.string.add_to_note));
                    textViewNote.setTextColor(getContext().getColor(R.color.button_green));
                }
                else
                {
                    textViewNote.setText(noteItem.getText());
                    textViewNote.setTextColor(getContext().getColor(R.color.filter_gray));
                }
            }
        });

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