package com.github.donglua.epoxy.more.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class DemoActivity extends AppCompatActivity {
    private DemoEpoxyController demoEpoxyController;
    private LoadMoreRecyclerViewScrollListener loadMoreScrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        loadMoreScrollListener = new LoadMoreRecyclerViewScrollListener(layoutManager) {
            @Override
            public void fetchNextPage() {
                fetchNextPageByApi();
            }
        };
        recyclerView.addOnScrollListener(loadMoreScrollListener);
        demoEpoxyController = new DemoEpoxyController(loadMoreScrollListener);

        recyclerView.setAdapter(demoEpoxyController.getAdapter());

        demoEpoxyController.requestModelBuild();
    }

    private void fetchNextPageByApi() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) { }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        demoEpoxyController.nextPzge();

                        if (demoEpoxyController.getPage() > 4) {
                            loadMoreScrollListener.setHasMoreToLoad(false);
                        }
                    }
                });
            }
        }).start();
    }
}
