package com.calorie.calc.fragments.tracker;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.databinding.ListHeaderBodysizeItemBinding;
import com.calorie.calc.fragments.recipe.holders.BodySizeItem;

public class BodySizeAdapter  extends ListAdapter<BodySizeItem>{


    public BodySizeAdapter(RecyclerView itemsList, Context context) {
        super(itemsList, context);
    }
    @Override
    public ViewBinding getListFooter()
    {

        return null;
    }
    @Override
    public ViewBinding getListHeader()
    {
        return   ListHeaderBodysizeItemBinding
                .inflate(LayoutInflater.from(getContext()), itemsList, false);
    }

}
