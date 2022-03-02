package com.calorie.calc.fragments.recipe.liked;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.RecipeListFragment;
import com.calorie.calc.fragments.recipe.scrolling.ScrollingFragment;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;


public class LikedFragment extends RecipeListFragment<RecipeAndLinks> {

    LinearLayout linearLayout;
    ImageView imageViewClose;

    public LikedFragment(MutableLiveData<List<RecipeAndLinks>> recipeState) {
        super(recipeState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liked, container, false);
    }

    @Override
    public void startLoadData() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        linearLayout=view.findViewById(R.id.empty_state_view);
        imageViewClose=view.findViewById(R.id.imageViewBack);
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public  void setListener() {
        infoListAdapter.addInfoItemList(recipeState.getValue());
        if(recipeState.getValue()==null||recipeState.getValue().isEmpty())
            linearLayout.setVisibility(View.VISIBLE);
        else  linearLayout.setVisibility(View.GONE);

        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinks>() {
            @Override
            public void selected(RecipeAndLinks selectedItem) {
                NavigationHelper.openDietFragment(getActivity().getSupportFragmentManager(),new ScrollingFragment(selectedItem));
            }
        });
    }

    @Override
    public  void initViews(View rootView) {

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public  boolean isHorizontalItem() {
        return false;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }
}