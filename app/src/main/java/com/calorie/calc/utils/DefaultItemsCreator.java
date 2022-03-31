package com.calorie.calc.utils;

import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;

import java.util.ArrayList;
import java.util.List;

public class DefaultItemsCreator {



    static List<BodySizeItem> defaultBodySizeItemList = new ArrayList<>();
    public static List<BodySizeItem> getDefaultBodySizeItemList() {
        defaultBodySizeItemList.clear();
        defaultBodySizeItemList.add( new BodySizeItem("Талия",R.drawable.waist,R.drawable.waistbig));
        defaultBodySizeItemList.add( new BodySizeItem("Бедра",R.drawable.hip,R.drawable.hipbig));
        defaultBodySizeItemList.add(new BodySizeItem("Грудь",R.drawable.chest,R.drawable.chestbig));
        return defaultBodySizeItemList;
    }


}
