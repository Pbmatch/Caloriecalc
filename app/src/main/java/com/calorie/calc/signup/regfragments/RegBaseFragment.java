package com.calorie.calc.signup.regfragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.utils.BackPressable;

public abstract class RegBaseFragment  extends Fragment implements BackPressable {

    static Fragment fragment;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view, savedInstanceState);
    }
  protected abstract void initViews(final View rootView, final Bundle savedInstanceState);

    @Override
    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }
}
