package com.calorie.calc.fragments.tracker.bodysize;

import static com.calorie.calc.NavigationHelper.openAddProductFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.databinding.ListHeaderTextviewBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.utils.Constants;
import com.calorie.calc.utils.OnClickGesture;


public class BodyListFragment extends ListFragment<BodySizeItem> {


   private TextView toolbarTitle;
    public BodyListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_body_list, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {
        return null;
    }

    @Override
    public void startLoadData() {
        ListHeaderTextviewBinding viewBinding = ListHeaderTextviewBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.textViewHeader.setText("+ДОБАВИТЬ СВОЙ ПАРАМЕТР");
        viewBinding.textViewHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddProductFragment(getActivity().getSupportFragmentManager(),new BodyCreateSizeFragment());
            }
        });
        infoListAdapter.setHeader(viewBinding.getRoot());
        infoListAdapter.setInfoItemList(Constants.getDefaultBodySizeItemList());
        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<BodySizeItem>() {
            @Override
            public void selected(BodySizeItem selectedItem) {
                openAddProductFragment(getActivity().getSupportFragmentManager(),new BodySetSizeFragment(selectedItem));
            }
        });


    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadMoreItems() {

    }

    @Override
    public boolean isHorizontalItem() {
        return false;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void initViews(View rootView) {
        toolbarTitle = rootView.findViewById(R.id.toolbarTextViewTitle);
        toolbarTitle.setText("Добавление измерений");

    }

    @Override
    public void reloadContent() {

    }
}