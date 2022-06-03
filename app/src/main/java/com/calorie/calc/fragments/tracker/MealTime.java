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
            (TotalNutrients.EnercKcal)OptionsUnit.createDefaultNutrient( "BREAKFAST",new OptionsUnit.NormallyEnergyHolder()),
            (TotalNutrients.Fat) OptionsUnit.createDefaultNutrient("BREAKFAST",new OptionsUnit.NormallyFatHolder()),
            (TotalNutrients.Chocdf) OptionsUnit.createDefaultNutrient("BREAKFAST",new OptionsUnit.NormallyCarbHolder()),
            (TotalNutrients.Procnt) OptionsUnit.createDefaultNutrient("BREAKFAST",new OptionsUnit.NormallyProteinHolder())),

    LUNCH("Обед", R.drawable.lunchcolor,
            (TotalNutrients.EnercKcal)OptionsUnit.createDefaultNutrient( "LUNCH",new OptionsUnit.NormallyEnergyHolder()),
            (TotalNutrients.Fat) OptionsUnit.createDefaultNutrient("LUNCH",new OptionsUnit.NormallyFatHolder()),
            (TotalNutrients.Chocdf) OptionsUnit.createDefaultNutrient("LUNCH",new OptionsUnit.NormallyCarbHolder()),
            (TotalNutrients.Procnt) OptionsUnit.createDefaultNutrient("LUNCH",new OptionsUnit.NormallyProteinHolder())),


    DINNER("Ужин", R.drawable.dinnercolor,
            (TotalNutrients.EnercKcal)OptionsUnit.createDefaultNutrient( "DINNER",new OptionsUnit.NormallyEnergyHolder()),
            (TotalNutrients.Fat) OptionsUnit.createDefaultNutrient("DINNER",new OptionsUnit.NormallyFatHolder()),
            (TotalNutrients.Chocdf) OptionsUnit.createDefaultNutrient("DINNER",new OptionsUnit.NormallyCarbHolder()),
            (TotalNutrients.Procnt) OptionsUnit.createDefaultNutrient("DINNER",new OptionsUnit.NormallyProteinHolder())),

    SNACK("Перекус", R.drawable.bitecolor,
            (TotalNutrients.EnercKcal)OptionsUnit.createDefaultNutrient( "SNACK",new OptionsUnit.NormallyEnergyHolder()),
            (TotalNutrients.Fat) OptionsUnit.createDefaultNutrient("SNACK",new OptionsUnit.NormallyFatHolder()),
            (TotalNutrients.Chocdf) OptionsUnit.createDefaultNutrient("SNACK",new OptionsUnit.NormallyCarbHolder()),
            (TotalNutrients.Procnt) OptionsUnit.createDefaultNutrient("SNACK",new OptionsUnit.NormallyProteinHolder())),

    ;


    private final String title;
    private final int resourceImageView;

    public TotalNutrients.EnercKcal enercKcal;
    public TotalNutrients.Fat fat;
    public TotalNutrients.Chocdf chocdf;      //Carbohydrate
    public TotalNutrients.Procnt procnt;   //protein


    public TotalNutrients.EnercKcal getPlanEnercKcal() {
        return enercKcal;
    }

    public TotalNutrients.Fat getPlanFat() {
        return fat;
    }

    public TotalNutrients.Chocdf getPlanChocdf() {
        return chocdf;
    }

    public TotalNutrients.Procnt getPlanProcnt() {
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
            map= getNutrientsMap(getRecipeAndLinksItems().getValue(),(item)->{return item.getRecipe().getTotalNutrients().getNutrientListForMealTime(); });
        }
        else
        {
            map= getNutrientsMap(getRecipeAndLinksItems().getValue(),(item)->{return item.getRecipe().getTotalDaily().getNutrientListForMealTime(); });
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



                   } else {

                       double quant = map.get(nutrient.getClass()).getSummQuantity();

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
   public interface FuncInterf
    {
        List<Nutrient> getNutrients(RecipeAndLinksItem item);

    }

}
