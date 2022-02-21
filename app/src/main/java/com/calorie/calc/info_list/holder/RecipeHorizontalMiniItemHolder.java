package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.calorie.calc.R;
import com.calorie.calc.edamam.holders.recipeholders.Recipe;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoItemBuilder;

public class RecipeHorizontalMiniItemHolder extends InfoItemHolder {

    public  ImageView itemThumbnailView;
    public  TextView itemTitleView;
    public  TextView itemKkalView;

    public RecipeHorizontalMiniItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_horizontal_item, parent);
    }
     RecipeHorizontalMiniItemHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
         itemThumbnailView = itemView.findViewById(R.id.rounded_user_image);
         itemTitleView = itemView.findViewById(R.id.textViewTitle);
         itemKkalView = itemView.findViewById(R.id.textViewText);
    }

    @Override
    public void updateFromItem(RecipeAndLinks infoItem) {

        Recipe recipe = infoItem.getRecipe();
        itemKkalView.setText(String.valueOf(recipe.getCalories()));
        itemTitleView.setText(recipe.getLabel());


    }

    @Override
    public void updateState(RecipeAndLinks infoItem) {

    }

}