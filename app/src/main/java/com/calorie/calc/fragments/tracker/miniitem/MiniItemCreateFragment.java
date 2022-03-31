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

public abstract class MiniItemCreateFragment extends Fragment implements View.OnClickListener {


    protected Button button;
    protected TextView textViewUnit;
    protected EditText editText;
    protected EditText editTextName;
    protected ImageView imageView;
    protected ImageView toolbarImageViewBack;

    public MiniItemCreateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public abstract String getUnitText();

    public abstract boolean checkButtonEnable();

    public abstract boolean checkEnabled(String s);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.button);
        textViewUnit = view.findViewById(R.id.textViewUnit);
        editText = view.findViewById(R.id.editText);
        button = view.findViewById(R.id.button);
        button = view.findViewById(R.id.button);

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

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                button.setEnabled(checkEnabled(s.toString()));

            }
        });
        toolbarImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
    }

}