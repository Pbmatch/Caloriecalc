package com.calorie.calc.fragments.tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.MainActivity;
import com.calorie.calc.NavigationHelper;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.databinding.ListHeaderBodysizeItemBinding;
import com.calorie.calc.fragments.tracker.miniitem.bodysize.BodyListFragment;
import com.calorie.calc.fragments.tracker.miniitem.bodysize.BodyUpdateFragment;
import com.calorie.calc.fragments.tracker.miniitem.bodysize.BodyWeightFragment;
import com.calorie.calc.utils.OnClickGesture;
import com.calorie.calc.utils.OptionsUnit;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BodySizeAdapter  extends ListAdapter<BodySizeItem> implements Observer<List<BodySizeItem>> {


    ListHeaderBodysizeItemBinding binding;
    public BodySizeAdapter(RecyclerView itemsList, Context context, FragmentManager fragmentManager) {
        super(itemsList, context,fragmentManager);
    }
    @Override
    public ViewBinding getListFooter()
    {

        return null;
    }
    public Observer<BodySizeItem> getWeightObserver()
    {
       return  new Observer<BodySizeItem>() {
            @Override
            public void onChanged(BodySizeItem bodySizeItem) {
                binding.textViewCount.setText(String.valueOf(bodySizeItem.getCountOfUnit()));
                binding.textViewMeasure.setText(OptionsUnit.getWeightItemUnit(getContext()));
                System.out.println("setDataToUser onChanged"+bodySizeItem.getCountOfUnit());
                Date dateNow = new Date();
                long days=0;
                if(bodySizeItem.getDate()!=null)
                { long diff = dateNow.getTime() - bodySizeItem.getDate().getTime();

                 days = TimeUnit.MILLISECONDS.toDays(diff);}
                binding.textViewDate.setText("Обновлено "+OptionsUnit.getWeightCount(getContext(),days)+" назад");
            }
        };
    }
    @Override
    public ViewBinding getListHeader()
    {


        binding = ListHeaderBodysizeItemBinding
                .inflate(LayoutInflater.from(getContext()), itemsList, false);
        binding.button.setVisibility(View.GONE); //TODO PREMIUM

       /* binding.textViewCount.setText(String.valueOf(MainActivity.getUser().getWeightItem().getValue().getCountOfUnit()));
        if(MainActivity.getUser().getWeightItem().getValue().getDate()==null)
            binding.textViewDate.setText("");
        else
        {binding.textViewDate.setText(MainActivity.getUser().getWeightItem().getValue().getDate().toString());}
*/

        binding.imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(fragmentManager,new BodyListFragment());
            }
        });
        binding.textViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(fragmentManager,new BodyWeightFragment(MainActivity.getUser().getWeightItem().getValue() ));
            }
        });
        return   binding;
    }

    @Override
    public void setDataToList() {
        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<BodySizeItem>() {
            @Override
            public void selected(BodySizeItem selectedItem) {
                NavigationHelper.openNavigationFragment(fragmentManager,new BodyUpdateFragment(selectedItem));
            }

            @Override
            public void held(BodySizeItem selectedItem) {
                NavigationHelper.openNavigationFragment(fragmentManager,new BodyUpdateFragment(selectedItem));
            }
        });
    }


    @Override
    public void onChanged(List<BodySizeItem> bodySizeItems) {

        infoListAdapter.setInfoItemList(bodySizeItems);
    }

}
