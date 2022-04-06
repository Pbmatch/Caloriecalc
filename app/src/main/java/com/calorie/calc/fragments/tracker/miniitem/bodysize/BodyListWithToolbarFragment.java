package com.calorie.calc.fragments.tracker.miniitem.bodysize;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.MainActivity;
import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.databinding.ListHeaderBodysizeItemBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;
import com.calorie.calc.utils.OptionsUnit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BodyListWithToolbarFragment extends ListFragment<BodySizeItem> implements Observer<List<BodySizeItem>>, BackPressable {

    Button button;
    TextView textViewToolbarTitle;
    TextView textViewToolbarText;
    ImageView imageviewToolbarBack;
    ListHeaderBodysizeItemBinding    binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracer_list, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {


        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void startLoadData() {

         Observer<BodySizeItem> weightObserver =
        new Observer<BodySizeItem>() {
                @Override
                public void onChanged(BodySizeItem bodySizeItem) {
                    binding.textViewCount.setText(String.valueOf(bodySizeItem.getCountOfUnit()));
                    binding.textViewMeasure.setText(OptionsUnit.getWeightItemUnit(getContext()));

                    Date dateNow = new Date();
                    long days=0;
                    if(bodySizeItem.getDate()!=null)
                    { long diff = dateNow.getTime() - bodySizeItem.getDate().getTime();

                        days = TimeUnit.MILLISECONDS.toDays(diff);}
                    binding.textViewDate.setText("Обновлено "+OptionsUnit.getWeightCount(getContext(),days)+" назад");
                }
            };

        MainActivity.getUser().getBodySizeItemList().observe(getViewLifecycleOwner(), this);
        MainActivity.getUser().getWeightItem().observe(getViewLifecycleOwner(),getWeightObserver());
    }
    private Observer<BodySizeItem> getWeightObserver() {
        return
                new Observer<BodySizeItem>() {
                    @Override
                    public void onChanged(BodySizeItem bodySizeItem) {
                        binding.textViewCount.setText(String.valueOf(bodySizeItem.getCountOfUnit()));
                        binding.textViewMeasure.setText(OptionsUnit.getWeightItemUnit(getContext()));

                        Date dateNow = new Date();
                        long days = 0;
                        if (bodySizeItem.getDate() != null) {
                            long diff = dateNow.getTime() - bodySizeItem.getDate().getTime();

                            days = TimeUnit.MILLISECONDS.toDays(diff);
                        }
                        binding.textViewDate.setText("Обновлено " + OptionsUnit.getWeightCount(getContext(), days) + " назад");
                    }
                };
    }

        @Override
    public void setListener() {
        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<BodySizeItem>() {
            @Override
            public void selected(BodySizeItem selectedItem) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new BodyUpdateFragment(selectedItem));
            }
        });
    }

    @Override
    public void initViews(View rootView) {
        textViewToolbarText=rootView.findViewById(R.id.toolbarTextViewText);
        textViewToolbarTitle=  rootView.findViewById(R.id.toolbarTextViewTitle);
        imageviewToolbarBack=rootView.findViewById(R.id.toolbarImageViewBack);
        button=rootView.findViewById(R.id.button);
        textViewToolbarTitle.setText(R.string.measure);
        SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MMMM.yyyy");
        textViewToolbarText.setText( fmtOut.format(MainActivity.getUser().getDate()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new BodyListFragment(false));
            }
        });
        imageviewToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });



    }

    @Override
    public ViewBinding getListHeader() {
          binding = ListHeaderBodysizeItemBinding
                .inflate(LayoutInflater.from(getContext()), itemsList, false);
        binding.button.setVisibility(View.GONE);


        binding.textViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new BodyWeightFragment(MainActivity.getUser().getWeightItem().getValue() ));
            }
        });
        binding.textViewTitle.setVisibility(View.GONE);
        binding.imageViewAdd.setVisibility(View.GONE);
        return   binding;

    }


    @Override
    public boolean isHorizontalItem() {
        return false;
    }


    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void onChanged(List<BodySizeItem> bodySizeItems) {

        infoListAdapter.setInfoItemList(bodySizeItems);

    }



    @Override
    public void loadMoreItems() {

    }
    @Override
    public void reloadContent() {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}