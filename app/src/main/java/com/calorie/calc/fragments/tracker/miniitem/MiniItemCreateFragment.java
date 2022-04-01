package com.calorie.calc.fragments.tracker.miniitem;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.google.android.material.appbar.AppBarLayout;

public abstract class MiniItemCreateFragment extends Fragment implements View.OnClickListener {


    protected Button button;
    protected TextView textViewUnit;
    protected EditText editText;
    protected EditText editTextName;
    protected ImageView imageView;
    protected ImageView toolbarImageViewBack;
    protected TextWatcher textWatcher;
    AppBarLayout app_bar;
    public MiniItemCreateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public abstract String getUnitText();

    public abstract boolean checkButtonEnable();



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextName= view.findViewById(R.id.editTextName);
        button = view.findViewById(R.id.button);
        imageView = view.findViewById(R.id.imageView);
        textViewUnit = view.findViewById(R.id.textViewUnit);
        editText = view.findViewById(R.id.editText);
        button = view.findViewById(R.id.button);
        app_bar = view.findViewById(R.id.app_bar);

        toolbarImageViewBack= view.findViewById(R.id.toolbarImageViewBack);
        button.setEnabled(false);
        textViewUnit.setText(getUnitText());
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE && checkButtonEnable()
                ) {

                    button.callOnClick();
                    handled = true;
                }
                return handled;
            }
        });
        button.setOnClickListener(this);
        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(app_bar!=null)
                app_bar.setExpanded(false);
               // imageView.setImageResource(R.drawable.measurements);
                button.setEnabled(checkButtonEnable());

            }
        };
        editText.addTextChangedListener(textWatcher);
        editTextName.addTextChangedListener(textWatcher);
        toolbarImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
    }

}