package com.calorie.calc.fragments.recipe.liked;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.ListEmptyAndToolbar;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;


public class LikedFragment extends ListEmptyAndToolbar<RecipeAndLinks> implements BackPressable {



    public LikedFragment(MutableLiveData<List<RecipeAndLinks>> recipeState) {
        super(recipeState);
    }

    @Override
    public  void setListener() {


        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinks>() {
            @Override
            public void selected(RecipeAndLinks selectedItem) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new NavigationFragment(selectedItem));
            }
        });
    }

    @Override
    public void loadMoreItems() {

    }


    @Override
    public void setToolbar() {
        toolbarText.setText(R.string.liked);
    }

    @Override
    public  boolean isHorizontalItem() {
        return false;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void reloadContent() {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}