package com.calorie.calc.fragments.tracker;

import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.TotalNutrients;
import com.calorie.calc.utils.OptionsUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public TotalNutrients.EnercKcal getFullEnercKcal() {
       return (TotalNutrients.EnercKcal) OptionsUnit.createDefaultNutrient("full",new OptionsUnit.NormallyEnergyHolder());

    }
    public TotalNutrients.Fat getFullPlanFat() {
        return    (TotalNutrients.Fat) OptionsUnit.createDefaultNutrient("full", new OptionsUnit.NormallyFatHolder());
    }
    public TotalNutrients.Chocdf getFullPlanChocdf() {
        return      (TotalNutrients.Chocdf) OptionsUnit.createDefaultNutrient("full",new OptionsUnit.NormallyCarbHolder());
    }
    public TotalNutrients.Procnt getFullPlanProcnt() {
        return     (TotalNutrients.Procnt) OptionsUnit.createDefaultNutrient("full",new OptionsUnit.NormallyProteinHolder());
    }


    public double getTotalDay(FunctionalInterface choseMethod ) {
        double value=0;
        for(MealTime mealTime:MealTime.values())
       {
           value=value+choseMethod.getDouble(mealTime);
       }


        return value;
    }
    public interface FunctionalInterface
    {
        double getDouble(MealTime mealTime);

    }

    public List<Nutrient> getNutrientListForMealTimes(boolean isGram)
    {
        List<Nutrient> nutrientList=new ArrayList<>();
        Map<Class< ? extends Nutrient>,Nutrient> map;
        map= getNutrientsMap(isGram);
        for (Map.Entry<Class< ? extends Nutrient>,Nutrient> entry: map.entrySet())
        {
            nutrientList.add(entry.getValue());
        }
        return nutrientList;

    }


    private Map<Class< ? extends Nutrient>,Nutrient> getNutrientsMap( boolean gramm)
    {
        Map<Class< ? extends Nutrient>,Nutrient> map= new HashMap<>();
        for(MealTime mealTime:MealTime.values()) {
            List<Nutrient> itemList = mealTime.getNutrientListForAllAddedMeals(gramm);


                for (Nutrient nutrient : itemList)


                {
                    if (nutrient != null) {
                        if (!map.containsKey(nutrient.getClass())) {
                            Nutrient clone = nutrient.clone();

                            clone.setSummQuantity(nutrient.getQuantity());
                            map.put(clone.getClass(), clone);


                        } else {

                            double quant = map.get(nutrient.getClass()).getSummQuantity();

                            map.get(nutrient.getClass()).setSummQuantity(quant + nutrient.getQuantity());

                        }


                    }
                }
        }
        return map;

    }


}
