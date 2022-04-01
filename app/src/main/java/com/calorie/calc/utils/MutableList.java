package com.calorie.calc.utils;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MutableList<T extends List<Y>,Y> extends MutableLiveData<T> {

    public void additem(Y item)
{
    if(this.getValue()==null)
    {
        List<Y> list = new ArrayList<>();
        list.add(item);
        this.setValue((T)list);
        return;
    }
    this.getValue().add(item);
    notifyDataSetChanged();
}
    public void notifyDataSetChanged()
    {

        this.setValue(this.getValue());
    }

}
