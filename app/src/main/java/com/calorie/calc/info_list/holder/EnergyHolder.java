package com.calorie.calc.info_list.holder;

import static com.calorie.calc.utils.MeasureUtils.getNutrientString;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.calorie.calc.R;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Nutrient;
import com.calorie.calc.info_list.InfoItemBuilder;
import com.calorie.calc.info_list.InfoItemHolder;
import com.calorie.calc.utils.DisplaySize;

public class EnergyHolder extends InfoItemHolder< Nutrient> {

    private TextView itemTitleView;
    private  TextView itemKkalView;
    private ConstraintLayout constraintLayout;

      EnergyHolder(InfoItemBuilder infoItemBuilder, int layoutId, ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
          itemTitleView = itemView.findViewById(R.id.textViewTitle);
          itemKkalView = itemView.findViewById(R.id.textViewText);
          constraintLayout=itemView.findViewById(R.id.csl);
    }
    public EnergyHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_kkal_item, parent);
    }

    @Override
    public void updateFromItem( Nutrient infoItem,int pos) {
        ViewGroup.LayoutParams params = constraintLayout.getLayoutParams();

        params.width = (int) (DisplaySize.getWIDTH()/4);
        itemView.setLayoutParams(params);
        itemTitleView.setText( infoItem.getLabel());
        itemKkalView.setText(getNutrientString(infoItem.getQuantity(),infoItem.getUnit()));

    }

    @Override
    public void updateState( Nutrient infoItem) {

    }
}
