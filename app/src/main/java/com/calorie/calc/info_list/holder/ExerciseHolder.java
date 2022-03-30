package com.calorie.calc.info_list.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;

import java.util.Date;

public class ExerciseHolder extends InfoItemHolder<ExerciseItem> {

    private TextView textViewTitle;
    private  TextView textViewText;
    private ImageView imageView;
    private TextView textViewCount;
    private ConstraintLayout csl;

    ExerciseHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        textViewText = itemView.findViewById(R.id.textViewText);
        imageView = itemView.findViewById(R.id.imageView);
        textViewCount =  itemView.findViewById(R.id.textViewCount);
        csl=itemView.findViewById(R.id.csl);
    }
    public ExerciseHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_exercise_item, parent);
    }


    @Override
    public void updateFromItem(ExerciseItem infoItem, int position) {
        textViewTitle.setText(infoItem.getTitle());
        Date date = new Date();
        date.setTime(infoItem.getTime());
        textViewText.setText(date.toString());
        textViewCount.setText(String.valueOf(infoItem.getEnergy()));
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
    public void updateState(ExerciseItem infoItem) {

    }
}
