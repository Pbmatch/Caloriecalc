package com.calorie.calc.fragments.recipe.scrolling;

import static com.calorie.calc.NavigationHelper.openAddProductFragment;
import static com.calorie.calc.utils.MeasureUtils.getIngrTitleString;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.databinding.ListFooterIngredientItemBinding;
import com.calorie.calc.databinding.ListHeaderIngredientItemBinding;
import com.calorie.calc.fragments.recipe.RecipeListFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Ingredient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Recipe;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.product.ProductAddFragment;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;


public class InnerDataFragment extends RecipeListFragment<Ingredient> {
    RecipeAndLinksItem recipeAndLinksItem;
    Recipe item;
    TextView textViewText;
    double countPortion;



    public InnerDataFragment(RecipeAndLinksItem item) {
        super();
        this.recipeAndLinksItem = item;
        this.item=item.getRecipe();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inner_data, container, false);
    }

    @Override
    public void startLoadData() {

    /*    ListHeaderIngredientItemBinding viewBinding = ListHeaderIngredientItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        countPortion = item.getYield();
        viewBinding.textViewText.setText(getIngrTitleString(countPortion));
        viewBinding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Ingredient> list = item.getIngredients();

                    double newYield = countPortion+1;
                    for(Ingredient ingredient:list)
                    {
                        ingredient.setQuantity(ingredient.getQuantity()/countPortion*newYield);

                    }
                countPortion = newYield;
                viewBinding.textViewText.setText(getIngrTitleString(countPortion));
                    infoListAdapter.notifyDataSetChanged();

            }
        });
        viewBinding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Ingredient> list = item.getIngredients();
                if(countPortion>1)
                {
                    double newYield = countPortion-1;

                    for(Ingredient ingredient:list)
                    {
                        ingredient.setQuantity(ingredient.getQuantity()/countPortion*newYield);

                    }
                    countPortion = newYield;
                    viewBinding.textViewText.setText(getIngrTitleString(countPortion));
                    infoListAdapter.notifyDataSetChanged();
                }
            }
        });
        infoListAdapter.setHeader(viewBinding.getRoot());*/


        ViewBinding viewBindingFooter = ListFooterIngredientItemBinding
                .inflate(getLayoutInflater(), itemsList, false);

        viewBindingFooter.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddProductFragment(getActivity().getSupportFragmentManager(),new ProductAddFragment(recipeAndLinksItem));
            }
        });
        infoListAdapter.setFooter(viewBindingFooter.getRoot());
        infoListAdapter.showFooter(true);

        infoListAdapter.setInfoItemList(item.getIngredients());
        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<Ingredient>() {
            @Override
            public void selected(Ingredient selectedItem) {

            }
        });
        StringBuilder ingredients= new StringBuilder();
        for(String str:item.getIngredientLines())
        {
            if(ingredients.length()>0)
            {
                ingredients.append("\n");
            }
            ingredients.append(str);
        }


         textViewText.setText(ingredients);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadMoreItems() {

    }

    @Override
    public boolean isHorizontalItem() {
        return false;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void initViews(View rootView) {
        textViewText = rootView.findViewById(R.id.textViewText);

    }

    @Override
    public ViewBinding getListHeader() {
        ListHeaderIngredientItemBinding viewBinding = ListHeaderIngredientItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        countPortion = item.getYield();
        viewBinding.textViewText.setText(getIngrTitleString(countPortion));
        viewBinding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Ingredient> list = item.getIngredients();

                double newYield = countPortion+1;
                for(Ingredient ingredient:list)
                {
                    ingredient.setQuantity(ingredient.getQuantity()/countPortion*newYield);

                }
                countPortion = newYield;
                viewBinding.textViewText.setText(getIngrTitleString(countPortion));
                infoListAdapter.notifyDataSetChanged();

            }
        });
        viewBinding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Ingredient> list = item.getIngredients();
                if(countPortion>1)
                {
                    double newYield = countPortion-1;

                    for(Ingredient ingredient:list)
                    {
                        ingredient.setQuantity(ingredient.getQuantity()/countPortion*newYield);

                    }
                    countPortion = newYield;
                    viewBinding.textViewText.setText(getIngrTitleString(countPortion));
                    infoListAdapter.notifyDataSetChanged();
                }
            }
        });
        infoListAdapter.setHeader(viewBinding.getRoot());

        return viewBinding;
    }


    @Override
    public void reloadContent() {

    }
}