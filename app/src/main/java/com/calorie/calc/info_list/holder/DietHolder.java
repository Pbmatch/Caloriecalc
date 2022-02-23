package com.calorie.calc.info_list.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.DietType;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.utils.PicassoHelper;

public class DietHolder  extends InfoItemHolder<DietType>{
    public ImageView itemThumbnailView;
    public TextView itemTitleView;
    public  TextView itemKkalView;
    public DietHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_horizontal_item, parent);
    }


    DietHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        itemThumbnailView = itemView.findViewById(R.id.list_recipe_imageview);
        itemTitleView = itemView.findViewById(R.id.list_recipe_textViewTitle);
        itemKkalView = itemView.findViewById(R.id.list_recipe_textViewText);
    }

    @Override
    public void updateFromItem(DietType infoItem) {
        itemKkalView.setVisibility(View.GONE);


        itemTitleView.setText(itemBuilder.getContext().getString(infoItem.getTitleRes()));
        if(infoItem.getImageUrl()!=null)
            PicassoHelper.loadRecipe(infoItem.getImageUrl()) .fit()
                    .centerCrop().into(itemThumbnailView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemBuilder.getOnRecipeClickListener()!=null)
                    itemBuilder.getOnRecipeClickListener().selected(infoItem);
            }
        });
    }

    @Override
    public void updateState(DietType infoItem) {

    }
}
