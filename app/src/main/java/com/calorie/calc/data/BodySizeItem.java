package com.calorie.calc.data;

import android.content.Context;

import com.calorie.calc.utils.OptionsUnit;

import java.io.Serializable;
import java.util.Date;

public class BodySizeItem implements Serializable,MiniItem {
    String title;
    Date date;
    int countOfUnit;
    int imageResource;
    int imageResourceBig;

    public BodySizeItem(String title, int imageResource, int imageResourceBig) {
        this.title = title;
        this.imageResource = imageResource;
        this.imageResourceBig = imageResourceBig;
    }

    public BodySizeItem() {
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getImageResource() {
        return imageResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String getUnit(Context context) {
        return OptionsUnit.getBodySizeUnit(context);
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

    public int getCountOfUnit() {
        return countOfUnit;
    }

    public void setCountOfUnit(int countOfUnit) {
        this.countOfUnit = countOfUnit;
    }



    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
