package com.calorie.calc.fragments.tracker.miniitem.bodysize;

import static com.calorie.calc.NavigationHelper.openAddProductFragment;

import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.fragments.tracker.miniitem.MiniItemListFragment;
import com.calorie.calc.utils.DefaultItemsCreator;

import java.util.List;


public class BodyListFragment extends MiniItemListFragment<BodySizeItem> {

    public BodyListFragment(boolean backPressedMainContainer) {
        super(backPressedMainContainer);
    }

    @Override
    public void onHeaderClick() {
        openAddProductFragment(getActivity().getSupportFragmentManager(), new BodyCreateSizeFragment());
    }

    @Override
    public List<BodySizeItem> getList() {
        return DefaultItemsCreator.getDefaultBodySizeItemList();
    }

    @Override
    public String getToolbarTitle() {
        return getString(R.string.add_body_size);
    }

    @Override
    public void onItemClick(BodySizeItem selectedItem) {
        openAddProductFragment(getActivity().getSupportFragmentManager(), new BodySetSizeFragment(selectedItem));
    }


}