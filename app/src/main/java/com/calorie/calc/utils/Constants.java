package com.calorie.calc.utils;

import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    static List<BodySizeItem> defaultBodySizeItemList = new ArrayList<>();

    public static List<BodySizeItem> getDefaultBodySizeItemList() {
        defaultBodySizeItemList.clear();

        defaultBodySizeItemList.add( new BodySizeItem("Талия",R.drawable.waist));
        defaultBodySizeItemList.add( new BodySizeItem("Бедра",R.drawable.hip));
        defaultBodySizeItemList.add(new BodySizeItem("Грудь",R.drawable.chest));
        return defaultBodySizeItemList;
    }


}
