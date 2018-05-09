package com.github.donglua.epoxy.more.demo;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyModel;

public class DemoEpoxyController extends EpoxyController {

    private int page = 1;

    private LoadMoreRecyclerViewScrollListener listener;

    @AutoModel LoadingView_ loadingView;

    public DemoEpoxyController(LoadMoreRecyclerViewScrollListener listener) {
        this.listener = listener;
    }

    @Override
    protected void buildModels() {
        int count = 0;
        for (int i = 0; i < page; i++) {

            for (int j = 0; j < 20; j++) {
                ++count;
                new DemoItemView_().id(count).text("Item " + count).addTo(this);
            }

        }

        loadingView.addIf(new EpoxyModel.AddPredicate() {
            @Override
            public boolean addIf() {
                return listener.hasMoreToLoad();
            }
        }, this);
    }

    void nextPzge() {
        ++page;
        requestModelBuild();
    }

    public int getPage() {
        return page;
    }
}
