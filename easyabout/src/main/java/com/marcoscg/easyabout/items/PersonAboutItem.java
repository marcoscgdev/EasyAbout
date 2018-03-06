package com.marcoscg.easyabout.items;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;

/**
 * Created by @MarcosCGdev on 21/02/2018.
 */

public final class PersonAboutItem extends AboutItem {

    private PersonAboutItem(PersonAboutItem.Builder builder) {
        super(builder.title, builder.subtitle, builder.icon, builder.onClickListener, builder.onLongClickListener);
    }

    public static class Builder {

        private Context context;
        private String title, subtitle;
        private Drawable icon;
        private View.OnClickListener onClickListener;
        private View.OnLongClickListener onLongClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(@StringRes int title) {
            this.title = context.getResources().getString(title);
            return this;
        }

        public Builder setSubtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public Builder setSubtitle(@StringRes int subtitle) {
            this.subtitle = context.getResources().getString(subtitle);
            return this;
        }

        public Builder setIcon(Drawable icon) {
            this.icon = icon;
            return this;
        }

        public Builder setIcon(@DrawableRes int icon) {
            this.icon = ResourcesCompat.getDrawable(context.getResources(), icon, null);
            return this;
        }

        public Builder setOnClickListener(View.OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            return this;
        }

        public Builder setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
            this.onLongClickListener = onLongClickListener;
            return this;
        }

        public PersonAboutItem build() {
            return new PersonAboutItem(this);
        }

    }

}
