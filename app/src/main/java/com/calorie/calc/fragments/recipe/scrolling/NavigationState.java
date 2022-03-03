package com.calorie.calc.fragments.recipe.scrolling;

import androidx.lifecycle.MutableLiveData;

class NavigationState {
     static MutableLiveData<Boolean> onNavigationClick = new MutableLiveData<>();

    public static MutableLiveData<Boolean> getOnNavigationClick() {
        return onNavigationClick;
    }
}
