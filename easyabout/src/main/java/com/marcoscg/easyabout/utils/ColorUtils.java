package com.marcoscg.easyabout.utils;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;

/**
 * Created by @MarcosCGdev on 21/02/2018.
 */

public final class ColorUtils {

    public static int getThemeAccentColor(Context context) {
        int colorAttr;
        if (Build.VERSION.SDK_INT >= 21) {
            colorAttr = android.R.attr.colorAccent;
        } else {
            colorAttr = context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        }
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(colorAttr, outValue, true);
        return outValue.data;
    }

    public static int getThemeAttrColor(Context context, String attrName) {
        int value = 0;
        try {
            int colorAttr = context.getResources().getIdentifier(attrName, "attr", context.getPackageName());
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(colorAttr, outValue, true);
            value = outValue.data;
        } catch (Exception e) {}
        return value;
    }

    public static boolean isDark(int color) {
        return android.support.v4.graphics.ColorUtils.calculateLuminance(color) < 0.4;
    }

}
