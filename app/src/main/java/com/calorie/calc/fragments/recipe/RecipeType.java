package com.calorie.calc.fragments.recipe;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.diet.DietType;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum RecipeType {
    DIET_PLAN(R.string.recipe_1, "", R.id.container_plan),
    POPULAR_RECIPE(R.string.recipe_2, "", R.id.container_popular),
    ADDED_RECIPE(R.string.recipe_3, "", R.id.container_added),
    BREAKFAST(R.string.recipe_4, "Breakfast", R.id.container_breakfast),
    DINNER(R.string.recipe_5, "Dinner", R.id.container_dinner),
    SNACKS(R.string.recipe_6, "Snack", R.id.container_snack);


    private String mealType;
    private int titleRecource;
    private int container;
    private DietType dietType;
    MutableLiveData<List<RecipeAndLinks>> recipeState = new MutableLiveData<>();
    Map<String, String> params;

    RecipeType(int title, String mealType, int container) {
        this.titleRecource = title;
        this.mealType = mealType;
        this.container = container;

    }

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }

    public int getContainer() {
        return container;
    }

    public int getTitleRecource() {
        return titleRecource;
    }

    public Map<String, String> getParams() {


        return params;
    }
    public static void setDietPlanToAll(DietType dietType1)
    {
        for(RecipeType type:RecipeType.values())
            type.setDietType(dietType1);


        buildAll( );
    }
    public   void setDietPlanAndBuild(DietType dietType1)
    {

            setDietType(dietType1);
            build( );
    }
    public static void buildAll( )
    {
        for(RecipeType type:RecipeType.values())
            type.build();

    }

    private void build( ) {

        Map<String, String> param = new HashMap<>();
        param.putAll(dietType.getMap());
        param.put("type", "public");
        param.put("q", "");
        if (!mealType.isEmpty()&&!param.containsKey("mealType"))
            param.put("mealType", mealType);
        this.params = param;

    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public MutableLiveData<List<RecipeAndLinks>> getRecipeState() {
        return recipeState;
    }

    public void setRecipeState(MutableLiveData<List<RecipeAndLinks>> recipeState) {
        this.recipeState = recipeState;
    }
}