package com.calorie.calc.signup;

import android.view.View;

import com.calorie.calc.R;
import com.calorie.calc.signup.fragmentbuilders.AuthBuilder;
import com.calorie.calc.signup.fragmentbuilders.FragmentBuilder;
import com.calorie.calc.signup.state.RegStateHandler;

public class AuthOutsideBaseFragment extends OutsideBaseFragment {
    @Override
    public FragmentBuilder setBuilder() {
       return new AuthBuilder(getContext(),this);
    }

    @Override
    public void setProgressBar() {
        binding.progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public int getAcionBarTitleresource() {
        return R.string.authorization_toolbar;
    }

    @Override
    public void onClick(View v) {
        if(((InsideBaseFragment)builder.getNextFragment()).getType().equals(InsideBaseFragment.FragmentType.SUCCES_AUTH)
        ) {
            FirebaseRegistration registration = new FirebaseRegistration(getContext(),this);
             registration.signInWithEmailAndPass(RegStateHandler.getUserState().getValue());
            return;

        }
        if(((InsideBaseFragment)builder.getNextFragment()).getType().equals(InsideBaseFragment.FragmentType.SUCCES_REMIND))
        {
            FirebaseRegistration registration = new FirebaseRegistration(getContext(),this);
            registration.rememberPass(RegStateHandler.getUserState().getValue().getEmail());
            return;
        }
        NavigationHelperRegistration.openNextFragment(getChildFragmentManager(),builder.getNextFragment());
    }
}
