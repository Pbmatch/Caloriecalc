package com.calorie.calc.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public abstract class OnScrollBelowItemsListener extends RecyclerView.OnScrollListener {
    @Override
    public void onScrolled(final RecyclerView recyclerView, final int dx, final int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy > 0) {
            int pastVisibleItems = 0;
            final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

            final int visibleItemCount = layoutManager.getChildCount();
            final int totalItemCount = layoutManager.getItemCount();


            if (layoutManager instanceof LinearLayoutManager) {
                pastVisibleItems = ((LinearLayoutManager) layoutManager)
                        .findFirstVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                final int[] positions = ((StaggeredGridLayoutManager) layoutManager)
                        .findFirstVisibleItemPositions(null);
                if (positions != null && positions.length > 0) {
                    pastVisibleItems = positions[0];
                }
            }

            if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                onScrolledDown(recyclerView);
            }
        }
        if (dx > 0) {
            int pastVisibleItems = 0;
            final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

            final int visibleItemCount = layoutManager.getChildCount();
            final int totalItemCount = layoutManager.getItemCount();


            if (layoutManager instanceof LinearLayoutManager) {
                pastVisibleItems = ((LinearLayoutManager) layoutManager)
                        .findFirstVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                final int[] positions = ((StaggeredGridLayoutManager) layoutManager)
                        .findFirstVisibleItemPositions(null);
                if (positions != null && positions.length > 0) {
                    pastVisibleItems = positions[0];
                }
            }

            if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                onScrolledRight(recyclerView);
            }
        }

    }


    public abstract void onScrolledDown(RecyclerView recyclerView);
    public abstract void onScrolledRight(RecyclerView recyclerView);
}
