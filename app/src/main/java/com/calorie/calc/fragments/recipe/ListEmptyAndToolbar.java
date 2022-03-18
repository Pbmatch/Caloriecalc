package com.calorie.calc.fragments.recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.R;

import java.util.List;

public abstract class ListEmptyAndToolbar<T>  extends RecipeListFragment<T> {

    protected LinearLayout emptyLinearLayout;
    protected ImageView emptyImageView;
    protected  TextView emptyTextView;
    protected ImageView toolbarImageViewClose;
    protected ImageView toolbarImageViewRight;
    protected TextView toolbarText;
     public MutableLiveData<List<T>> recipeState;
    public ListEmptyAndToolbar(MutableLiveData<List<T>> recipeState) {

        super( );
        this.recipeState=recipeState;
    }
    public ListEmptyAndToolbar( ) {
     super();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_with_toolbar, container, false);
    }

    @Override
    public void startLoadData() {
        infoListAdapter.setInfoItemList(recipeState.getValue());
        if(recipeState.getValue()==null||recipeState.getValue().isEmpty())
            emptyLinearLayout.setVisibility(View.VISIBLE);
        else  emptyLinearLayout.setVisibility(View.GONE);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        emptyLinearLayout =view.findViewById(R.id.empty_state_view);
        emptyImageView =view.findViewById(R.id.empty_state_desc);
        emptyTextView =view.findViewById(R.id.empty_state_text);
        toolbarImageViewClose =view.findViewById(R.id.imageViewBack);
        toolbarImageViewRight = view.findViewById(R.id.imageViewRight);
        toolbarText=view.findViewById(R.id.toolbarTextViewTitle);
        super.onViewCreated(view, savedInstanceState);
        setToolbar();

    }



    @Override
    public  void initViews(View rootView) {

        toolbarImageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
    }
    public abstract void setToolbar();

    @Override
    public  boolean isHorizontalItem() {
        return false;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }
}