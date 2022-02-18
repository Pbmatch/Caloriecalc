package com.calorie.calc.edamam.holders.recipeholders;

import com.calorie.calc.edamam.holders.RecipeSearch;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecipeHolder implements Serializable {
    @SerializedName("recipe")
    @Expose
    private Recipe recipe;
    @SerializedName("_links")
    @Expose
    private RecipeSearch.Links links;
    private final static long serialVersionUID = 4169649893548118679L;
}
