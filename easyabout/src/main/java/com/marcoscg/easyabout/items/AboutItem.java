package com.marcoscg.easyabout.items;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by @MarcosCGdev on 19/02/2018.
 */

public class AboutItem {

    private Drawable icon;
    private String title, subtitle;
    private View.OnClickListener onClickListener;
    private View.OnLongClickListener onLongClickListener;

    public AboutItem(String title, String subtitle, Drawable icon, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        this.icon = icon;
        this.title = title;
        this.subtitle = subtitle;
        this.onClickListener = onClickListener;
        this.onLongClickListener = onLongClickListener;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Drawable getIcon() {
        return icon;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public View.OnLongClickListener getOnLongClickListener() {
        return onLongClickListener;
    }
}
