package com.calorie.calc.fragments.recipe.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.ListEmptyAndToolbar;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;

import java.util.ArrayList;
import java.util.List;

public class ProductContainerFragment extends ListEmptyAndToolbar<Fragment> {


    public ProductContainerFragment() {
        super();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_with_toolbar, container, false);
    }

    @Override
    public void startLoadData() {
        // super.startLoadData();
        List<RecipeAndLinks> list=RecipeState.getProductLiveData().getValue();
        if(list==null||list.isEmpty())
            emptyLinearLayout.setVisibility(View.VISIBLE);
        else {
            List<Fragment> fragmentList = new ArrayList<>();
            for(RecipeAndLinks item:list)
            {
               fragmentList.add(new ProductSeeFragment(item,getChildFragmentManager()));

            }
            infoListAdapter.setInfoItemList(fragmentList);
            emptyLinearLayout.setVisibility(View.GONE);
        }


    }



    @Override
    public void setListener() {

    }

    @Override
    public void setToolbar() {
        toolbarText.setText("Список продуктов");
        toolbarImageViewRight.setVisibility(View.VISIBLE);
        toolbarImageViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeState.getProductLiveData().getValue().clear();
                getParentFragmentManager().popBackStack();
            }
        });

    }
}