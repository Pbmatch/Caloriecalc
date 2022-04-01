package com.calorie.calc.fragments.tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.databinding.ListHeaderActivItemBinding;
import com.calorie.calc.fragments.tracker.miniitem.exercise.ExerciseListFragment;

import java.util.List;

public class PhysicalExerciseAdapter  extends ListAdapter<ExerciseItem> implements Observer<List<ExerciseItem>> {

    ListHeaderActivItemBinding headerBinding;
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
        headerBinding = ListHeaderActivItemBinding
                .inflate(LayoutInflater.from(getContext()), itemsList, false);
       setVisible(infoListAdapter.getItemCount()==0);

        headerBinding.textViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(fragmentManager,new ExerciseListFragment());
            }
        });
        return   headerBinding;
    }

    @Override
    public void setDataToList() {

    }

    @Override
    public void onChanged(List<ExerciseItem> exerciseItems) {
        setVisible(exerciseItems.size()==0);
        infoListAdapter.setInfoItemList(exerciseItems);
    }
    void setVisible(Boolean visible)
    {
        if(visible)
        {headerBinding.textViewAdd.setVisibility(View.VISIBLE);
            headerBinding.imageViewAdd.setVisibility(View.GONE);
        }
        else
        {headerBinding.textViewAdd.setVisibility(View.GONE);
            headerBinding.imageViewAdd.setVisibility(View.VISIBLE);
        }

    }
}
