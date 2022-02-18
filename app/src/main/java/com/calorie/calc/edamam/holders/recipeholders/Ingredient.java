package com.calorie.calc.edamam.holders.recipeholders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Ingredient implements Serializable
{

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("measure")
    @Expose
    private String measure;
    @SerializedName("food")
    @Expose
    private String food;
    @SerializedName("weight")
    @Expose
    private double weight;
    @SerializedName("foodCategory")
    @Expose
    private String foodCategory;
    @SerializedName("foodId")
    @Expose
    private String foodId;
    @SerializedName("image")
    @Expose
    private String image;
    private final static long serialVersionUID = -3683974407136401961L;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}