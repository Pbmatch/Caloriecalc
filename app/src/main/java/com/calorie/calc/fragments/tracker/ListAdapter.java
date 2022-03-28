package com.calorie.calc.fragments.tracker;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.info_list.InfoListAdapter;

public abstract class ListAdapter <T> {

    protected    RecyclerView itemsList;
    private Context context;
    public InfoListAdapter<T> infoListAdapter;
    public Context getContext() {
        return context;
    }

    public ListAdapter(RecyclerView itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
        if (infoListAdapter == null) {
            infoListAdapter = new InfoListAdapter<>(getContext());
        }
        initList();
    }
    public abstract ViewBinding getListFooter();
    public abstract ViewBinding getListHeader();

    private void initList( ) {


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(getLayoutManagerOrientation());
        itemsList.setLayoutManager(layoutManager);

        itemsList.setAdapter(infoListAdapter);
        if(getListFooter()!=null) {
            infoListAdapter.setFooter(getListFooter().getRoot());
            infoListAdapter.showFooter(true);
        }
        if(getListHeader()!=null) {
            infoListAdapter.setHeader(getListHeader().getRoot());

        }
    }
    @RecyclerView.Orientation
    int getLayoutManagerOrientation()
    {
        return LinearLayoutManager.VERTICAL;
    }
}
