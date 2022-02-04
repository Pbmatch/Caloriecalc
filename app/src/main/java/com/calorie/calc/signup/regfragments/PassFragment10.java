package com.calorie.calc.signup.regfragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentNameBinding;
import com.calorie.calc.databinding.FragmentPassBinding;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;

public class PassFragment10 extends RegBaseFragment {
    public PassFragment10(FragmentType type) {
        super(type);
    }


    FragmentPassBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pass, container, false);
    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        binding = FragmentPassBinding.bind(rootView);
        setViews();
    }
    void setViews() {

        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());

        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0)
                    RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());
                else RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());
            }
        });
        binding.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        binding.imageViewEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (  binding.editText.getTransformationMethod()!=null) {

                    binding.editText.setTransformationMethod(null);


                    binding.imageViewEye.setImageResource(R.drawable.eye_open);
                }
                else
                {

                    binding.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.imageViewEye.setImageResource(R.drawable.eye_closed);
                }

            }
        });
    }
    @Override
    public void onPause() {
        user.setPassword(binding.editText.getText().toString());
        super.onPause();
    }

}
