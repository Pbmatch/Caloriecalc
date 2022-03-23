package com.calorie.calc.fragments.recipe;

import static com.calorie.calc.NavigationHelper.showRecipeMainHorizFragment;
import static com.calorie.calc.utils.MeasureUtils.getDishCount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.edamam.network.RecipeRecipient;
import com.calorie.calc.fragments.recipe.holders.RecipeSearch;
import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.fragments.recipe.scrolling.NavigationFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;

import java.util.ArrayList;
import java.util.List;


public class RecipeVerticalFragment extends RecipeListFragment<RecipeAndLinks> implements BackPressable {

    protected LinearLayout emptyLinearLayout;
    protected ImageView emptyImageView;
    protected  TextView emptyTextView;

    protected SwipeRefreshLayout swipeRefreshLayout;
    protected   TextView textView;
    protected NestedScrollView scroll;

    public RecipeVerticalFragment(MutableLiveData<List<RecipeSearch>> recipeSearch, RecipeType type)
    {

        super(recipeSearch,type);
    }

    public RecipeVerticalFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (recipeRecipient == null)
            recipeRecipient = new RecipeRecipient(getContext(), recipeSearch, type);
        swipeRefreshLayout = view.findViewById(R.id.swipe);
        textView=view.findViewById(R.id.textViewText);
        emptyLinearLayout =view.findViewById(R.id.empty_state_view);
        emptyImageView =view.findViewById(R.id.empty_state_desc);
        emptyTextView =view.findViewById(R.id.empty_state_text);
        swipeRefreshLayout.setOnRefreshListener(this::reloadContent);
        emptyLinearLayout.setVisibility(View.GONE);
        emptyTextView.setText(R.string.filter_empty);
         scroll  = (NestedScrollView) view.findViewById(R.id.rvToList);

        if (scroll  != null) {

            scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    View view = (View) scroll.getChildAt(scroll.getChildCount() - 1);

                    int diff = (view.getBottom() - (scroll.getHeight() + scroll
                            .getScrollY()));

                    if (diff == 0) {
                        onScrollToBottom();
                    }
                }
            });
        }


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recipe_inner_vertical, container, false);
    }

    @Override
    public void startLoadData() {
       // infoListAdapter.setInfoItemList(recipeState.getValue());
    }

    @Override
    public  void setListener() {

         recipeSearch.observe(getViewLifecycleOwner(),new Observer<List<RecipeSearch>>() {
             @Override
             public void onChanged(List<RecipeSearch> listRecipeSearch) {

                 List<RecipeAndLinks> recipeAndLinks = new ArrayList<>();
                 for (RecipeSearch itemRec : listRecipeSearch) {
                     recipeAndLinks.addAll(itemRec.getHits());
                 }


                 System.out.println(" public void onChangedVert" + recipeAndLinks.size());
                 if(!recipeRecipient.isReloadContent()){
                     for (RecipeAndLinks item:recipeAndLinks)
                     {

                         if(!infoListAdapter.getItemsList().contains(item))
                         {infoListAdapter.addItemToItemList(item,infoListAdapter.getItemsList().size());}
                     }
                 }
                 else
                 {
                     infoListAdapter.setInfoItemList(recipeAndLinks);
                     recipeRecipient.setReloadContent(false);
                 }

                 isLoading.set(false);

                 if (listRecipeSearch.size() > 0){
                     RecipeSearch item = listRecipeSearch.get(listRecipeSearch.size()-1);
                 if (item.getCount() == 0) {
                     emptyLinearLayout.setVisibility(View.VISIBLE);
                 } else {
                     emptyLinearLayout.setVisibility(View.GONE);
                 }

                 textView.setText(getDishCount(getContext(), item.getCount()));
             }

             }


    });

        infoListAdapter.setOnItemSelectedListener(new OnClickGesture<RecipeAndLinks>() {
            @Override
            public void selected(RecipeAndLinks selectedItem) {
                 NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(), new NavigationFragment(selectedItem));
            }
        });
    }


    @Override
    public boolean isHorizontalItem() {
        return false;
    }

    @Override
    public  int getLayoutManagerOrientation() {
       return LinearLayoutManager.VERTICAL;
    }

    @Override
    public void initViews(View rootView) {


    }

    public boolean onBackPressed() {
        if(!isHidden()){
        System.out.println(" boolean onBackPressed()Vertical");
        showRecipeMainHorizFragment(getParentFragmentManager());
       // getParentFragmentManager().popBackStack();
        return true;}
        else return false;
    }
    @Override
    public void loadMoreItems() {
        if(!isLoading.get())
        {
            System.out.println("loadMoreItems()Vertical");
            recipeRecipient.getRecipe(false);
            showListFooter(true);
            isLoading.set(true);
        }

    }

    @Override
    public void reloadContent() {
        System.out.println("reloadContent()Vertical");
        recipeRecipient.setReloadContent(true);
        recipeRecipient.getRecipe(true);
        swipeRefreshLayout.setRefreshing(false);
    }
}