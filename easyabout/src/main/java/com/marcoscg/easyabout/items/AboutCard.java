package com.marcoscg.easyabout.items;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @MarcosCGdev on 19/02/2018.
 */

public final class AboutCard {

    private List<AboutItem> aboutItemList;
    private String title;
    private int titleColor = 0;

    private AboutCard(AboutCard.Builder builder) {
        aboutItemList = builder.aboutItemList;
        title = builder.title;
        titleColor = builder.titleColor;
    }

    public List<AboutItem> getAboutItemList() {
        return aboutItemList;
    }

    public String getTitle() {
        return title;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public static class Builder {

        private Context context;
        private String title;
        private int titleColor = 0;

        private List<AboutItem> aboutItemList;

        public Builder(Context context) {
            this.context = context;
            aboutItemList = new ArrayList<>();
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(@StringRes int title) {
            this.title = context.getResources().getString(title);
            return this;
        }

        public Builder setTitleColor(@ColorInt int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder setTitleColorRes(@ColorRes int titleColorRes) {
            this.titleColor = context.getResources().getColor(titleColorRes);
            return this;
        }

        public Builder addItem(AboutItem aboutItem) {
            aboutItemList.add(aboutItem);
            return this;
        }

        public Builder addItem(HeaderAboutItem.Builder builder) {
            aboutItemList.add(builder.build());
            return this;
        }

        public Builder addItem(NormalAboutItem.Builder builder) {
            aboutItemList.add(builder.build());
            return this;
        }

        public AboutCard build() {
            return new AboutCard(this);
        }
    }

}
