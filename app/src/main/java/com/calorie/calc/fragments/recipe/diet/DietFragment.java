package com.calorie.calc.fragments.recipe.diet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDietBinding;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.info_list.InfoListAdapter;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.PicassoHelper;


public class DietFragment extends Fragment implements BackPressable {


    DietType selectedItem;
    FragmentDietBinding binding;
    InfoListAdapter<String> adapter;
    RecyclerView itemsList;

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
        initView(view);

    }
    void initView(View rootView)
    {
        if(adapter==null)
        {adapter = new InfoListAdapter<>(getContext());}
        binding.textViewTitle.setText(getString(selectedItem.getTitleRes()));
        binding.textViewText.setText(selectedItem.getTextRes());
        binding.textViewRecview.setText("Преимущества кето диеты:");
        PicassoHelper.loadRecipe(selectedItem.getImageUrl()) .fit()
                .centerCrop().into(binding.imageView3);
        itemsList=rootView.findViewById(R.id.rec_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        itemsList.setLayoutManager(layoutManager);

        itemsList.setAdapter(adapter);
        adapter.setInfoItemList(selectedItem.getCheckboxText());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DietType.refreshSelected();
                selectedItem.setSelect(true);
                RecipeState.getDietType().setValue(selectedItem);
                onBackPressed();
            }
        });

    }

    @Override
    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }
}