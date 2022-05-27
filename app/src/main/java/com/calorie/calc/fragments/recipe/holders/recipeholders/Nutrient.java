package com.calorie.calc.fragments.recipe.holders.recipeholders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public abstract class Nutrient implements Serializable
{
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    protected double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;


    double portion=1;
    protected double summQuantity=0;


    public Nutrient() {
    }

    public double getSummQuantity() {
        return summQuantity;
    }

    public void setSummQuantity(double summQuantity) {
        this.summQuantity = summQuantity;
    }

    public Nutrient(String label, double quantity, String unit) {
        this.label = label;
        this.quantity = quantity;
        this.unit = unit;
    }



    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        this.portion = portion;
    }

    private final static long serialVersionUID = -4662665335057143265L;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getQuantityOnePortion() {
        return quantity/portion;
    }


    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}