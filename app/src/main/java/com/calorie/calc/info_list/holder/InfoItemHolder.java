package com.calorie.calc.info_list.holder;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoItemBuilder;

public abstract class InfoItemHolder extends RecyclerView.ViewHolder {
    protected final InfoItemBuilder itemBuilder;

    public InfoItemHolder(final InfoItemBuilder infoItemBuilder, final int layoutId,
                          final ViewGroup parent) {
        super(LayoutInflater.from(infoItemBuilder.getContext()).inflate(layoutId, parent, false));
        this.itemBuilder = infoItemBuilder;

    }
    public abstract void updateFromItem(RecipeAndLinks infoItem
                                        );

    public abstract void updateState(final RecipeAndLinks infoItem);
}
