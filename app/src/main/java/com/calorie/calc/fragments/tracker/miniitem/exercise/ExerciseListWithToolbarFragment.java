package com.calorie.calc.fragments.tracker.miniitem.exercise;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.calorie.calc.MainActivity;
import com.calorie.calc.NavigationHelper;
import com.calorie.calc.R;
import com.calorie.calc.data.ExerciseItem;
import com.calorie.calc.databinding.ListFooterActivFullItemBinding;
import com.calorie.calc.databinding.ListHeaderExerciseItemBinding;
import com.calorie.calc.fragments.recipe.ListFragment;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.OnClickGesture;

import java.text.SimpleDateFormat;
import java.util.List;


public class ExerciseListWithToolbarFragment  extends ListFragment<ExerciseItem> implements Observer<List<ExerciseItem>>, BackPressable {

    Button button;
    TextView textViewToolbarTitle;
    TextView textViewToolbarText;
    ImageView imageviewToolbarBack;
    ListFooterActivFullItemBinding footerBinding;
    ListHeaderExerciseItemBinding headerBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracer_list, container, false);
    }

    @Override
    protected ViewBinding getListFooter() {

        footerBinding = ListFooterActivFullItemBinding.inflate(LayoutInflater.from(getContext()), itemsList, false);
        return footerBinding;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void startLoadData() {
        setVisible(true);
        showListFooter(true);
     MainActivity.getUser().getExerciseItemList().observe(getViewLifecycleOwner(), this);
    }

    @Override
    public void setListener() {
     infoListAdapter.setOnItemSelectedListener(new OnClickGesture<ExerciseItem>() {
      @Override
      public void selected(ExerciseItem selectedItem) {
          DeleteDialog dialog = new DeleteDialog(new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  MainActivity.getUser().getExerciseItemList().removeItem(selectedItem);
                  infoListAdapter.deleteItemFromItemList(selectedItem);
              }
          });
          dialog.show(getParentFragmentManager(),"");
      }
     });
    }

    @Override
    public void initViews(View rootView) {
        textViewToolbarText=rootView.findViewById(R.id.toolbarTextViewText);
        textViewToolbarTitle=  rootView.findViewById(R.id.toolbarTextViewTitle);
        imageviewToolbarBack=rootView.findViewById(R.id.toolbarImageViewBack);
        button=rootView.findViewById(R.id.button);
        textViewToolbarTitle.setText(R.string.exercise);
        SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MMMM.yyyy");
        textViewToolbarText.setText( fmtOut.format(MainActivity.getUser().getDate()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new ExerciseListFragment(false));
            }
        });
        imageviewToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });



    }

 @Override
 public ViewBinding getListHeader() {
 headerBinding =   ListHeaderExerciseItemBinding
             .inflate(getLayoutInflater(), itemsList, false);
     headerBinding.textViewAdd.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             NavigationHelper.openNavigationFragment(getActivity().getSupportFragmentManager(),new ExerciseListFragment(false));
         }
     });
    return headerBinding;
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
    public void onChanged(List<ExerciseItem> exerciseItems) {
     setVisible(exerciseItems.size()==0);
      infoListAdapter.setInfoItemList(exerciseItems);
     double energy=0;
     for(ExerciseItem item:exerciseItems)
     {
         energy=energy+item.getEnergy();

     }
     footerBinding.textViewCount.setText(String.valueOf(energy));
    }

    void setVisible(Boolean visible)
    {
        if(visible)
        {   headerBinding.textViewAdd.setVisibility(View.VISIBLE);

            footerBinding.textViewCount.setVisibility(View.GONE);
        }
        else
        {headerBinding.textViewAdd.setVisibility(View.GONE);

            footerBinding.textViewCount.setVisibility(View.VISIBLE);
        }

    }


 @Override
 public void loadMoreItems() {

 }
    @Override
    public void reloadContent() {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}