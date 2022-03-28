package com.calorie.calc.fragments.tracker;

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
import com.calorie.calc.databinding.ListFooterMealtimeItemBinding;
import com.calorie.calc.databinding.ListHeaderMealtimeItemBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.info_list.holder.IFragment;


public class FoodIntakeFragment extends ListFragment<RecipeAndLinksItem> implements IFragment {



 MealTime mealTime;

    FragmentManager myfragmentManager;


   public FoodIntakeFragment(  FragmentManager fragmentManager) {
      super();
      this.myfragmentManager=fragmentManager;
   }

    public FoodIntakeFragment(  FragmentManager fragmentManager,MealTime mealTime) {
        super();
       this.mealTime=mealTime;

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
        return inflater.inflate(R.layout.fragment_food_intake, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {
        return ListFooterMealtimeItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
    }

    @Override
    public void startLoadData() {
        // super.startLoadData();
       ListHeaderMealtimeItemBinding viewBinding = ListHeaderMealtimeItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.textViewTitle.setText(mealTime.getTitle());
        viewBinding.imageViewTitle.setImageDrawable( getContext().getDrawable(mealTime.getResourceImageView()));

      infoListAdapter.setHeader(viewBinding.getRoot());
        showListFooter(true);
    //    infoListAdapter.setInfoItemList(getItemCheckedList());
        // emptyLinearLayout.setVisibility(View.GONE);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadMoreItems() {

    }

   /* List<Ingredient> getItemCheckedList() {
        List<Ingredient> list = new ArrayList<>();
        for (Ingredient ingItem : item.getIngredients()) {
            if(ingItem.isAddToProductChecked())
            {
                list.add(ingItem);
            }

        }
        return list;
    }*/

    @Override
    public void initViews(View rootView) {

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