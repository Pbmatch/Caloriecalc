package com.calorie.calc.fragments.tracker.miniitem.exercise;

import static com.calorie.calc.NavigationHelper.openAddProductFragment;

import com.calorie.calc.R;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.fragments.tracker.miniitem.MiniItemListFragment;
import com.calorie.calc.utils.DefaultItemsCreator;

import java.util.List;

public class ExerciseListFragment extends MiniItemListFragment<ExerciseItem>  {

    @Override
    public void onHeaderClick() {
        openAddProductFragment(getActivity().getSupportFragmentManager(),new ExerciseCreateFragment());
    }

    @Override
    public List<ExerciseItem> getList() {
      return DefaultItemsCreator.getDefaultExerciseItemList();
    }

    @Override
    public String getToolbarTitle() {
        return getString(R.string.add_exercise);
    }

    @Override
    public void onItemClick(ExerciseItem selectedItem) {
        openAddProductFragment(getActivity().getSupportFragmentManager(),new ExerciseSetFragment(selectedItem));

    }


}