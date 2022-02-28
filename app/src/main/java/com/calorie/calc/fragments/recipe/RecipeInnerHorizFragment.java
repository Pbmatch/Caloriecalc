package com.calorie.calc.fragments.recipe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.edamam.holders.recipeholders.RecipeAndLinks;
import com.calorie.calc.info_list.InfoListAdapter;

import java.util.List;


public abstract class RecipeInnerHorizFragment<T> extends Fragment {


    protected   RecyclerView itemsList;

    TextView textViewTitle;
    TextView textViewText;
    protected InfoListAdapter<T> infoListAdapter;
    protected RecipeMainType type;
    private String textTitle;

    protected MutableLiveData<List<RecipeAndLinks>> recipeState;

    public RecipeInnerHorizFragment(RecipeMainType type) {

        this.type=type;
        this.recipeState = type.getRecipeState();
    }

    public RecipeInnerHorizFragment(MutableLiveData<List<RecipeAndLinks>> recipeState) {
        this.recipeState = recipeState;
    }

    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);
        if(type!=null)
        this.textTitle = getString(type.getTitleRecource());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (infoListAdapter == null) {
            infoListAdapter = new InfoListAdapter<T>(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recipe_inner_horiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initList(view);
        setListener();
        startLoadData();

    }
   abstract void startLoadData();

    abstract void setListener();


    @Override
    public void onResume() {

        super.onResume();



    }
    abstract boolean isHorizontalItem();
    abstract int getLayoutManagerOrientation();

    void initViews(View rootView)
    {

        textViewTitle = rootView.findViewById(R.id.recipe_inner_textViewTitle);
        textViewText = rootView.findViewById(R.id.recipe_inner_textViewText);
        textViewTitle.setText(textTitle);
        textViewText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            NavigationHelper.openRecipeVerticalMainFragment(getParentFragment().getParentFragmentManager(),new RecipeInnerVerticalFragment(recipeState));
        }
    });

    }


    void initList(View rootView)
    {

        itemsList=rootView.findViewById(R.id.rec_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(getLayoutManagerOrientation());
        itemsList.setLayoutManager(layoutManager);
            infoListAdapter.setUseRecipeHorizontalItem(isHorizontalItem());
            itemsList.setAdapter(infoListAdapter);






    }
}