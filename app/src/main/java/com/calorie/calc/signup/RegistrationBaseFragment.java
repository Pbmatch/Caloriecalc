package com.calorie.calc.signup;

import android.view.View;

import androidx.lifecycle.Observer;

import com.calorie.calc.R;
import com.calorie.calc.signup.regfragments.Builder;
import com.calorie.calc.signup.regfragments.NavigationHelperReg;
import com.calorie.calc.signup.regfragments.RegBaseFragment;
import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;

public class RegistrationBaseFragment extends BaseFragment {
    @Override
    public FragmentBuilder setBuilder() {
        return new Builder(getContext(),this);
    }

    @Override
    public void setProgressBar() {

      //  binding.progressBar.setCompletedSegments(1);
        RegStateHandler.getFragmentStateMutableLiveData().observe(getViewLifecycleOwner(), new Observer<RegFragmentState>() {
            @Override
            public void onChanged(RegFragmentState regFragmentState) {


                binding.progressBar.setCompletedSegments(  regFragmentState.getType().getNumber());
            }
        });
    }
    @Override
    public void onClick(View v) {
        if(((RegBaseFragment)builder.getNextFragment()).getType().equals(RegBaseFragment.FragmentType.SUCCES)) {
            RegStateHandler.getUserState().setValue(((RegBaseFragment)builder.getNextFragment()).getUser());
            NavigationHelperReg.openSuccesFragment(getParentFragmentManager(),builder.getNextFragment());
            return;

        }

        NavigationHelperReg.openNextFragment(getChildFragmentManager(),builder.getNextFragment());
    }
    @Override
    public int getAcionBarTitleresource() {
        return R.string.registration_actionBar;
    }
}
