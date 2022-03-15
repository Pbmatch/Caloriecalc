package com.calorie.calc.fragments.recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.R;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.holders.RecipeSearch;
import com.calorie.calc.info_list.InfoListAdapter;
import com.calorie.calc.utils.OnScrollBelowItemsListener;

import java.util.concurrent.atomic.AtomicBoolean;


public abstract class RecipeListFragment<T> extends Fragment implements OnRefresh{


    public RecyclerView itemsList;
    public InfoListAdapter<T> infoListAdapter;
    public RecipeType type;
    protected AtomicBoolean isLoading = new AtomicBoolean();
    public  RecipeRecipient recipeRecipient;
    public MutableLiveData< RecipeSearch> recipeSearch;

    public RecipeListFragment(RecipeType type) {

        this.type = type;
    }


    public RecipeListFragment(MutableLiveData< RecipeSearch> recipeSearch  ,RecipeType type) {
        this.type = type;
        this.recipeSearch = recipeSearch;
    }
    public RecipeListFragment( ) {


    }


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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initList(view);
        setListener();
        startLoadData();
        isLoading.set(true);
        RecipeState.getOnRefreshMainRecipe().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                reloadContent();
            }
        });

    }

    public abstract void startLoadData();

    public abstract void setListener();


    @Override
    public void onResume() {

        super.onResume();

    }
    protected void onScrollToBottom() {
System.out.println("void onScrollToBottom()");
        //if ( !isLoading.get()) {
            System.out.println("void onScrollToBottom()loadMoreItems" );
            loadMoreItems();
      //  }
    }
    public abstract void loadMoreItems();

    public abstract boolean isHorizontalItem();

    public abstract int getLayoutManagerOrientation();

    public abstract void initViews(View rootView);

    public void initList(View rootView) {

        itemsList = rootView.findViewById(R.id.rec_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(getLayoutManagerOrientation());
        itemsList.setLayoutManager(layoutManager);
        infoListAdapter.setUseRecipeHorizontalItem(isHorizontalItem());
        itemsList.setAdapter(infoListAdapter);

        itemsList.addOnScrollListener(new OnScrollBelowItemsListener() {
            @Override
            public void onScrolledDown(final RecyclerView recyclerView) {
                onScrollToBottom();
            }
        });


    }
}