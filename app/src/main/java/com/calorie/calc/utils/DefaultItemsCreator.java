package com.calorie.calc.utils;

import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.data.ExerciseItem;

import java.util.ArrayList;
import java.util.List;

public class DefaultItemsCreator {



    static List<BodySizeItem> defaultBodySizeItemList = new ArrayList<>();
    static List<ExerciseItem> defaultExerciseItemList = new ArrayList<>();
    public static List<BodySizeItem> getDefaultBodySizeItemList() {
        defaultBodySizeItemList.clear();
        defaultBodySizeItemList.add( new BodySizeItem("Талия",R.drawable.waist,R.drawable.waistbig));
        defaultBodySizeItemList.add( new BodySizeItem("Бедра",R.drawable.hip,R.drawable.hipbig));
        defaultBodySizeItemList.add(new BodySizeItem("Грудь",R.drawable.chest,R.drawable.chestbig));
        return defaultBodySizeItemList;
    }


    public static List<ExerciseItem> getDefaultExerciseItemList() {
        defaultExerciseItemList.clear();
        defaultExerciseItemList.add( new ExerciseItem("Ходьба",R.drawable.walking,R.drawable.walkingbig));
        defaultExerciseItemList.add( new ExerciseItem("Бег",R.drawable.running,R.drawable.runningbig));
        defaultExerciseItemList.add(new ExerciseItem("Силовая тренировка",R.drawable.powertraining,R.drawable.powertrainingbig));
        return defaultExerciseItemList;
    }
}
