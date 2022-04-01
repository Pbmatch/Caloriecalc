package com.calorie.calc.fragments.tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.databinding.ListHeaderBodysizeItemBinding;
import com.calorie.calc.fragments.tracker.miniitem.bodysize.BodyListFragment;

import java.util.List;

public class BodySizeAdapter  extends ListAdapter<BodySizeItem> implements Observer<List<BodySizeItem>> {


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
        binding.textViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return   binding;
    }

    @Override
    public void setDataToList() {

    }

    @Override
    public void onChanged(List<BodySizeItem> bodySizeItems) {
        System.out.println("void onChanged"+bodySizeItems.size());
        infoListAdapter.setInfoItemList(bodySizeItems);
    }
}
