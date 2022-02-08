package com.calorie.calc.signup.authfragments;

import android.os.Bundle;
import android.view.View;

import com.calorie.calc.R;
import com.calorie.calc.signup.regfragments.EmailFragment;

public class EmailAuthFragment extends EmailFragment {
    public EmailAuthFragment(FragmentType type) {
        super(type);
    }


    @Override
    protected void initViews(View rootView, Bundle savedInstanceState) {
        super.initViews(rootView, savedInstanceState);
        binding.textViewTitle.setText(R.string.authorization_email_title);
        binding.textViewTitle.setTextAppearance(R.style.text_title_min);

    }
}
