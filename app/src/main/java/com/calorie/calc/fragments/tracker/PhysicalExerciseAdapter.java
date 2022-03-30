package com.calorie.calc.fragments.tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.databinding.ListHeaderActivItemBinding;

public class PhysicalExerciseAdapter  extends ListAdapter<ExerciseItem>{


    public PhysicalExerciseAdapter(RecyclerView itemsList, Context context, FragmentManager fragmentManager) {
        super(itemsList, context,fragmentManager);
    }
     @Override
    public ViewBinding getListFooter()
     {

         return null;
     }
    @Override
    public ViewBinding getListHeader()
    {
        ListHeaderActivItemBinding headerBinding = ListHeaderActivItemBinding
                .inflate(LayoutInflater.from(getContext()), itemsList, false);
       if(infoListAdapter.getItemCount()==0)
       {headerBinding.textViewAdd.setVisibility(View.VISIBLE);
           headerBinding.imageViewAdd.setVisibility(View.GONE);
       }
       else
       {headerBinding.textViewAdd.setVisibility(View.GONE);
           headerBinding.imageViewAdd.setVisibility(View.VISIBLE);
       }

        return   headerBinding;
    }

    @Override
    public void setDataToList() {

    }

}
