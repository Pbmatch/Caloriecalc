package com.calorie.calc.fragments.tracker;

import android.util.Log;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.holders.recipeholders.TotalNutrients;
import com.calorie.calc.utils.MutableList;
import com.calorie.calc.utils.OptionsUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MealTime {
    BREAKFAST("Завтрак", R.drawable.breakfastcolor,
            OptionsUnit.getEnergy( "BREAKFAST"),
            OptionsUnit.getFat("BREAKFAST"),
            OptionsUnit.getCarb("BREAKFAST"),
            OptionsUnit.getProtein("BREAKFAST")),

    LUNCH("Обед", R.drawable.lunchcolor,
            OptionsUnit.getEnergy( "LUNCH"),
            OptionsUnit.getFat("LUNCH"),
            OptionsUnit.getCarb("LUNCH"),
            OptionsUnit.getProtein("LUNCH")),



    DINNER("Ужин", R.drawable.dinnercolor,
            OptionsUnit.getEnergy( "DINNER"),
            OptionsUnit.getFat("DINNER"),
            OptionsUnit.getCarb("DINNER"),
            OptionsUnit.getProtein("DINNER")),

    SNACK("Перекус", R.drawable.bitecolor,
            OptionsUnit.getEnergy( "SNACK"),
            OptionsUnit.getFat("SNACK"),
            OptionsUnit.getCarb("SNACK"),
            OptionsUnit.getProtein("SNACK"));

    private final String title;
    private final int resourceImageView;

    public TotalNutrients.EnercKcal enercKcal;
    public TotalNutrients.Fat fat;
    public TotalNutrients.Chocdf chocdf;      //Carbohydrate
    public TotalNutrients.Procnt procnt;   //protein


    public TotalNutrients.EnercKcal getEnercKcal() {
        return enercKcal;
    }

    public TotalNutrients.Fat getFat() {
        return fat;
    }

    public TotalNutrients.Chocdf getChocdf() {
        return chocdf;
    }

    public TotalNutrients.Procnt getProcnt() {
        return procnt;
    }
    private   double getDone(Nutrient item)
    {

        if(item==null)
        {
            return 0;
        }
        else
        {
            Log.d("TAG","getNutrientsMap item Label" + item.getLabel());
            Log.d("TAG","getNutrientsMap item getQuantity" + item.getQuantity());
            Log.d("TAG","getNutrientsMap item getSummQuantity" + item.getSummQuantity());
            return item.getSummQuantity();
        }


    }
    public double getTotalFat()
    {
      return  getDone(getDoneNutrient(TotalNutrients.Fat.class));

    }
    public double getTotalProcNt()
    {
        return   getDone(getDoneNutrient(TotalNutrients.Procnt.class));

    }
    public double getTotalChockDf()
    {
        return   getDone(getDoneNutrient(TotalNutrients.Chocdf.class));

    }
    public double getTotalEnergy()
    {
        return   getDone(getDoneNutrient(TotalNutrients.EnercKcal.class));

    }
    private   Nutrient getDoneNutrient(Class< ? extends Nutrient> className)
    {



            for(Nutrient nutrient: getNutrientListForAllAddedMeals(true))
            {
                if(className.equals( nutrient.getClass()))
                {
                   return nutrient;
                }

            }

        return null;
    }
    public List<Nutrient> getNutrientListForAllAddedMeals(boolean isGram)
    {
        List<Nutrient> nutrientList=new ArrayList<>();
        Map<Class< ? extends Nutrient>,Nutrient> map;
        if(isGram)
        {
            map= getNutrientsMap(getRecipeAndLinksItems().getValue(),(item)->{return item.getRecipe().getTotalNutrients().getNutrientList(); });
        }
        else
        {
            map= getNutrientsMap(getRecipeAndLinksItems().getValue(),(item)->{return item.getRecipe().getTotalDaily().getNutrientList(); });
        }



        for (Map.Entry<Class< ? extends Nutrient>,Nutrient> entry: map.entrySet())
        {
            nutrientList.add(entry.getValue());
        }
         return nutrientList;

    }


    public Map<Class< ? extends Nutrient>,Nutrient> getNutrientsMap(List<RecipeAndLinksItem> itemList, FuncInterf interf)
    {
        Map<Class< ? extends Nutrient>,Nutrient> map= new HashMap<>();
        if (itemList!=null)
        for (RecipeAndLinksItem recipeAndLinksItem: itemList)
        {
            for(Nutrient nutrient: interf.getNutrients(recipeAndLinksItem))
                   // recipeAndLinksItem.getRecipe().getTotalNutrients().getNutrientList())

            {
               if(nutrient!=null) {
                   if (!map.containsKey(nutrient.getClass())) {
                       nutrient.setSummQuantity(nutrient.getQuantity());
                       map.put(nutrient.getClass(), nutrient);
                       Log.d("TAG", "getNutrientsMap quant Label" + nutrient.getLabel());
                       Log.d("TAG", "getNutrientsMap quant getQuantity" + nutrient.getQuantity());
                       Log.d("TAG", "getNutrientsMap quant getSummQuantity" + nutrient.getSummQuantity());


                   } else {

                       double quant = map.get(nutrient.getClass()).getSummQuantity();
                       Log.d("TAG", "getNutrientsMap quant" + quant);
                       Log.d("TAG", "getNutrientsMap nutrient.getQuantity()" + nutrient.getQuantity());
                       map.get(nutrient.getClass()).setSummQuantity(quant + nutrient.getQuantity());
                       //     Log.d("TAG","getNutrientsMap getSummQuantity" + map.get(nutrient.getClass()).getSummQuantity());

                   }


               }
            }
        }
        return map;

    }

    MutableList<List<RecipeAndLinksItem>,RecipeAndLinksItem> recipeAndLinksItems = new MutableList<>();

    public MutableList<List<RecipeAndLinksItem>, RecipeAndLinksItem> getRecipeAndLinksItems() {

        return recipeAndLinksItems;
    }

    MealTime(String title, int resourceImageView, TotalNutrients.EnercKcal enercKcal, TotalNutrients.Fat fat, TotalNutrients.Chocdf chocdf, TotalNutrients.Procnt procnt) {
        this.title = title;
        this.resourceImageView = resourceImageView;
        this.enercKcal = enercKcal;
        this.fat = fat;
        this.chocdf = chocdf;
        this.procnt = procnt;
    }

    public String getTitle() {
        return title;
    }

    public int getResourceImageView() {
        return resourceImageView;
    }
    interface FuncInterf
    {
        List<Nutrient> getNutrients(RecipeAndLinksItem item);

    }

}
