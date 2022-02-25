package com.calorie.calc.fragments.recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDietBinding;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.PicassoHelper;


public class DietFragment extends Fragment implements BackPressable {


    DietType selectedItem;
    FragmentDietBinding binding;

    public DietFragment(DietType selectedItem) {
        this.selectedItem = selectedItem;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding=FragmentDietBinding.bind(view);
        initView();

    }
    void initView()
    {
        binding.textViewTitle.setText(getString(selectedItem.getTitleRes()));
        binding.textView5.setText(selectedItem.getTextRes());
        PicassoHelper.loadRecipe(selectedItem.getImageUrl()) .fit()
                .centerCrop().into(binding.imageView3);

    }

    @Override
    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }
}