package com.calorie.calc.fragments.tracker;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.holders.recipeholders.TotalNutrients;
import com.calorie.calc.utils.MutableList;
import com.calorie.calc.utils.OptionsUnit;

import java.util.List;

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
    public  Nutrient getDone(Nutrient item)
    {


      for (RecipeAndLinksItem recipeAndLinksItem: getRecipeAndLinksItems().getValue())
      {
         for(Nutrient nutrient: recipeAndLinksItem.getRecipe().getTotalNutrients().getNutrientList())
         {

           System.out.println(item.getClass());
             System.out.println(nutrient.getClass());
           if(item.getClass().equals( nutrient.getClass()))
             {
                 System.out.println("item.getClass().equals( nutrient.getClass()"+nutrient.getClass());
                 item.setQuantity(item.getQuantity()+nutrient.getQuantity());
             }

         }
      }
      return item;
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
