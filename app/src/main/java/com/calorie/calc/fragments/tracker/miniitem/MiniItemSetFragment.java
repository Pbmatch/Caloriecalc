package com.calorie.calc.fragments.tracker.miniitem;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.data.MiniItem;
import com.calorie.calc.utils.BackPressable;

public abstract class MiniItemSetFragment<T extends MiniItem> extends Fragment implements View.OnClickListener, BackPressable {


    protected T selectedItem;
    protected ImageView imageView;
    protected Button button;
    protected TextView textViewTitle;
    protected TextView textViewUnit;
    protected ImageView toolbarImageViewBack;
    protected EditText editText;


    public MiniItemSetFragment(T selectedItem) {

        this.selectedItem = selectedItem;
    }

    public MiniItemSetFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body_setsize, container, false);
    }

    public abstract String getTextForButton();

    public abstract void setDataToUser();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        button = view.findViewById(R.id.button);
        textViewUnit = view.findViewById(R.id.textViewUnit);
        editText = view.findViewById(R.id.editText);
        toolbarImageViewBack = view.findViewById(R.id.toolbarImageViewBack);
        imageView.setImageResource(selectedItem.getImageResourceBig());
        textViewTitle.setText(selectedItem.getTitle());
        button.setEnabled(false);
        button.setText(getTextForButton());
        textViewUnit.setText(selectedItem.getUnit(getContext()));

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE && editText.getText().toString().length() > 0 && !editText.getText().toString().equals("0")) {

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
                button.setEnabled(!s.toString().equals("0"));


            }
        });
        toolbarImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        if( getParentFragmentManager().getBackStackEntryCount()!=0)
        {getParentFragmentManager().popBackStack();
            return true;}
        return false;
    }
}