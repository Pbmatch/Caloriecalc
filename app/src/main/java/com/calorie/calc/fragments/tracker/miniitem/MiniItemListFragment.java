package com.calorie.calc.fragments.tracker.miniitem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.databinding.ListHeaderTextviewBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;

public abstract class MiniItemListFragment<T> extends ListFragment<T> implements BackPressable {


    private TextView toolbarTitle;
    private ImageView toolbarBack;

    public MiniItemListFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_body_list, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {
        return null;
    }

    public abstract void onHeaderClick();

    public abstract List<T> getList();

    public abstract String getToolbarTitle();

    public abstract void onItemClick(T selectedItem);

    @Override
    public void startLoadData() {
        ListHeaderTextviewBinding viewBinding = ListHeaderTextviewBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.textViewHeader.setText("+ДОБАВИТЬ СВОЙ ПАРАМЕТР");
        viewBinding.textViewHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHeaderClick();
            }
        });
        infoListAdapter.setHeader(viewBinding.getRoot());
        infoListAdapter.setInfoItemList(getList());
        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<T>() {
            @Override
            public void selected(T selectedItem) {
                onItemClick(selectedItem);
            }
        });


    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadMoreItems() {

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
    public void initViews(View rootView) {
        toolbarTitle = rootView.findViewById(R.id.toolbarTextViewTitle);
        toolbarBack = rootView.findViewById(R.id.toolbarImageViewBack);
        toolbarTitle.setText(getToolbarTitle());
        toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void reloadContent() {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}