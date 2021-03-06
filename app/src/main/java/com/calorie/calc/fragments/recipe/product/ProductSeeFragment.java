package com.calorie.calc.fragments.recipe.product;

import static com.calorie.calc.utils.MeasureUtils.getIngrTitleString;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.R;
import com.calorie.calc.databinding.ListHeaderProductItemBinding;
import com.calorie.calc.fragments.recipe.RecipeListFragment;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Ingredient;
import com.calorie.calc.fragments.recipe.holders.recipeholders.Recipe;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.info_list.holder.IFragment;

import java.util.ArrayList;
import java.util.List;

public class ProductSeeFragment extends RecipeListFragment<Ingredient> implements IFragment {


  //  protected LinearLayout emptyLinearLayout;
    RecipeAndLinksItem recipeAndLinksItem;
    Recipe item;
    FragmentManager myfragmentManager;

    public ProductSeeFragment(RecipeAndLinksItem item, FragmentManager fragmentManager) {
        super();
        this.recipeAndLinksItem = item;
        this.item = item.getRecipe();
        this.myfragmentManager=fragmentManager;
    }
    @Override
    public FragmentManager getMyfragmentManager() {
        return myfragmentManager;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

     //  emptyLinearLayout=view.findViewById(R.id.empty_state_view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_see, container, false);
    }

    @Override
    public void startLoadData() {
        // super.startLoadData();
        /*ListHeaderProductItemBinding viewBinding = ListHeaderProductItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               List<RecipeAndLinksItem> list= RecipeState.getProductLiveData().getValue();
               for(RecipeAndLinksItem item:list)
               {
                   if(item.getRecipe().getLabel().equals(recipeAndLinksItem.getRecipe().getLabel()))
                   {
                       list.remove(item);
                       break;
                   }
               }
                infoListAdapter.setHeader(null);
                infoListAdapter.setInfoItemList(new ArrayList<>());

            }
        });*/

       /* viewBinding.textViewText.setText(getIngrTitleString(item.getYield()));
        viewBinding.textViewTitle.setText(item.getLabel());
        infoListAdapter.setHeader(viewBinding.getRoot());*/
        infoListAdapter.setProductEditType(true);
        infoListAdapter.setInfoItemList(getItemCheckedList());
     // emptyLinearLayout.setVisibility(View.GONE);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadMoreItems() {

    }

    List<Ingredient> getItemCheckedList() {
        List<Ingredient> list = new ArrayList<>();
        for (Ingredient ingItem : item.getIngredients()) {
            if(ingItem.isAddToProductChecked())
            {
                list.add(ingItem);
            }

        }
        return list;
    }

    @Override
    public void initViews(View rootView) {

    }

    @Override
    public ViewBinding getListHeader() {
        ListHeaderProductItemBinding viewBinding = ListHeaderProductItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<RecipeAndLinksItem> list= RecipeState.getProductLiveData().getValue();
                for(RecipeAndLinksItem item:list)
                {
                    if(item.getRecipe().getLabel().equals(recipeAndLinksItem.getRecipe().getLabel()))
                    {
                        list.remove(item);
                        break;
                    }
                }
                infoListAdapter.setHeader(null);
                infoListAdapter.setInfoItemList(new ArrayList<>());

            }
        });

        viewBinding.textViewText.setText(getIngrTitleString(item.getYield()));
        viewBinding.textViewTitle.setText(item.getLabel());
        infoListAdapter.setHeader(viewBinding.getRoot());

        return viewBinding;
    }


    @Override
    public  boolean isHorizontalItem() {
        return false;
    }

    @Override
    public int getLayoutManagerOrientation() {
        return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void reloadContent() {

    }
}