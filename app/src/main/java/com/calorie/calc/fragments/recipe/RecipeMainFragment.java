package com.calorie.calc.fragments.recipe;

import static com.calorie.calc.fragments.recipe.RecipeMainType.DIET_PLAN;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.R;
import com.calorie.calc.RecipeStateAdapter;
import com.calorie.calc.databinding.FragmentRecipeMainBinding;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoListAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RecipeMainFragment extends Fragment {


    RecyclerView itemsList;
    FragmentRecipeMainBinding binding;
    protected InfoListAdapter infoListAdapter;
    public RecipeMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (infoListAdapter == null) {
            infoListAdapter = new InfoListAdapter(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recipe_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding= FragmentRecipeMainBinding.bind(view);
        initViews();
    }

    @Override
    public void onResume() {

        super.onResume();
        System.out.println("onResume" );
        RecipeStateAdapter.getRecipeState().observe(getViewLifecycleOwner(), new Observer<List<RecipeAndLinks>>() {
            @Override
            public void onChanged(List<RecipeAndLinks> recipeAndLinks) {
                System.out.println("onChanged"+recipeAndLinks.size());
                infoListAdapter.addInfoItemList(recipeAndLinks);
            }
        });

    }

    void initViews()
    {
        Map<String, String> param = new HashMap<>();
        param.put("type", "public");
        param.put("q", "chicken");
     DIET_PLAN.build(param);

    }

}
enum RecipeMainType
{
    DIET_PLAN( R.string.recipe_1,"",R.id.container_plan),
    POPULAR_RECIPE(R.string.recipe_2,"",R.id.container_popular),
    ADDED_RECIPE(R.string.recipe_3,"",R.id.container_added),
    BREAKFAST(R.string.recipe_4,"Breakfast",R.id.container_breakfast),
    DINNER(R.string.recipe_5,"Dinner",R.id.container_dinner),
    SNACKS(R.string.recipe_6,"Snack",R.id.container_snack);


    String mealType;
    int titleRecource;
    int container;
    MutableLiveData<List<RecipeAndLinks>> recipeState = new MutableLiveData<>();
    Map<String,String> params;

   RecipeMainType(int title,String mealType,int container) {
        this.titleRecource = title;
        this.mealType=mealType;
        this.container=container;

    }

    public int getTitleRecource() {
        return titleRecource;
    }

    public Map<String, String> getParams() {
        return params;
    }
    public RecipeMainType build(Map<String, String> params) {
        this.params = params;
        Map<String, String> param = new HashMap<>();
        param.put("type", "public");
        param.put("q", "");
        if(!mealType.isEmpty())
        param.put("mealType", mealType);
        return this;
    }
    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public MutableLiveData<List<RecipeAndLinks>> getRecipeState() {
        return recipeState;
    }

    public void setRecipeState(MutableLiveData<List<RecipeAndLinks>> recipeState) {
        this.recipeState = recipeState;
    }
}