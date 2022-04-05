package com.calorie.calc.info_list.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;

import java.text.SimpleDateFormat;

public class BodySizeHolder  extends InfoItemHolder<BodySizeItem> {

    private TextView textViewTitle;
    private  TextView textViewText;
    private ImageView imageView;
    private TextView textViewCount;
    private ConstraintLayout csl;
    private ImageView imageViewAdd;

    BodySizeHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        textViewText = itemView.findViewById(R.id.textViewText);
        imageView = itemView.findViewById(R.id.imageView);
        imageViewAdd = itemView.findViewById(R.id.imageView_add);
        textViewCount =  itemView.findViewById(R.id.textViewCount);
        csl=itemView.findViewById(R.id.csl);
    }
    public BodySizeHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_bodysize_item, parent);
    }


    @Override
    public void updateFromItem(BodySizeItem infoItem, int position) {
        textViewTitle.setText(infoItem.getTitle());
        SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MM.yy");

        textViewText.setText( fmtOut.format(infoItem.getDate()));
        textViewCount.setText(infoItem.getCountOfUnit()+infoItem.getUnit(itemBuilder.getContext()));
        imageView.setImageResource(infoItem.getImageResource());
        csl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemBuilder.getOnRecipeClickListener()!=null)
                    itemBuilder.getOnRecipeClickListener().selected(infoItem);
            }
        });
        imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemBuilder.getOnRecipeClickListener()!=null)
                    itemBuilder.getOnRecipeClickListener().selected(infoItem);
            }
        });

    }

    @Override
    public void updateState(BodySizeItem infoItem) {

    }
}
