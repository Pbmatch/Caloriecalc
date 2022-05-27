package com.calorie.calc.fragments.recipe.scrolling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.AdapterMealTime;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.tracker.MealTime;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.RecipeInverter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InnerAddFragment extends Fragment implements BackPressable {

    MealTime itemSelected;
    AdapterMealTime.MeasureEnum measureEnumItemSelected;
    RecipeAndLinksItem recipeAndLinksItem;
    TextInputEditText editTextPorionsNumber;

    public InnerAddFragment(RecipeAndLinksItem recipeAndLinksItem) {
        this.recipeAndLinksItem = recipeAndLinksItem;
    }

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
        editTextPorionsNumber = view.findViewById(R.id.editTextNumberPortion);

        List<String> list = new ArrayList<>();
        list.add("Порция");
        list.add("Грамм");

      /*  List<String> listMeal = new ArrayList<>();
        listMeal.add("Завтрак");
        listMeal.add("Обед");
        listMeal.add("Ужин");
        listMeal.add("Перекус");*/

        List<MealTime> listMeal22 = Arrays.asList(MealTime.values());

       //todo сделать провреку на вес, если веса в айтеме нет, то и не показывать

        ArrayAdapter<AdapterMealTime.MeasureEnum> adapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item,
                AdapterMealTime.MeasureEnum.values());

        if(recipeAndLinksItem.getRecipe().getTotalWeight()==0)
        {
            adapter.remove( AdapterMealTime.MeasureEnum.Gram);
        }


        AutoCompleteTextView editTextFilledExposedDropdown =
                view.findViewById(R.id.editTextSpinnerPortion);
        editTextFilledExposedDropdown.setAdapter(adapter);

        ArrayAdapter<MealTime> adapterMeal = new ArrayAdapter<MealTime>(
                getContext(),
                R.layout.dropdown_menu_popup_item,
               MealTime.values());

        AutoCompleteTextView editTextFilledExposedDropdownMeal =
                view.findViewById(R.id.editTextSpinnerMealtime);
        editTextFilledExposedDropdownMeal.setAdapter(adapterMeal);
        editTextFilledExposedDropdownMeal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               /* System.out.println("itemSelected.onItemSelected"+position);
                itemSelected=(MealTime) parent.getSelectedItem();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        editTextFilledExposedDropdownMeal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                itemSelected=adapterMeal.getItem(position);
            }
        });
        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                measureEnumItemSelected=adapter.getItem(position);
            }
        });



        view.findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo изменить относительно порции или грамов до того как отправить далее
                  if(editTextPorionsNumber.getText().toString().isEmpty())
                  {
                      Toast.makeText(getContext(),"Укажите кол-во порций ",Toast.LENGTH_LONG).show();
                      return;
                  }
                  if (itemSelected==null)
                  {
                      Toast.makeText(getContext(),"Выберите время приёма пищи",Toast.LENGTH_LONG).show();
                      return;
                  }
                  double calories=0;
               double portion=1;
                  String measureString="";
                  if(measureEnumItemSelected.equals(AdapterMealTime.MeasureEnum.Gram))
                  {
                     /* portion=Double.parseDouble(editTextPorionsNumber.getText().toString())/
                              recipeAndLinksItem.getRecipe().getTotalWeight()/
                              recipeAndLinksItem.getRecipe().getYield();*/
                      portion =Double.parseDouble(editTextPorionsNumber.getText().toString())/
                              (recipeAndLinksItem.getRecipe().getTotalWeight()/ recipeAndLinksItem.getRecipe().getYield());

                  }
                  else {

                      portion=Integer.parseInt(editTextPorionsNumber.getText().toString());

                  }
                measureString = editTextPorionsNumber.getText().toString()+" "+measureEnumItemSelected.getTitle();

                RecipeInverter.invertToMealTime(recipeAndLinksItem,portion);
                System.out.println("(measureEnumItemSelected.equals(AdapterMealTime.MeasureEnum.Gram) getTotalWeight" + recipeAndLinksItem.getRecipe().getTotalWeight());
                System.out.println("(measureEnumItemSelected.equals(AdapterMealTime.MeasureEnum.Gram) getCalories" + recipeAndLinksItem.getRecipe().getCalories());
                System.out.println("(measureEnumItemSelected.equals(AdapterMealTime.MeasureEnum.Gram) getYield" + recipeAndLinksItem.getRecipe().getYield());
                System.out.println("(measureEnumItemSelected.equals(AdapterMealTime.MeasureEnum.Gram) portion" + portion);
                calories=(recipeAndLinksItem.getRecipe().getCalories()/recipeAndLinksItem.getRecipe().getYield());
                calories=calories*portion;
                System.out.println("(measureEnumItemSelected.equals(AdapterMealTime.MeasureEnum.Gram) calories" + calories);
                  recipeAndLinksItem.setAdapterMealTime(new AdapterMealTime()
                          .setYield(portion)
                          .setMeasureString(measureString)
                          .setCalories(calories)

                  );

                itemSelected.getRecipeAndLinksItems().additem(recipeAndLinksItem);

                Toast.makeText(getContext(),"Добавлено в "+itemSelected.getTitle(),Toast.LENGTH_LONG).show();
                getParentFragmentManager().popBackStack();



            }
        });
    }

    @Override
    public boolean onBackPressed() {

        getParentFragmentManager().popBackStack();
        return false;
    }
}