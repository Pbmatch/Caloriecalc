package com.calorie.calc.fragments;

import static com.calorie.calc.NavigationHelper.openRecipeMainFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentRecipeBinding;
import com.calorie.calc.fragments.recipe.RecipeMainFragment;
import com.calorie.calc.fragments.recipe.RecipeState;
import com.calorie.calc.fragments.recipe.filter.FilterFragment;
import com.calorie.calc.fragments.recipe.liked.LikedFragment;
import com.calorie.calc.fragments.recipe.product.ProductContainerFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.VoiceToText;

import java.util.ArrayList;


public class RecipeFragment extends Fragment implements BackPressable, VoiceToText.VoiceToTextInterface {


    FragmentRecipeBinding binding;
    boolean editTextIsEmpty=true;
    VoiceToText voiceToText;

    public RecipeFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        openRecipeMainFragment(getChildFragmentManager(),new RecipeMainFragment());
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    @Override
    public void onStop() {

        super.onStop();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       //TODO Перенести инициализацию спискка продуктов
        if(RecipeState.getProductLiveData().getValue()==null)
        {RecipeState.getProductLiveData().setValue(new ArrayList<>());}
        voiceToText = new VoiceToText(this);
        View.OnClickListener onFilterClick = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openDietFragment(getParentFragment().getParentFragmentManager(),new FilterFragment());
            }
        });
        View.OnClickListener onSendClick = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFindClick();
            }
        });
        binding = FragmentRecipeBinding.bind(view);


        binding.editTextTextPersonName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                   if(!binding.editTextTextPersonName.getText().toString().isEmpty()) onFindClick();
                   else Toast.makeText(getContext(),"Введите текст",Toast.LENGTH_LONG).show();
                    handled = true;
                }
                return handled;
            }
        });
        binding.editTextTextPersonName.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(event.getAction() == MotionEvent.ACTION_UP) {
                if(event.getRawX() >= (binding.editTextTextPersonName.getRight() - binding.editTextTextPersonName.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                   if(!editTextIsEmpty)
                   {
                       binding.editTextTextPersonName.setText("");
                   }
                   else
                   {
                       voiceToText.start(getActivity(),getContext());
                   }

                    return true;
                }
            }
            return false;
        });
        binding.editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty())
                {
                    binding.editTextTextPersonName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.searching, 0, R.drawable.close, 0);
                    editTextIsEmpty=false;
                    binding.imageViewFilter.setImageResource(R.drawable.arrow_right);
                    binding.imageViewFilter.setOnClickListener(onSendClick);

                }
                else{
                    binding.editTextTextPersonName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.searching, 0, R.drawable.mic, 0);
                    editTextIsEmpty=true;
                    binding.imageViewFilter.setImageResource(R.drawable.ic_filter);
                    binding.imageViewFilter.setOnClickListener(onFilterClick);

            }
        }
        }
            );
        binding.imageViewFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openDietFragment(getParentFragment().getParentFragmentManager(),new LikedFragment(RecipeState.getRecipeAndLinksMutableLiveData()));
            }
        });
        binding.imageViewShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openDietFragment(getParentFragment().getParentFragmentManager(),new ProductContainerFragment());
            }
        });





    }
    void onFindClick()
    {}

    @Override
    public boolean onBackPressed() {
        final Fragment fragmentPanel = getChildFragmentManager()
                .findFragmentById(R.id.recipe_container);
        if (fragmentPanel instanceof BackPressable) {

            ((BackPressable) fragmentPanel).onBackPressed();
            return true;
        }
        return false;
    }

    @Override
    public void getText(String result) {
        binding.editTextTextPersonName.setText(result);
    }
}