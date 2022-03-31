package com.calorie.calc.fragments.tracker.bodysize;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.databinding.FragmentBodySetsizeBinding;

import java.util.Date;


public class BodySetSizeFragment extends Fragment {


   private BodySizeItem selectedItem;
    private FragmentBodySetsizeBinding binding;


    public BodySetSizeFragment( BodySizeItem selectedItem) {

        this.selectedItem = selectedItem;
    }

    public BodySetSizeFragment() {
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding= FragmentBodySetsizeBinding.bind(view);
        binding.imageView.setImageResource(selectedItem.getImageResourceBig());
        binding.textViewTitle.setText(selectedItem.getTitle());
        binding.button.setEnabled(false);
        binding.textViewUnit.setText(selectedItem.getUnit(getContext()));
        binding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE&&binding.editText.getText().toString().length()>0&&!binding.editText.getText().toString().equals("0")) {

                    binding.button.callOnClick();
                    handled = true;
                }
                return handled;
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedItem.setCountOfUnit(Integer.getInteger(binding.editText.getText().toString(),0));
                selectedItem.setDate(new Date());
                MainActivity.getUser().getBodySizeItemList().getValue().add(selectedItem);
                getParentFragmentManager().popBackStack();
            }
        });
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().equals("0"))
                {binding.button.setEnabled(false);

                }
                else binding.button.setEnabled(true);



            }
        });
                binding.toolbarInclude.toolbarImageViewBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       getParentFragmentManager().popBackStack();
                    }
                });
    }
}