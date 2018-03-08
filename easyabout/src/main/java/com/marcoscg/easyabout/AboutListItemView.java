package com.marcoscg.easyabout;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.marcoscg.easyabout.adapters.EasyAboutAdapter;
import com.marcoscg.easyabout.items.AboutItem;
import com.marcoscg.easyabout.utils.ColorUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @MarcosCGdev on 19/02/2018.
 */

final class AboutListItemView extends RelativeLayout {

    private RecyclerView recyclerView;
    private List<AboutItem> aboutItemList;
    private EasyAboutAdapter easyAboutAdapter;

    AboutListItemView(Context context, String title, int titleColor) {
        super(context);
        init(context, title, titleColor);
    }

    AboutListItemView(Context context, AttributeSet attrs, String title, int titleColor) {
        super(context, attrs);
        init(context, title, titleColor);
    }

    AboutListItemView(Context context, AttributeSet attrs, int defStyle, String title, int titleColor) {
        super(context, attrs, defStyle);
        init(context, title, titleColor);
    }

    private void init(Context context, String title, int titleColor) {
        inflate(getContext(), R.layout.ea_card_list, this);
        aboutItemList = new ArrayList<>();
        easyAboutAdapter = new EasyAboutAdapter(context, aboutItemList);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(easyAboutAdapter);
        TextView titleTv = (TextView) findViewById(R.id.card_title);
        if (titleColor==0)
            titleColor = ColorUtils.getThemeAccentColor(context);
        titleTv.setTextColor(titleColor);
        if (title==null)
            titleTv.setVisibility(GONE);
        else titleTv.setText(title);

        int cardColor = ColorUtils.getThemeAttrColor(context, "aboutCardBackground");
        if (cardColor!= 0)
            ((CardView) findViewById(R.id.card_view)).setCardBackgroundColor(cardColor);
    }

    void addItem(AboutItem aboutItem) {
        aboutItemList.add(aboutItem);
        easyAboutAdapter.notifyDataSetChanged();
    }

}
