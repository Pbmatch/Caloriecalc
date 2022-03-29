package com.calorie.calc.info_list.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;

public class FragmentHolder extends InfoItemHolder<Fragment> {

    ConstraintLayout layout;
      FragmentHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
          layout = itemView.findViewById(R.id.csl);
    }
    public FragmentHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_fragment_item, parent);
    }
    @Override
    public void updateFromItem(Fragment infoItem, int position) {
        FrameLayout frameLayout = new FrameLayout(itemBuilder.getContext());
        frameLayout.setId(View.generateViewId());

        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        layout.addView(frameLayout);
        IFragment productSeeFragment = (IFragment) infoItem;

        NavigationHelper.openSeeFragment(productSeeFragment.getMyfragmentManager(),(Fragment) productSeeFragment,frameLayout.getId());

    }

    @Override
    public void updateState(Fragment infoItem) {

    }
}
