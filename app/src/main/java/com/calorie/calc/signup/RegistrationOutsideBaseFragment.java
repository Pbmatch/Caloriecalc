package com.calorie.calc.signup;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.calorie.calc.R;
import com.calorie.calc.signup.fragmentbuilders.FragmentBuilder;
import com.calorie.calc.signup.fragmentbuilders.RegBuilder;
import com.calorie.calc.signup.state.FirebaseAuthCompliteListener;
import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;
import com.google.firebase.auth.AuthResult;

import java.util.logging.Handler;

public class RegistrationOutsideBaseFragment extends OutsideBaseFragment   {
    @Override
    public FragmentBuilder setBuilder() {
        return new RegBuilder(getContext(),this);
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
        if(((InsideBaseFragment)builder.getNextFragment()).getType().equals(InsideBaseFragment.FragmentType.SUCCES)) {


             FirebaseRegistration registration = new FirebaseRegistration(getContext(),this);
             registration.createUserWithEmailAndPassword(RegStateHandler.getUserState().getValue());
          //  RegStateHandler.getUserState().setValue(((InsideBaseFragment)builder.getNextFragment()).getUser());
          //  NavigationHelperRegistration.openSuccesFragment(getParentFragmentManager(),builder.getNextFragment());
            return;

        }

        NavigationHelperRegistration.openNextFragment(getChildFragmentManager(),builder.getNextFragment());
    }
    @Override
    public int getAcionBarTitleresource() {
        return R.string.registration_actionBar;
    }



}
