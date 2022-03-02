package com.calorie.calc.info_list.holder;

import static com.calorie.calc.fragments.recipe.liked.FabHandler.fabClickState;
import static com.calorie.calc.fragments.recipe.liked.FabHandler.getFabState;

import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.utils.DisplaySize;
import com.calorie.calc.utils.PicassoHelper;

public class RecipeLikedItemHolder extends RecipeItemHolder {

    public RecipeLikedItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_item, parent);
    }
    RecipeLikedItemHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
    }

    @Override
    public void updateFromItem(RecipeAndLinks infoItem, int pos) {
        super.updateFromItem(infoItem, pos);
        if(getFabState(infoItem))
        {
            button.setImageDrawable(itemBuilder.getContext().getDrawable(R.drawable.favorite));
            infoItem.setLiked(true);
        }
        else {
            button.setImageDrawable(itemBuilder.getContext().getDrawable(R.drawable.favoriteblank));  infoItem.setLiked(false);}
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabClickState(infoItem,itemBuilder.getContext(),button);
            }
        });
    }


    @Override
    public void loadImage(String imageUrl)
    {
        ViewGroup.LayoutParams params = itemThumbnailView.getLayoutParams();

        params.height = (int) (DisplaySize.getHEIGHT()/3);
        itemThumbnailView.setLayoutParams(params);
        PicassoHelper.loadRecipe(imageUrl) .fit()
                .centerCrop() .into(itemThumbnailView);
    }

}