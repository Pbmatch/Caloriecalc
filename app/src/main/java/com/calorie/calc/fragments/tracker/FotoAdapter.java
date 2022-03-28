package com.calorie.calc.fragments.tracker;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.databinding.ListFooterFotoBinding;
import com.calorie.calc.fragments.recipe.holders.FotoItem;

public class FotoAdapter extends ListAdapter<FotoItem>{




    public FotoAdapter(RecyclerView itemsList, Context context) {
        super(itemsList, context);
    }

    @Override
    public ViewBinding getListFooter()
    {

        return ListFooterFotoBinding.inflate(LayoutInflater.from(getContext()), itemsList, false);
    }
    @Override
    public ViewBinding getListHeader()
    {
        return   null;
    }
    @Override
    @RecyclerView.Orientation
    int getLayoutManagerOrientation()
    {
        return LinearLayoutManager.HORIZONTAL;
    }

}
