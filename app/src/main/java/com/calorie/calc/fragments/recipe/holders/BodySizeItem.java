package com.calorie.calc.fragments.recipe.holders;

import java.io.Serializable;
import java.util.Date;

public class BodySizeItem implements Serializable {
    String title;
    String unit;
    Date time;
    int countOfUnit;
    int imageResource;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getCountOfUnit() {
        return countOfUnit;
    }

    public void setCountOfUnit(int countOfUnit) {
        this.countOfUnit = countOfUnit;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
