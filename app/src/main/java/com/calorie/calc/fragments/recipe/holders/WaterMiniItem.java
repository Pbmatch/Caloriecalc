package com.calorie.calc.fragments.recipe.holders;

import android.content.Context;

import com.calorie.calc.data.MiniItem;
import com.calorie.calc.utils.OptionsUnit;

import java.io.Serializable;
import java.util.Date;

public class WaterMiniItem implements Serializable,MiniItem {
    String title ;
    Date date;
    int countOfUnit=0;
    int imageResource;
    int imageResourceBig;

    public WaterMiniItem(String title, int imageResource, int imageResourceBig) {
        this.title = title;
        this.imageResource = imageResource;
        this.imageResourceBig = imageResourceBig;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getCountOfUnit() {
        return countOfUnit;
    }

    public void setCountOfUnit(int countOfUnit) {
        this.countOfUnit = countOfUnit;
    }

    @Override
    public int getImageResource() {
        return imageResource;
    }

    @Override
    public String getUnit(Context context) {
      return OptionsUnit.getWaterUnit(context);
    }

    @Override
    public int getImageResourceBig() {
        return imageResourceBig;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
