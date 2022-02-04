package com.calorie.calc.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import com.calorie.calc.BuildConfig;
import com.calorie.calc.R;
import com.calorie.calc.User;
import com.calorie.calc.databinding.FragmentRegBaseBinding;
import com.calorie.calc.signup.regfragments.Builder;
import com.calorie.calc.signup.regfragments.GoalFragment1;
import com.calorie.calc.signup.regfragments.NavigationHelperReg;
import com.calorie.calc.signup.regfragments.RegBaseFragment;
import com.calorie.calc.signup.state.ButtonState;
import com.calorie.calc.signup.state.RegFragmentState;
import com.calorie.calc.signup.state.RegStateHandler;
import com.calorie.calc.utils.BackPressable;


public abstract class BaseFragment extends Fragment implements BackPressable, View.OnClickListener {


    FragmentRegBaseBinding binding;
    FragmentBuilder builder;

    public BaseFragment() {
    }

   /* public static BaseFragment newInstance() {
        BaseFragment fragment = new BaseFragment();
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
        NavigationHelperReg.openNextFragment(getChildFragmentManager(),builder.getNextFragment());
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
                else {binding.button.setEnabled(true);}
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


}
