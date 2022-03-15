package com.calorie.calc.fragments.recipe;

import static com.calorie.calc.utils.MeasureUtils.getDishCount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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


public class RecipeVerticalFragment extends RecipeListFragment<RecipeAndLinks> implements BackPressable {

   private SwipeRefreshLayout swipeRefreshLayout;
    private  TextView textView;
    boolean moreItems = false;
    public RecipeVerticalFragment(MutableLiveData<RecipeSearch> recipeSearch,RecipeType type)
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
    public void loadMoreItems() {
        if(!isLoading.get())
        {
            recipeRecipient.getRecipe();
            isLoading.set(true);
        }
       // recipeRecipient.getRecipe(recipeSearch.getValue().getLinks().getNext().getHref());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (recipeRecipient == null)
            recipeRecipient = new RecipeRecipient(getContext(), recipeSearch, type);
        swipeRefreshLayout = view.findViewById(R.id.swipe);
        textView=view.findViewById(R.id.textViewText);
        swipeRefreshLayout.setOnRefreshListener(this::reloadContent);

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
        recipeSearch.observe(getViewLifecycleOwner(), new Observer<RecipeSearch>() {
            @Override
            public void onChanged(RecipeSearch recipeSearch) {

                textView.setText(getDishCount(getContext(),recipeSearch.getCount()));
                if(isLoading.get())
                {
                    infoListAdapter.addInfoItemList(recipeSearch.getHits());
                    isLoading.set(false);
                }
                else
                infoListAdapter.setInfoItemList(recipeSearch.getHits());


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
        getParentFragmentManager().popBackStack();
        return true;
    }

    @Override
    public void reloadContent() {
        recipeRecipient.getRecipe();
        swipeRefreshLayout.setRefreshing(false);
    }
}