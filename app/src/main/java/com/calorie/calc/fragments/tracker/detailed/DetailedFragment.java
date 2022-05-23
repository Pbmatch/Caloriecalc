package com.calorie.calc.fragments.tracker.detailed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.calorie.calc.R;
import com.calorie.calc.databinding.FragmentDetailedBinding;
import com.calorie.calc.utils.BackPressable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class DetailedFragment extends Fragment implements BackPressable {

   private ViewPager2 viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView imageViewToolbarBack;
    private TextView toolbarTextViewTitle;
    private ImageView imageViewToolbarShare;
    private  FragmentDetailedBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detailed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentDetailedBinding.bind(view);

        viewPagerAdapter = new ViewPagerAdapter(this);
        imageViewToolbarBack =view.findViewById(R.id.toolbarImageViewBack);
        toolbarTextViewTitle =view.findViewById(R.id.toolbarTextViewTitle);
        imageViewToolbarShare  =view.findViewById(R.id.imageViewShare);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("OBJECT " + (position + 1))
        ).attach();
        imageViewToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    public class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // Return a NEW fragment instance in createFragment(int)
            Fragment fragment = new PagerMealTimeDetailedFragment();

            return fragment;
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

}