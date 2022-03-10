package com.calorie.calc.fragments.recipe.filter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.query.CuisineType;
import com.calorie.calc.fragments.recipe.query.DietType;
import com.calorie.calc.fragments.recipe.query.DishType;
import com.calorie.calc.fragments.recipe.query.EnergyType;
import com.calorie.calc.fragments.recipe.query.HealthType;
import com.calorie.calc.fragments.recipe.query.MealType;
import com.calorie.calc.fragments.recipe.query.QueryType;
import com.google.android.flexbox.FlexboxLayout;

import java.util.Arrays;
import java.util.List;

public class FilterFragment extends Fragment {

   private ImageView imageViewClose;
    private  TextView textViewClear;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

         FlexboxLayout flexHealth = view.findViewById(R.id.flex_box_HealthType);
        FlexboxLayout flexDiet = view.findViewById(R.id.flex_box_diet);
        FlexboxLayout flexMeal = view.findViewById(R.id.flex_box_meal);
        FlexboxLayout flexDish = view.findViewById(R.id.flex_box_Dishtype);
        FlexboxLayout flexCuisine = view.findViewById(R.id.flex_box_CuisineType);
        FlexboxLayout flexEnergy = view.findViewById(R.id.flex_box_EnergyType);
        imageViewClose= view.findViewById(R.id.imageViewBack);
        textViewClear= view.findViewById(R.id.textViewTextRight);

        setView(flexHealth,Arrays.asList(HealthType.values()));

        setView(flexDiet,Arrays.asList(DietType.values()));
        setView(flexMeal,Arrays.asList(MealType.values()));
        setView(flexDish,Arrays.asList(DishType.values()));
        setView(flexCuisine,Arrays.asList(CuisineType.values()));
        setView(flexEnergy,Arrays.asList(EnergyType.values()));
        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
        textViewClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryType.clearAll();
            }
        });


        return view;

    }
    void setView( FlexboxLayout view, List<QueryType> list) {
        for (QueryType type : list) {
            if (type.getButton(getContext()).getParent() != null) {
                ((ViewGroup) type.getButton(getContext()).getParent()).removeView(type.getButton(getContext())); // <- fix
            }
            view.addView(type.getButton(getContext()));


        }
    }
}

//Сделать интерфейс фильтра, как то совместить с диетами с главной?!
//сделать поиск и запрос и переключение на верт фрагмент
// сделать строку с кнопками фильтра под поиском
//убрать ошибку в логине и не точности по дизайну в рецептах
// обновление страницы и подгрузка доп контента