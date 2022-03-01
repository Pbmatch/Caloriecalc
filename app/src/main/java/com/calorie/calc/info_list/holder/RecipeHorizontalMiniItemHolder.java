package com.calorie.calc.info_list.holder;

import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.utils.PicassoHelper;

public class RecipeHorizontalMiniItemHolder extends RecipeItemHolder {



    public RecipeHorizontalMiniItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_horizontal_item, parent);
    }
     RecipeHorizontalMiniItemHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);

    }

    @Override
    public void loadImage(String imageUrl) {
        PicassoHelper.loadRecipe(imageUrl) .fit()
                .centerCrop().into(itemThumbnailView);
    }
 /*   @Override
    void loadImage(String imageUrl)
    {

    }
    */


}