package com.calorie.calc;

import androidx.lifecycle.MutableLiveData;

import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.utils.MutableList;

import java.util.Date;
import java.util.List;

public class User {
    GoalWeight goalWeight;
    Lifestyle lifestyle;
    Gender gender;
    Date birthDate;
    int height;
    int weight;
    int needWeight;
    String name;
    String email;
    String password;
    MutableLiveData<BodySizeItem> weightItem=new MutableLiveData<>();
    MutableList<List<BodySizeItem>,BodySizeItem> bodySizeItemList = new MutableList<>();
    MutableList<List<ExerciseItem>,ExerciseItem> exerciseItemList = new MutableList<>();

    public MutableList<List<BodySizeItem>,BodySizeItem> getBodySizeItemList() {

        return bodySizeItemList;
    }

    public MutableList<List<ExerciseItem>,ExerciseItem> getExerciseItemList() {

        return exerciseItemList;
    }

    public MutableLiveData<BodySizeItem> getWeightItem() {
        if(weightItem.getValue()==null)
            weightItem.setValue(new BodySizeItem("Вес",R.drawable.weightscale, R.drawable.weightscale));
        return weightItem;
    }

    public GoalWeight getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(GoalWeight goalWeight) {
        this.goalWeight = goalWeight;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNeedWeight() {
        return needWeight;
    }

    public void setNeedWeight(int needWeight) {
        this.needWeight = needWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public enum GoalWeight
    {
        UP,
        DOWN,
        SUPPORT;
    }
    public enum Lifestyle
    {

        NO_SPORT(R.string.registration_lifestyle_1),
        SPORT_1_2(R.string.registration_lifestyle_2),
        SPORT_3_5(R.string.registration_lifestyle_3),
        SPORT_EVERYDAY(R.string.registration_lifestyle_4);

        int resourceText;

        Lifestyle(int text) {
            this.resourceText = text;
        }

        public int getResourceText() {
            return resourceText;
        }
    }
    public  enum Gender
    {
        MALE, FEMALE;
    }
}
