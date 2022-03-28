package com.calorie.calc.fragments.recipe.holders.recipeholders;

import com.calorie.calc.fragments.recipe.holders.RecipeSearchItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecipeAndLinksItem implements Serializable {
    @SerializedName("recipe")
    @Expose
    private Recipe recipe;
    @SerializedName("_links")
    @Expose
    private RecipeSearchItem.Links links;
    private final static long serialVersionUID = 4169649893548118679L;


    boolean liked=false;

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public RecipeSearchItem.Links getLinks() {
        return links;
    }

    public void setLinks(RecipeSearchItem.Links links) {
        this.links = links;
    }
}
