package com.calorie.calc.signup;

import android.view.View;

import com.calorie.calc.R;
import com.calorie.calc.signup.auth.AuthBuilder;
import com.calorie.calc.signup.regfragments.NavigationHelperReg;
import com.calorie.calc.signup.regfragments.RegBaseFragment;
import com.calorie.calc.signup.state.RegStateHandler;

public class AuthBaseFragment extends BaseFragment {
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
        if(((RegBaseFragment)builder.getNextFragment()).getType().equals(RegBaseFragment.FragmentType.SUCCES_AUTH)||
                ((RegBaseFragment)builder.getNextFragment()).getType().equals(RegBaseFragment.FragmentType.SUCCES_REMIND) ) {
          //  RegStateHandler.getUserState().setValue(((RegBaseFragment)builder.getNextFragment()).getUser());
            NavigationHelperReg.openSuccesFragment(getParentFragmentManager(),builder.getNextFragment());
            return;

        }
        NavigationHelperReg.openNextFragment(getChildFragmentManager(),builder.getNextFragment());
    }
}
