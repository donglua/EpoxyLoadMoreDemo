package com.github.donglua.epoxy.more.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        DemoEpoxyController demoEpoxyController = new DemoEpoxyController();
        recyclerView.setAdapter(demoEpoxyController.getAdapter());

        demoEpoxyController.requestModelBuild();
    }
}
