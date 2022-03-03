package com.calorie.calc.fragments.recipe.scrolling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.utils.BackPressable;

import java.util.ArrayList;
import java.util.List;


public class InnerAddFragment extends Fragment implements BackPressable {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inner_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);

    }

    void initView(View view)
    {
        List<String> list = new ArrayList<>();
        list.add("Порция");
        list.add("Грамм");

        List<String> listMeal = new ArrayList<>();
        listMeal.add("Завтрак");
        listMeal.add("Обед");
        listMeal.add("Ужин");
        listMeal.add("Перекус");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item,
                list);


        AutoCompleteTextView editTextFilledExposedDropdown =
                view.findViewById(R.id.editTextSpinnerPortion);
        editTextFilledExposedDropdown.setAdapter(adapter);

        ArrayAdapter<String> adapterMeal = new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_menu_popup_item,
                listMeal);
        AutoCompleteTextView editTextFilledExposedDropdownMeal =
                view.findViewById(R.id.editTextSpinnerMealtime);
        editTextFilledExposedDropdownMeal.setAdapter(adapterMeal);

        view.findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Добавлено",Toast.LENGTH_LONG).show();
                getParentFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        System.out.println("onBackPressed"+"InnerAddFragment");
        getParentFragmentManager().popBackStack();
        return false;
    }
}