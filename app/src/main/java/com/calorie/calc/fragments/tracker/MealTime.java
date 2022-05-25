package com.calorie.calc.fragments.tracker;

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
            return item.getQuantity();
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



            for(Nutrient nutrient: getNutrientListForAllAddedMeals())
            {
                if(className.equals( nutrient.getClass()))
                {
                   return nutrient;
                }

            }

        return null;
    }
    public List<Nutrient> getNutrientListForAllAddedMeals()
    {
        List<Nutrient> nutrientList=new ArrayList<>();
        Map<Class< ? extends Nutrient>,Nutrient> map= getNutrientsMap(getRecipeAndLinksItems().getValue());
        for (Map.Entry<Class< ? extends Nutrient>,Nutrient> entry: map.entrySet())
        {
            nutrientList.add(entry.getValue());
        }
         return nutrientList;

    }

    public Map<Class< ? extends Nutrient>,Nutrient> getNutrientsMap(List<RecipeAndLinksItem> itemList)
    {
        Map<Class< ? extends Nutrient>,Nutrient> map= new HashMap<>();
        if (itemList!=null)
        for (RecipeAndLinksItem recipeAndLinksItem: itemList)
        {
            for(Nutrient nutrient: recipeAndLinksItem.getRecipe().getTotalNutrients().getNutrientList())
            {

                if(!map.containsKey(nutrient.getClass()))
                {
                    map.put(nutrient.getClass(),nutrient);

                }
                else
                {
                    double quant  = map.get(nutrient.getClass()).getQuantity();
                    map.get(nutrient.getClass()).setQuantity(quant+nutrient.getQuantity());

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
}
