package com.github.donglua.epoxy.more.demo;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public abstract class LoadMoreRecyclerViewScrollListener extends EndlessRecyclerViewScrollListener implements LoadMoreListener {

    private boolean isHasMoreToLoad = true;

    public LoadMoreRecyclerViewScrollListener(LinearLayoutManager layoutManager) {
        super(layoutManager);
    }

    public LoadMoreRecyclerViewScrollListener(GridLayoutManager layoutManager) {
        super(layoutManager);
    }

    public LoadMoreRecyclerViewScrollListener(StaggeredGridLayoutManager layoutManager) {
        super(layoutManager);
    }

    @Override
    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
        if (hasMoreToLoad()) {
            fetchNextPage();
        }
    }

    @Override
    public boolean hasMoreToLoad() {
        return isHasMoreToLoad;
    }

    public void setHasMoreToLoad(boolean hasMore) {
        isHasMoreToLoad = hasMore;
    }
}
