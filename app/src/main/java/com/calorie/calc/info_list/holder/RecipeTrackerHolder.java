package com.calorie.calc.info_list.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Recipe;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;

public class RecipeTrackerHolder extends InfoItemHolder<RecipeAndLinksItem> {


protected TextView textViewTitle;
protected  TextView textViewText;
protected  TextView textViewCount;

public RecipeTrackerHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_recipe_tracker_item, parent);
        }
        RecipeTrackerHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
                textViewTitle = itemView.findViewById(R.id.textViewTitle);
                textViewText = itemView.findViewById(R.id.textViewText);
                textViewCount = itemView.findViewById(R.id.textViewCount);

        }

@Override
public void updateFromItem(RecipeAndLinksItem infoItem, int pos) {

        Recipe recipe = infoItem.getRecipe();
        textViewTitle.setText(recipe.getLabel());
        textViewCount.setText(String.valueOf(infoItem.getAdapterMealTime().getCalories()));
        textViewText.setText(String.valueOf(infoItem.getAdapterMealTime().getYield()));
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                        if(itemBuilder.getOnRecipeClickListener()!=null)
                                itemBuilder.getOnRecipeClickListener().held(infoItem);

                        return true;
                }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        if(itemBuilder.getOnRecipeClickListener()!=null)
        itemBuilder.getOnRecipeClickListener().selected(infoItem);
        }
        });

        }




@Override
public void updateState(RecipeAndLinksItem infoItem) {

        }

        }