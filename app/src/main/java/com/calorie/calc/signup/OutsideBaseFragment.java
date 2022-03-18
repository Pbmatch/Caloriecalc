package com.calorie.calc.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.calorie.calc.R;
import com.calorie.calc.User;
import com.calorie.calc.databinding.FragmentRegBaseBinding;
import com.calorie.calc.signup.fragmentbuilders.FragmentBuilder;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.FirebaseAuthCompliteListener;
import com.calorie.calc.signup.state.RegStateHandler;
import com.calorie.calc.utils.BackPressable;
import com.google.firebase.auth.AuthResult;


public abstract class OutsideBaseFragment extends Fragment implements BackPressable, View.OnClickListener, FirebaseAuthCompliteListener {


    FragmentRegBaseBinding binding;
    FragmentBuilder builder;

    public OutsideBaseFragment() {
    }

   /* public static OutsideBaseFragment newInstance() {
        OutsideBaseFragment fragment = new OutsideBaseFragment();
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = new User();
        RegStateHandler.getUserState().setValue(user);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_reg_base, container, false);
        Toolbar toolbar =   view.findViewById(R.id.srt_toolbar);
       builder= setBuilder();

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(true);

        return view;
    }
    public abstract FragmentBuilder setBuilder();
    public abstract void setProgressBar();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle();
        NavigationHelperRegistration.openNextFragment(getChildFragmentManager(),builder.getNextFragment());
        initViews(view, savedInstanceState);
        setProgressBar();
    }

//Базовому фрагменту подсовывать следующие под нажатие кнопки далее
    //выстроить фрагменты
    //записывать значение куда то


    void initViews(final View rootView, final Bundle savedInstanceState)
    {
        binding = FragmentRegBaseBinding.bind(rootView);
        binding.button.setOnClickListener(this);



        RegStateHandler.getButtonState().observe(getViewLifecycleOwner(), new Observer<ButtonState>() {
            @Override
            public void onChanged(ButtonState buttonState) {
                if(buttonState instanceof ButtonState.ButtonOff)
                {binding.button.setEnabled(false);}
                else {
                    binding.button.setEnabled(true);
                    if(buttonState instanceof ButtonState.ButtonClick)
                    {
                         onClick(binding.button);
                    }
                }
            }
        });

    }

    void setTitle()
    {
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {

            actionBar.setTitle(getAcionBarTitleresource());
        }

    }
    public abstract int getAcionBarTitleresource();

    @Override
    public boolean onBackPressed() {
        final Fragment fragmentPanel = getChildFragmentManager()
                .findFragmentById(R.id.fragmentContainerViewRegBase);

        if (fragmentPanel instanceof BackPressable&&getChildFragmentManager().getBackStackEntryCount()>1) {

                if(RegStateHandler.getButtonState().getValue() instanceof ButtonState.ButtonOff)
                    RegStateHandler.getButtonState().setValue(new ButtonState.ButtonOn());

            return ((BackPressable) fragmentPanel).onBackPressed();


        }
     return false;
    }

    @Override
    public void onStartLoad(Boolean start) {
        if(!start) Toast.makeText(getContext(), R.string.networkerr,Toast.LENGTH_LONG).show();
        else
        {
            binding.progressBarLoad.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onComplete() {
        binding.progressBarLoad.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(getContext(), e.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(AuthResult authResult) {
        NavigationHelperRegistration.openSuccesFragment(getParentFragmentManager(),builder.getNextFragment());
    }
}
