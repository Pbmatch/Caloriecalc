package com.calorie.calc.fragments.recipe.product;

import static com.calorie.calc.utils.MeasureUtils.getIngrTitleString;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.databinding.ListHeaderProductItemBinding;
import com.calorie.calc.fragments.recipe.ListEmptyAndToolbar;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Ingredient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Recipe;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.utils.BackPressable;

import java.util.List;


public class ProductAddFragment extends ListEmptyAndToolbar<Ingredient> implements BackPressable {


    Button addProduct;
    RecipeAndLinksItem recipeAndLinksItem;
    Recipe item;
    public ProductAddFragment(RecipeAndLinksItem item) {
        super();
        this.recipeAndLinksItem = item;
        this.item=item.getRecipe();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        addProduct=view.findViewById(R.id.buttonAdd);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_add, container, false);
    }

    @Override
    public void startLoadData() {
       // super.startLoadData();
        ListHeaderProductItemBinding viewBinding = ListHeaderProductItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.imageViewDelete.setVisibility(View.GONE);
        viewBinding.textViewText.setText(getIngrTitleString(item.getYield()));
        viewBinding.textViewTitle.setText(item.getLabel());
        infoListAdapter.setHeader(viewBinding.getRoot());
        infoListAdapter.setProductFragment(true);
        infoListAdapter.setInfoItemList(item.getIngredients());
        emptyLinearLayout.setVisibility(View.GONE);
    }

    @Override
    public void setListener() {
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<RecipeAndLinksItem> list = RecipeState.getProductLiveData().getValue();
                list.add(recipeAndLinksItem);
                getParentFragmentManager().popBackStack();

              //  RecipeState.getProductLiveData().setValue(list);
            }
        });
    }

    @Override
    public void loadMoreItems() {

    }

    @Override
    public ViewBinding getListHeader() {
        return null;
    }

    @Override
    public void setToolbar() {
        toolbarText.setText(R.string.product_toolbar_add_title);
         toolbarImageViewRight.setVisibility(View.GONE);
        toolbarImageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public void reloadContent() {

    }

    @Override
    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return true;
    }
}