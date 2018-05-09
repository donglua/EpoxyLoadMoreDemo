package com.github.donglua.epoxy.more.demo;

public interface LoadMoreListener {

    boolean hasMoreToLoad();

    void fetchNextPage();
}
