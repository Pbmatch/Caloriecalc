package com.calorie.calc.info_list.holder;

import static com.calorie.calc.utils.MeasureUtils.getEnergyString;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.calorie.calc.R;
import com.calorie.calc.edamam.holders.recipeholders.Recipe;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.utils.PicassoHelper;

public class RecipeItemHolder extends InfoItemHolder <RecipeAndLinks>{

    public ImageView itemThumbnailView;
    public TextView itemTitleView;
    public  TextView itemKkalView;

    public RecipeItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_item, parent);
    }
    RecipeItemHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        itemThumbnailView = itemView.findViewById(R.id.list_recipe_imageview);
        itemTitleView = itemView.findViewById(R.id.list_recipe_textViewTitle);
        itemKkalView = itemView.findViewById(R.id.list_recipe_textViewText);
    }

    @Override
    public void updateFromItem(RecipeAndLinks infoItem) {

        Recipe recipe = infoItem.getRecipe();
        itemKkalView.setText(
                getEnergyString(recipe.getCalories(),itemBuilder.getContext()));
        itemTitleView.setText(recipe.getLabel());
        if(recipe.getImage()!=null)
            PicassoHelper.loadRecipe(recipe.getImage()) .fit()
                    .centerCrop().into(itemThumbnailView);
    }

    @Override
    public void updateState(RecipeAndLinks infoItem) {

    }

}