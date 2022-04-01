package com.calorie.calc.fragments.tracker.miniitem.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.fragments.tracker.miniitem.MiniItemCreateFragment;
import com.calorie.calc.utils.OptionsUnit;

import java.util.Date;


public class ExerciseCreateFragment extends MiniItemCreateFragment {



   EditText editTextTime;
   TextView textViewText;

    public ExerciseCreateFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public String getUnitText() {
       return OptionsUnit.getExerciseItemEnergyUnit(getContext());
    }

    @Override
    public boolean checkButtonEnable() {

        if(editText.getText().toString().length()==0)
            textViewText.setText("0" +" " +getUnitText());
        else
        {
            textViewText.setText(editText.getText().toString()+" " +getUnitText());
        }

        return editText.getText().toString().length() > 0
                && !editText.getText().toString().equals("0")
                && editTextName.getText().toString().length() > 0
               && editTextTime.getText().toString().length() > 0;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.exercise_test, container, false);
    }

    @Override
    public void onClick(View v) {
        ExerciseItem selectedItem = new ExerciseItem(editTextName.getText().toString(),
                R.drawable.othersport, R.drawable.othersportbig);
        selectedItem.setDate(new Date());
        selectedItem.setTimeMins(Integer.parseInt(editTextTime.getText().toString()));
        selectedItem.setEnergy(Double.parseDouble(editText.getText().toString()));
        MainActivity.getUser().getExerciseItemList().getValue().add(selectedItem);
        getParentFragmentManager().popBackStack();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextTime = view.findViewById(R.id.editTextTime);
        textViewText= view.findViewById(R.id.textViewText);
        editTextTime.addTextChangedListener(textWatcher);

    }
}