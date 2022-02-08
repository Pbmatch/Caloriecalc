package com.calorie.calc.signup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.databinding.ActivityRegistrationBinding;
import com.calorie.calc.utils.BackPressable;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class RegistrationActivity extends AppCompatActivity {
   ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Caloriecalc);
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NavigationHelperRegistration.openStartFragment(getSupportFragmentManager());

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);

        }

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();

        }

         return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        final Fragment fragmentPanel = getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerViewActivityReg);
       if (fragmentPanel instanceof BackPressable) {
            if (!((BackPressable) fragmentPanel).onBackPressed())
            {
                getSupportFragmentManager().popBackStack();
            }
            }
        else
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
    ViewTreeObserver.OnGlobalLayoutListener globalListener;

    public void setKeyboardVisibilityListener(final OnKeyboardVisibilityListener onKeyboardVisibilityListener) {
        final View parentView = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        globalListener=  new ViewTreeObserver.OnGlobalLayoutListener() {

            private boolean alreadyOpen;
            private final int defaultKeyboardHeightDP = 100;
            private final int EstimatedKeyboardDP = defaultKeyboardHeightDP + (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 48 : 0);
            private final Rect rect = new Rect();

            @Override
            public void onGlobalLayout() {
                int estimatedKeyboardHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, EstimatedKeyboardDP, parentView.getResources().getDisplayMetrics());
                parentView.getWindowVisibleDisplayFrame(rect);
                int heightDiff = parentView.getRootView().getHeight() - (rect.bottom - rect.top);
                boolean isShown = heightDiff >= estimatedKeyboardHeight;

                if (isShown == alreadyOpen) {
                    Log.i("Keyboard state", "Ignoring global layout change...");
                    return;
                }
                alreadyOpen = isShown;
                onKeyboardVisibilityListener.onVisibilityChanged(isShown);
            }
        };


        parentView.getViewTreeObserver().addOnGlobalLayoutListener(globalListener);
    }
    public void removeKeyboardListener()
    {
        final View parentView = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        if(globalListener!=null)
            parentView.getViewTreeObserver().removeOnGlobalLayoutListener(globalListener);
    }
}