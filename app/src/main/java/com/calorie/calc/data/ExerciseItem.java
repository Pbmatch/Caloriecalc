package com.calorie.calc.data;

import java.io.Serializable;

public class ExerciseItem implements Serializable, MiniItem {
    String title;
    long time;
    double energy;
    int imageResource;

    public ExerciseItem(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }

    public ExerciseItem() {
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }



    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getImageResource() {
        return imageResource;
    }
}
