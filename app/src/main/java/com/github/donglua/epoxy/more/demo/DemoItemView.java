package com.github.donglua.epoxy.more.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;

@EpoxyModelClass(layout = R.layout.item_text)
public abstract class DemoItemView extends EpoxyModelWithHolder<DemoItemView.ImageButtonHolder> {

    @EpoxyAttribute String text;

    @Override
    public void bind(@NonNull ImageButtonHolder holder) {
        holder.textView.setText(text);
    }

    static class ImageButtonHolder extends EpoxyHolder {
        TextView textView;
        @Override
        protected void bindView(View itemView) {
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
