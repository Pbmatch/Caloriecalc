package com.calorie.calc.info_list.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.data.MiniItem;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;

public class MiniItemHolder extends InfoItemHolder<MiniItem> {

    private TextView textViewTitle;
    private ImageView imageView;
    private ConstraintLayout csl;


    MiniItemHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        imageView = itemView.findViewById(R.id.imageView);
        csl=itemView.findViewById(R.id.csl);

    }



    public MiniItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_mini_item, parent);
    }


    @Override
    public void updateFromItem(MiniItem infoItem, int position) {
        textViewTitle.setText(infoItem.getTitle());
        imageView.setImageResource(infoItem.getImageResource());
        csl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemBuilder.getOnRecipeClickListener()!=null)
                itemBuilder.getOnRecipeClickListener().selected(infoItem);
            }
        });

    }

    @Override
    public void updateState(MiniItem infoItem) {

    }



}
