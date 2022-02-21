package com.calorie.calc.info_list;

import android.content.Context;

import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.utils.OnClickGesture;

public class InfoItemBuilder {
    Context context;
    private OnClickGesture<RecipeAndLinks> onRecipeClickListener;
    public InfoItemBuilder(Context context) {
        this.context=context;

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setOnRecipeClickListener(OnClickGesture<RecipeAndLinks> listener) {
     this.onRecipeClickListener=listener;
    }

    public OnClickGesture<RecipeAndLinks> getOnRecipeClickListener() {
        return onRecipeClickListener;
    }
}
