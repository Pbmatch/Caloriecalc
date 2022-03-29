package com.calorie.calc.info_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public abstract class InfoItemHolder<T> extends RecyclerView.ViewHolder {
    protected final InfoItemBuilder itemBuilder;

    public InfoItemHolder(final InfoItemBuilder infoItemBuilder, final int layoutId,
                          final ViewGroup parent) {
        super(LayoutInflater.from(infoItemBuilder.getContext()).inflate(layoutId, parent, false));
        this.itemBuilder = infoItemBuilder;

    }
    public abstract void updateFromItem(T infoItem
                                        , int position);

    public abstract void updateState(final T infoItem);
}
