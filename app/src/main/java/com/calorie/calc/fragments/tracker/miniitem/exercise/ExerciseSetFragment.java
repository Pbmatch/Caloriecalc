package com.calorie.calc.fragments.tracker.miniitem.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.fragments.tracker.miniitem.MiniItemSetFragment;


public class ExerciseSetFragment extends MiniItemSetFragment<ExerciseItem> {

   private TextView textView;
    public ExerciseSetFragment(ExerciseItem selectedItem) {
        super(selectedItem);
    }

    @Override
   public String getTextForButton()
    {
        return   getString(R.string.add_button);
    }
    @Override
    public void setDataToUser()
    {
        selectedItem.setTimeMins(Integer.parseInt(editText.getText().toString()));
        MainActivity.getUser().getExerciseItemList().additem(selectedItem);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.textViewText);
        textView.setText(String.valueOf(selectedItem.getEnergy())+getString(R.string.kkal));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_exercise_set, container, false);
    }
    @Override
    public void onClick(View v) {

        setDataToUser();
        getParentFragmentManager().popBackStack();
    }
}