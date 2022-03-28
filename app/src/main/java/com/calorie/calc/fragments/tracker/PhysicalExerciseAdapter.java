package com.calorie.calc.fragments.tracker;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.databinding.ListHeaderActivItemBinding;
import com.calorie.calc.fragments.recipe.holders.PhysicalExerciseItem;

public class PhysicalExerciseAdapter  extends ListAdapter<PhysicalExerciseItem>{


    public PhysicalExerciseAdapter(RecyclerView itemsList, Context context) {
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
        return   ListHeaderActivItemBinding
            .inflate(LayoutInflater.from(getContext()), itemsList, false);
    }

}
