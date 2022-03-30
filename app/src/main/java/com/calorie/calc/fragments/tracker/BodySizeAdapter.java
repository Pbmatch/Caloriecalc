package com.calorie.calc.fragments.tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.databinding.ListHeaderBodysizeItemBinding;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.fragments.tracker.bodysize.BodyListFragment;

public class BodySizeAdapter  extends ListAdapter<BodySizeItem>{


    public BodySizeAdapter(RecyclerView itemsList, Context context, FragmentManager fragmentManager) {
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
        ListHeaderBodysizeItemBinding binding = ListHeaderBodysizeItemBinding
                .inflate(LayoutInflater.from(getContext()), itemsList, false);
        binding.button.setVisibility(View.GONE); //TODO PREMIUM
        binding.imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(fragmentManager,new BodyListFragment());
            }
        });

        return   binding;
    }

    @Override
    public void setDataToList() {

    }

}
