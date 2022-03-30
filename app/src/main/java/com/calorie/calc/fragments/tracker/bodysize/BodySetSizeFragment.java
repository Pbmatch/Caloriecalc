package com.calorie.calc.fragments.tracker.bodysize;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.data.BodySizeItem;
import com.calorie.calc.databinding.FragmentBodySetsizeBinding;


public class BodySetSizeFragment extends Fragment {


    BodySizeItem selectedItem;
    FragmentBodySetsizeBinding binding;


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
        binding.imageView.setImageResource(selectedItem.getImageResource());
        binding.textViewTitle.setText(selectedItem.getTitle());
        binding.button.setEnabled(false);
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
                {binding.button.setEnabled(false);}
                else binding.button.setEnabled(true);
            }
        });
                binding.toolbarInclude.imageViewBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
    }
}