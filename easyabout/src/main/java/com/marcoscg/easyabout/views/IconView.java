package com.marcoscg.easyabout.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * Created by @MarcosCGdev on 06/01/2017.
 */

public final class IconView extends AppCompatImageView {

    public IconView (Context context) {
        super(context);
        tint(context);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        tint(context);
    }

    public IconView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        tint(context);
    }

    public IconView setColor(int color) {
        setColorFilter(color, PorterDuff.Mode.SRC_IN);
        return this;
    }

    private void tint(Context ctx) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = ctx.getTheme();
        theme.resolveAttribute(android.R.attr.textColorPrimary, typedValue, true);
        TypedArray arr =
                ctx.obtainStyledAttributes(typedValue.data, new int[]{
                        android.R.attr.textColorSecondary});
        int secondaryColor = arr.getColor(0, -1);
        setColorFilter(secondaryColor, PorterDuff.Mode.SRC_IN);
        arr.recycle();
    }
}