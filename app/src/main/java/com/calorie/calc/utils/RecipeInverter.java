package com.calorie.calc.utils;

import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;

public class RecipeInverter {
    public static RecipeAndLinks invert(RecipeAndLinks  item)
    {

          double portionCount = item.getRecipe().getYield();
          for(Nutrient nutrient:item.getRecipe().getTotalNutrients().getNutrientList())
          {
              if(nutrient!=null)
              nutrient.setPortion(portionCount);

          }

         for(Nutrient nutrient:item.getRecipe().getTotalDaily().getNutrientList())
        {
            if(nutrient!=null)
            nutrient.setPortion(portionCount);

        }


      return item;
    }
}
