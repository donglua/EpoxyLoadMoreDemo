package com.github.donglua.epoxy.more.demo;

import com.airbnb.epoxy.EpoxyController;

public class DemoEpoxyController extends EpoxyController {
    @Override
    protected void buildModels() {
        int count = 0;
        for (int i = 0; i < 20; i++) {
            ++count;
            new DemoItemView_().id(i).text("Item " + count).addTo(this);
        }
    }
}
