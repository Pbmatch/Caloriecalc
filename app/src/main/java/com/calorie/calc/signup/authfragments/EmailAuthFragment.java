package com.calorie.calc.signup.authfragments;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.signup.InsideBaseFragment;
import com.calorie.calc.signup.regfragments.EmailFragment;
import com.calorie.calc.signup.regfragments.SuccesRegFragment;

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

    @Override
    protected Fragment getSuccesFragment() {

            return new SuccesRegFragment(InsideBaseFragment.FragmentType.SUCCES_AUTH);

    }
}
