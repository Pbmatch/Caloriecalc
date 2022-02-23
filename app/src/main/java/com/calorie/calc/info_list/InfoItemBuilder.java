package com.calorie.calc.info_list;

import android.content.Context;

import com.calorie.calc.utils.OnClickGesture;

public class InfoItemBuilder<T> {
    Context context;
    private OnClickGesture<T> onRecipeClickListener;
    public InfoItemBuilder(Context context) {
        this.context=context;

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setOnRecipeClickListener(OnClickGesture<T> listener) {
     this.onRecipeClickListener=listener;
    }

    public OnClickGesture<T> getOnRecipeClickListener() {
        return onRecipeClickListener;
    }
}
