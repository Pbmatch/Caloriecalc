package com.calorie.calc.signup.regfragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentEmailBinding;
import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.OnKeyboardVisibilityListener;
import com.calorie.calc.signup.RegistrationActivity;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegStateHandler;


public class EmailFragment  extends InsideBaseFragment implements OnKeyboardVisibilityListener {

    public   FragmentEmailBinding binding;
    public EmailFragment(FragmentType type) {
        super(type);
    }

    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
    binding=FragmentEmailBinding.bind(rootView);
    setViews();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_email, container, false);
    }
    public void addKeyboardListener()
    {
        ((RegistrationActivity)getActivity()).setKeyboardVisibilityListener(this);

    }
   protected Fragment getSuccesFragment()
    {
        return new SuccesRegFragment(InsideBaseFragment.FragmentType.SUCCES);
    }
    void setViews() {

        addKeyboardListener();
        binding.buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegistrationActivity)getActivity()).signIn(getSuccesFragment());
            }
        });
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
                if(isEmailValid(s.toString())){
                    RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());

                    binding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                            boolean handled = false;
                            if (actionId == EditorInfo.IME_ACTION_DONE&&isEmailValid(s.toString())) {
                                RegStateHandler.getButtonState().setValue(new ButtonState.ButtonClick());
                                handled = true;
                            }
                            return handled;
                        }
                    });

                    user.setEmail(s.toString());
                }
                else RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOff());
            }
            boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
        });
    }

    @Override
    public void onDestroyView() {
        ((RegistrationActivity)getActivity()).removeKeyboardListener();
        super.onDestroyView();
    }



    @Override
    public void onVisibilityChanged(boolean visible) {
        if(visible)
        {
            binding.buttonGoogle.setVisibility(View.GONE);
            binding.textViewText.setVisibility(View.GONE);

        } else
        {binding.buttonGoogle.setVisibility(View.VISIBLE);
            binding.textViewText.setVisibility(View.VISIBLE);}
            System.out.println("OnVisibile"+visible);
    }
}