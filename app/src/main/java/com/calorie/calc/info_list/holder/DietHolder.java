package com.calorie.calc.info_list.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.diet.DietMainPageType;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;
import com.calorie.calc.utils.PicassoHelper;

public class DietHolder  extends InfoItemHolder<DietMainPageType> {
    private ImageView itemThumbnailView;
    private TextView itemTitleView;
    private  TextView itemKkalView;
    private ImageView imageViewCheck;
    private ImageView imageViewTransparent;

    public DietHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_horizontal_item, parent);
    }


    DietHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        itemThumbnailView = itemView.findViewById(R.id.list_recipe_imageview);
        itemTitleView = itemView.findViewById(R.id.list_recipe_textViewTitle);
        itemKkalView = itemView.findViewById(R.id.list_recipe_textViewText);
        imageViewCheck= itemView.findViewById(R.id.list_recipe_check);
        imageViewTransparent= itemView.findViewById(R.id.list_recipe_transparent);
    }

    @Override
    public void updateFromItem(DietMainPageType infoItem, int pos) {
        itemKkalView.setVisibility(View.GONE);
        if(infoItem.isSelect())
        { imageViewCheck.setVisibility(View.VISIBLE);
        imageViewTransparent.setVisibility(View.VISIBLE);}
        else
        { imageViewCheck.setVisibility(View.GONE);
            imageViewTransparent.setVisibility(View.GONE);}



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
    public void updateState(DietMainPageType infoItem) {

    }
}
