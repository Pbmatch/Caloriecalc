package com.calorie.calc.signup.regfragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentPassBinding;
import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;

public class PassConfirmFragment11 extends InsideBaseFragment {
    public PassConfirmFragment11(FragmentType type) {
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
                if(s.toString().length()>0){

                    if(!s.toString().equals(user.getPassword()))
                    {
                        binding.editText.setBackgroundResource(R.drawable.edit_text_password_wrong);
                        binding.textViewrules.setText(R.string.registration_pass_text_wrong);
                        binding.textViewrules.setTextColor(getContext().getColor(R.color.red));
                        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());
                    }
                    else
                    { binding.editText.setBackgroundResource(R.drawable.edittext_focused);
                        binding.textViewrules.setText(R.string.registration_pass_text_ok);
                        binding.textViewrules.setTextColor(getContext().getColor(R.color.button_green));

                            RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());

                            binding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                                @Override
                                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                                    boolean handled = false;
                                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                                        RegStateHandler.getButtonState().setValue(new ButtonState.ButtonClick());
                                        handled = true;
                                    }
                                    return handled;
                                }
                            });



                    }
                }
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
       // user.setPassword(binding.editText.getText().toString());
        super.onPause();
    }

}


