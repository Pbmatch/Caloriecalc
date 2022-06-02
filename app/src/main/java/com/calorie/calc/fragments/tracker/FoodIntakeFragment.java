package com.calorie.calc.fragments.tracker;

import static com.calorie.calc.utils.Config.ROTATION_ANIMATE_CONTROLS_DURATION;
import static com.calorie.calc.utils.MeasureUtils.getEnergyString;
import static com.calorie.calc.utils.MeasureUtils.getGramNutrientString;
import static com.calorie.calc.utils.MeasureUtils.getStringFromDouble;
import static com.calorie.calc.utils.ViewUtils.animateRotation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.ListFooterMealtimeReachItemBinding;
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
    FooterHolder footerHolder;


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
        footerHolder=new FooterHolder();
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
        if(mealTime.getRecipeAndLinksItems().getValue()==null||mealTime.getRecipeAndLinksItems().getValue().size()==0)
       {
           return footerHolder.getReachListFooter(false);}
      else
      {

           return footerHolder.getReachListFooter(true);
      }

    }

    @Override
    public void startLoadData() {



       mealTime.getRecipeAndLinksItems().observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinksItem>>() {
           @Override
           public void onChanged(List<RecipeAndLinksItem> recipeAndLinksItems) {
               System.out.println("getReachListFooterOnChanged");
               infoListAdapter.setInfoItemList(recipeAndLinksItems);

               if (recipeAndLinksItems.size()>0) {
                   footerHolder.fullFooterChange(true);
                  // footerHolder.reachFooterBinding.linear.setVisibility(View.VISIBLE);
               } else {
                   footerHolder.fullFooterChange(false);
                  // footerHolder.reachFooterBinding.linear.setVisibility(View.GONE);
               } //footerHolder.fullFooterChange(true);

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
              int rotate;
            if(infoListAdapter.isRoll())
            {
                infoListAdapter.setRoll(false);
               rotate=0;
            }
            else
            {
                infoListAdapter.setRoll(true);
                rotate=180;
            }
                animateRotation(viewBinding.imageViewArrow,
                        ROTATION_ANIMATE_CONTROLS_DURATION, rotate);
            infoListAdapter.notifyDataSetChanged();
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
    class FooterHolder
    {


        private  ListFooterMealtimeReachItemBinding reachFooterBinding;


        protected ViewBinding getReachListFooter(boolean visible) {

            reachFooterBinding = ListFooterMealtimeReachItemBinding
                    .inflate(getLayoutInflater(), itemsList, false);
            mealTimeRecomended=mealTime.getEnercKcal().getQuantity();
            reachFooterBinding.textViewRecommended.setText(getString(R.string.footer_recipe)+getEnergyString(mealTimeRecomended,getContext()));
            fullFooterChange(  visible);
            return reachFooterBinding;

        }
      private   void liteFooterChange(ImageView imageView, TextView textViewCount, TextView textViewExtra)
        {

             textViewCount.setVisibility(mealTime.getTotalEnergy() == 0 ? View.GONE : View.VISIBLE);

            if(mealTime.getTotalEnergy()<mealTimeRecomended)
            { imageView.setVisibility(View.GONE);
                 textViewExtra.setVisibility(View.GONE);


            }
            else
            {
                 imageView.setVisibility(View.VISIBLE);
                 textViewExtra.setVisibility(View.VISIBLE);
                 textViewExtra.setText(getStringFromDouble(mealTime.getTotalEnergy()-mealTimeRecomended));
            }
             textViewCount.setText(getStringFromDouble(mealTime.getTotalEnergy()));
        }
        protected   void fullFooterChange(boolean visible)
        {
            liteFooterChange(reachFooterBinding.imageView5,reachFooterBinding.textViewCount,reachFooterBinding.textViewExtra);
            if (visible) reachFooterBinding.linear.setVisibility(View.VISIBLE);
            else reachFooterBinding.linear.setVisibility(View.GONE);

            reachFooterBinding.textViewProteinCount.setText(getGramNutrientString(mealTime.getTotalProcNt(),getContext()));
            reachFooterBinding.textViewFatCount.setText(getGramNutrientString(mealTime.getTotalFat(),getContext()));
            reachFooterBinding.textViewCarbCount.setText(getGramNutrientString(mealTime.getTotalChockDf(),getContext()));
        }


    }
}