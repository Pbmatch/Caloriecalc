package com.calorie.calc.signup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.databinding.ActivityRegistrationBinding;
import com.calorie.calc.signup.regfragments.NavigationHelperReg;
import com.calorie.calc.utils.BackPressable;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RegistrationActivity extends AppCompatActivity {
   ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Caloriecalc);
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NavigationHelperReg.openStartFragment(getSupportFragmentManager());

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
}