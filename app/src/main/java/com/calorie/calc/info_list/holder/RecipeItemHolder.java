package com.calorie.calc.info_list.holder;

import static com.calorie.calc.utils.MeasureUtils.getEnergyString;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.edamam.holders.recipeholders.Recipe;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class RecipeItemHolder extends InfoItemHolder <RecipeAndLinks>{

    protected ImageView itemThumbnailView;
    protected TextView itemTitleView;
    protected  TextView itemKkalView;
    protected FloatingActionButton button;
    private ConstraintLayout constraintLayout;

    public RecipeItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_item, parent);
    }
    RecipeItemHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        itemThumbnailView = itemView.findViewById(R.id.list_recipe_imageview);
        itemTitleView = itemView.findViewById(R.id.list_recipe_textViewTitle);
        itemKkalView = itemView.findViewById(R.id.list_recipe_textViewText);
        button=itemView.findViewById(R.id.floatingActionButton);
        constraintLayout=itemView.findViewById(R.id.csl);
    }

    @Override
    public void updateFromItem(RecipeAndLinks infoItem,int pos) {

        Recipe recipe = infoItem.getRecipe();
        itemKkalView.setText(
                getEnergyString(recipe.getCalories(),itemBuilder.getContext()));
        itemTitleView.setText(recipe.getLabel());
        if(recipe.getImage()!=null)
            loadImage(recipe.getImage());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemBuilder.getOnRecipeClickListener()!=null)
                    itemBuilder.getOnRecipeClickListener().selected(infoItem);
            }
        });

    }

   public abstract void loadImage(String imageUrl);


    @Override
    public void updateState(RecipeAndLinks infoItem) {

    }

}