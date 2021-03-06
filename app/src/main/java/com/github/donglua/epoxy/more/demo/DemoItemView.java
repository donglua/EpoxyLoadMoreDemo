package com.github.donglua.epoxy.more.demo;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;

@EpoxyModelClass(layout = R.layout.item_text)
public abstract class DemoItemView extends EpoxyModelWithHolder<DemoItemView.TextItemHolder> {

    @EpoxyAttribute String text;

    @Override
    public void bind(@NonNull TextItemHolder holder) {
        holder.textView.setText(text);
    }

    static class TextItemHolder extends EpoxyHolder {
        TextView textView;
        @Override
        protected void bindView(View itemView) {
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
