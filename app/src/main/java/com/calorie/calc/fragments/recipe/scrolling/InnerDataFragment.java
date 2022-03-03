package com.calorie.calc.fragments.recipe.scrolling;

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
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;


public class InnerDataFragment extends RecipeListFragment<Ingredient> {
    RecipeAndLinks recipeAndLinks;
    Recipe item;
    TextView textViewText;



    public InnerDataFragment(RecipeAndLinks item) {
        super();
        this.recipeAndLinks = item;
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

        ListHeaderIngredientItemBinding viewBinding = ListHeaderIngredientItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.textViewText.setText(getIngrTitleString(item.getYield()));
        infoListAdapter.setHeader(viewBinding.getRoot());


        ViewBinding viewBindingFooter = ListFooterIngredientItemBinding
                .inflate(getLayoutInflater(), itemsList, false);

        infoListAdapter.setFooter(viewBindingFooter.getRoot());
        infoListAdapter.showFooter(true);

        infoListAdapter.setInfoItemList(item.getIngredients());
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


}