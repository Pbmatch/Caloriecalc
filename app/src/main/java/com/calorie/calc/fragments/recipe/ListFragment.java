package com.calorie.calc.fragments.recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.info_list.InfoListAdapter;
import com.calorie.calc.utils.OnScrollBelowItemsListener;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ListFragment<T> extends Fragment implements OnRefresh {


    public RecyclerView itemsList;
    public InfoListAdapter<T> infoListAdapter;

    protected AtomicBoolean isLoading = new AtomicBoolean();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (infoListAdapter == null) {
            infoListAdapter = new InfoListAdapter<T>(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recipe_inner_horiz, container, false);
    }

    protected abstract ViewBinding getListFooter();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initList(view);
        setListener();
        startLoadData();
        isLoading.set(true);


    }

    public abstract void startLoadData();

    public abstract void setListener();


    @Override
    public void onResume() {

        super.onResume();

    }

    public void setLoading(boolean bool) {
        showListFooter(bool);
    }

    protected void onScrollToBottom() {

        if (infoListAdapter.getItemsList() != null && infoListAdapter.getItemCount() > 5) {
            loadMoreItems();
        }

    }


    public void showListFooter(final boolean show) {
        itemsList.post(() -> {
            if (infoListAdapter != null && itemsList != null) {
                infoListAdapter.showFooter(show);
            }
        });
    }

    public abstract void loadMoreItems();

    public abstract boolean isHorizontalItem();

    public abstract int getLayoutManagerOrientation();

    public abstract void initViews(View rootView);

    public abstract ViewBinding getListHeader();

    public void initList(View rootView) {

        itemsList = rootView.findViewById(R.id.rec_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(getLayoutManagerOrientation());
        itemsList.setLayoutManager(layoutManager);
        infoListAdapter.setUseRecipeHorizontalItem(isHorizontalItem());
        itemsList.setAdapter(infoListAdapter);
        if(getListFooter()!=null)
        infoListAdapter.setFooter(getListFooter().getRoot());
        if(getListHeader()!=null) {
            infoListAdapter.setHeader(getListHeader().getRoot());

        }
        itemsList.addOnScrollListener(new OnScrollBelowItemsListener() {
            @Override
            public void onScrolledRight(RecyclerView recyclerView) {

                onScrollToBottom();
            }

            @Override
            public void onScrolledDown(final RecyclerView recyclerView) {

                onScrollToBottom();
            }


        });


    }
}