package com.calorie.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.calorie.calc.databinding.ActivityMainBinding;
import com.calorie.calc.signup.RegistrationActivity;
import com.calorie.calc.signup.state.RegStateHandler;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Caloriecalc);

        super.onCreate(savedInstanceState);
        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        Intent mIntent = new Intent(this, RegistrationActivity.class);
        startActivity(mIntent);
    }

    @Override
    public void onResume() {
        super.onResume();
      /*  System.out.println("ONRESUME");
        if(RegStateHandler.getUserState().getValue()!=null)
        {
            User user = RegStateHandler.getUserState().getValue();
            binding.textView.setText("name:"+user.getName()+" mail:"+user.getEmail()+" pass:"+user.getPassword());

        }*/
    }
}