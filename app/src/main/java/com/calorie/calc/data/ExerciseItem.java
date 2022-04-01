package com.calorie.calc.data;

import android.content.Context;

import com.calorie.calc.utils.OptionsUnit;

import java.io.Serializable;
import java.util.Date;

public class ExerciseItem implements Serializable, MiniItem {
    String title;
    int timeMins;
    Date date;
    double energy;
    int imageResource;
    int imageResourceBig;

    public ExerciseItem(String title, int imageResource, int imageResourceBig) {
        this.title = title;
        this.imageResource = imageResource;
        this.imageResourceBig=imageResourceBig;

    }

    public ExerciseItem() {
    }



    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getImageResourceBig() {
        return imageResourceBig;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public int getTimeMins() {
        return timeMins;
    }

    public void setTimeMins(int timeMins) {
        this.timeMins = timeMins;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getImageResource() {
        return imageResource;
    }

    @Override
    public String getUnit(Context context) {
        return OptionsUnit.getExerciseItemTimeUnit(context);
    }
}
