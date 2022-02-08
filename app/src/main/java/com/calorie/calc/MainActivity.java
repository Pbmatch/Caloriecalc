package com.calorie.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.calorie.calc.databinding.ActivityMainBinding;
import com.calorie.calc.signup.RegistrationActivity;
import com.calorie.calc.signup.state.RegStateHandler;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Caloriecalc);

        super.onCreate(savedInstanceState);
        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.setLanguageCode(Locale.getDefault().getLanguage());
        FirebaseAuth.getInstance().signOut();
      /*  if(firebaseAuth.getCurrentUser()==null)
         {*/
             Intent mIntent = new Intent(this, RegistrationActivity.class);
        startActivity(mIntent);
       /*  }*/
    }


}