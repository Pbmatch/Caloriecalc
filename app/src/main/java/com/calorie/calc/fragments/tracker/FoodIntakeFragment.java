package com.calorie.calc.fragments.tracker;

import static com.calorie.calc.utils.MeasureUtils.getEnergyString;
import static com.calorie.calc.utils.MeasureUtils.getStringFromDouble;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.ListFooterMealtimeItemBinding;
import com.calorie.calc.databinding.ListHeaderMealtimeItemBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinksItem;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.fragments.tracker.detailed.DetailedMealTimeFragment;
import com.calorie.calc.fragments.tracker.miniitem.exercise.DeleteDialog;
import com.calorie.calc.info_list.holder.IFragment;
import com.calorie.calc.utils.OnClickGesture;

import java.util.List;


public class FoodIntakeFragment extends ListFragment<RecipeAndLinksItem> implements IFragment {



 MealTime mealTime;

    FragmentManager myfragmentManager;
    ListFooterMealtimeItemBinding footerBinding;

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
        infoListAdapter.setUseTrackerVariant(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_intake, container, false);
    }
      double mealTimeRecomended=0;
    @Override
    protected ViewBinding getListFooter() {
        footerBinding = ListFooterMealtimeItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        mealTimeRecomended=mealTime.getEnercKcal().getQuantity();

        footerBinding.textViewRecommended.setText(getString(R.string.footer_recipe)+getEnergyString(mealTimeRecomended,getContext()));
        footerChange();
        return footerBinding;
    }
    void footerChange()
    {

        footerBinding.textView5.setVisibility(mealTime.getTotalEnergy() == 0 ? View.GONE : View.VISIBLE);

        if(mealTime.getTotalEnergy()<mealTimeRecomended)
        {footerBinding.imageView5.setVisibility(View.GONE);
            footerBinding.textView6.setVisibility(View.GONE);


        }
        else
        {
            footerBinding.imageView5.setVisibility(View.VISIBLE);
            footerBinding.textView6.setVisibility(View.VISIBLE);
            footerBinding.textView6.setText(getStringFromDouble(mealTime.getTotalEnergy()-mealTimeRecomended));
        }
        footerBinding.textView5.setText(getStringFromDouble(mealTime.getTotalEnergy()));
    }

    @Override
    public void startLoadData() {



       mealTime.getRecipeAndLinksItems().observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinksItem>>() {
           @Override
           public void onChanged(List<RecipeAndLinksItem> recipeAndLinksItems) {

               infoListAdapter.setInfoItemList(recipeAndLinksItems);
               footerChange();
           }
       });




        // super.startLoadData();
    /*   ListHeaderMealtimeItemBinding viewBinding = ListHeaderMealtimeItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.textViewTitle.setText(mealTime.getTitle());
        viewBinding.imageViewTitle.setImageDrawable( getContext().getDrawable(mealTime.getResourceImageView()));

      infoListAdapter.setHeader(viewBinding.getRoot());*/
        showListFooter(true);
    //    infoListAdapter.setInfoItemList(getItemCheckedList());
        // emptyLinearLayout.setVisibility(View.GONE);
    }

    @Override
    public void setListener() {
        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinksItem>() {
            @Override
            public void selected(RecipeAndLinksItem selectedItem) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new NavigationFragment(selectedItem));
            }

            @Override
            public void held(RecipeAndLinksItem selectedItem) {
                DeleteDialog dialog = new DeleteDialog(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mealTime.getRecipeAndLinksItems().removeItem(selectedItem);

                    }
                });
                dialog.show(getParentFragmentManager(),"");

                super.held(selectedItem);
            }
        });
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
    public ViewBinding getListHeader() {
        ListHeaderMealtimeItemBinding viewBinding = ListHeaderMealtimeItemBinding
                .inflate(getLayoutInflater(), itemsList, false);
        viewBinding.textViewTitle.setText(mealTime.getTitle());
        viewBinding.imageViewTitle.setImageDrawable( getContext().getDrawable(mealTime.getResourceImageView()));
        viewBinding.imageViewArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewBinding.textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new DetailedMealTimeFragment(mealTime));
            }
        });
        return viewBinding;
       /* infoListAdapter.setHeader(viewBinding.getRoot());;*/
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