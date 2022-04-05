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
import com.calorie.calc.databinding.ListFooterActivFullItemBinding;
import com.calorie.calc.databinding.ListHeaderActivItemBinding;
import com.calorie.calc.fragments.tracker.miniitem.exercise.ExerciseListFragment;
import com.calorie.calc.fragments.tracker.miniitem.exercise.ExerciseListWithToolbarFragment;

import java.util.List;

public class ExerciseAdapter extends ListAdapter<ExerciseItem> implements Observer<List<ExerciseItem>> {
    ListFooterActivFullItemBinding footerBinding;
    ListHeaderActivItemBinding headerBinding;
    public ExerciseAdapter(RecyclerView itemsList, Context context, FragmentManager fragmentManager) {
        super(itemsList, context,fragmentManager);
    }
     @Override
    public ViewBinding getListFooter()
     {
          footerBinding = ListFooterActivFullItemBinding.inflate(LayoutInflater.from(getContext()), itemsList, false);


         return footerBinding;

     }
    @Override
    public ViewBinding getListHeader()
    {
        headerBinding = ListHeaderActivItemBinding
                .inflate(LayoutInflater.from(getContext()), itemsList, false);
       setVisible(infoListAdapter.getItemCount()==0);



               View.OnClickListener onAddItemClick =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(fragmentManager,new ExerciseListFragment());
            }
        };

        headerBinding.imageViewAdd.setOnClickListener(onAddItemClick);
        headerBinding.textViewAdd.setOnClickListener(onAddItemClick);
        headerBinding.textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(fragmentManager,new ExerciseListWithToolbarFragment());
            }
        });
        return   headerBinding;

    }

    @Override
    public void setDataToList() {

        setVisible(true);
    }

    @Override
    public void onChanged(List<ExerciseItem> exerciseItems) {
        setVisible(exerciseItems.size()==0);
        infoListAdapter.setInfoItemList(exerciseItems);
        double energy=0;
        for(ExerciseItem item:exerciseItems)
        {
            energy=energy+item.getEnergy();

        }
        footerBinding.textViewCount.setText(String.valueOf(energy));

    }
    void setVisible(Boolean visible)
    {
        if(visible)
        {headerBinding.textViewAdd.setVisibility(View.VISIBLE);
            headerBinding.imageViewAdd.setVisibility(View.GONE);
            footerBinding.textViewCount.setVisibility(View.GONE);
        }
        else
        {headerBinding.textViewAdd.setVisibility(View.GONE);
            headerBinding.imageViewAdd.setVisibility(View.VISIBLE);
            footerBinding.textViewCount.setVisibility(View.VISIBLE);
        }

    }
}
