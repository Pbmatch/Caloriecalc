package com.calorie.calc.signup.authfragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentPassAuthBinding;
import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.NavigationHelperRegistration;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;


public class PassAuthFragment extends InsideBaseFragment {

    FragmentPassAuthBinding binding;

    public PassAuthFragment(FragmentType type) {
        super(type);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        binding = FragmentPassAuthBinding.bind(rootView);

        setViews();
    }

    void setViews() {

        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());
        binding.textViewrules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelperRegistration.openNextFragment(getParentFragmentManager(),new EmailRemindFragment(InsideBaseFragment.FragmentType.REMIND_MAIL_SUCCES));
            }
        });
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0)
                {   RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());
                user.setPassword(binding.editText.getText().toString());}
                else RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());
            }
        });
        binding.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        binding.imageViewEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editText.getTransformationMethod() != null) {

                    binding.editText.setTransformationMethod(null);


                    binding.imageViewEye.setImageResource(R.drawable.eye_open);
                } else {

                    binding.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.imageViewEye.setImageResource(R.drawable.eye_closed);
                }

            }
        });
    }
    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pass_auth, container, false);
    }
}