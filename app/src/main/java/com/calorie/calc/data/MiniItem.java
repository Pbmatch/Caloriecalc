package com.calorie.calc.data;

import android.content.Context;

import java.util.Date;

public interface MiniItem {
     String getTitle();
    int getImageResource();
    String getUnit(Context context);
    int getImageResourceBig() ;
    Date getDate() ;
}
