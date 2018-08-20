package com.marcoscg.easyabout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.marcoscg.easyabout.items.AboutCard;
import com.marcoscg.easyabout.items.AboutItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @MarcosCGdev on 19/02/2018.
 */

public abstract class EasyAboutFragment extends Fragment {

    private View rootView;
    private List<AboutCard> aboutCardList;
    private LinearLayout mainView;
    private NestedScrollView scrollView;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.ea_main_fragment, container, false);

        aboutCardList = new ArrayList<>();

        mainView = (LinearLayout) rootView.findViewById(R.id.main_view);
        scrollView = (NestedScrollView) rootView.findViewById(R.id.scroll_view);

        configureFragment(getContext(), rootView, savedInstanceState);

        return rootView;
    }

    protected abstract void configureFragment(Context context, View rootView, Bundle savedInstanceState);

    public void addCard(AboutCard aboutCard) {
        AboutListItemView aboutItemView = new AboutListItemView(getContext(), aboutCard.getTitle(), aboutCard.getTitleColor());
        for (AboutItem aboutItem : aboutCard.getAboutItemList()) {
            aboutItemView.addItem(aboutItem);
        }
        mainView.addView(aboutItemView);
    }
    
    public NestedScrollView getScrollView() {
        return scrollView;
    }
}
