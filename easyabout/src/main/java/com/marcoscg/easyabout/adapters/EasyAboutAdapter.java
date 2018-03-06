package com.marcoscg.easyabout.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.marcoscg.easyabout.R;
import com.marcoscg.easyabout.items.AboutItem;
import com.marcoscg.easyabout.items.HeaderAboutItem;
import com.marcoscg.easyabout.items.NormalAboutItem;
import com.marcoscg.easyabout.items.PersonAboutItem;
import com.marcoscg.easyabout.utils.ColorUtils;
import com.marcoscg.easyabout.views.IconView;

import java.util.List;

/**
 * Created by @MarcosCGdev on 19/02/2018.
 */

public final class EasyAboutAdapter extends ArrayAdapter<AboutItem> {

    private Context context;
    private List<AboutItem> aboutItemList;

    public EasyAboutAdapter(@NonNull Context context, List<AboutItem> aboutItemList) {
        super(context, 0, aboutItemList);
        this.context = context;
        this.aboutItemList = aboutItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AboutItem aboutItem = aboutItemList.get(position);

        if (convertView==null) {
            int layout;
            if (aboutItem instanceof HeaderAboutItem)
                layout = R.layout.ea_header_about_item;
            else if (aboutItem instanceof NormalAboutItem)
                layout = R.layout.ea_normal_about_item;
            else if (aboutItem instanceof PersonAboutItem)
                layout = R.layout.ea_person_about_item;
            else layout = R.layout.ea_normal_about_item;
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView subtitle = (TextView) convertView.findViewById(R.id.subtitle);
        AppCompatImageView icon = (AppCompatImageView) convertView.findViewById(R.id.icon);

        int color = ColorUtils.getThemeAttrColor(context, "aboutCardBackground");
        if (color != 0) {
            int primaryColor = ColorUtils.isDark(color) ? getClr(R.color.about_primary_text_color_dark) : getClr(R.color.about_primary_text_color_light);
            int secondaryColor = ColorUtils.isDark(color) ? getClr(R.color.about_secondary_text_color_dark) : getClr(R.color.about_secondary_text_color_light);

            if (icon instanceof IconView)
                ((IconView) icon).setColor(secondaryColor);

            title.setTextColor(primaryColor);
            subtitle.setTextColor(secondaryColor);
        }

        if (aboutItem.getTitle()==null)
            title.setVisibility(View.GONE);
        else title.setText(aboutItem.getTitle());

        if (aboutItem.getSubtitle()==null)
            subtitle.setVisibility(View.GONE);
        else subtitle.setText(aboutItem.getSubtitle());

        if (aboutItem.getIcon()==null)
            icon.setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        else icon.setImageDrawable(aboutItem.getIcon());

        convertView.setOnClickListener(aboutItem.getOnClickListener());
        convertView.setOnLongClickListener(aboutItem.getOnLongClickListener());

        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        if (aboutItem.getOnClickListener()!=null || aboutItem.getOnLongClickListener()!=null)
            convertView.setBackgroundResource(typedValue.resourceId);

        return convertView;
    }

    private int getClr(int colorRes) {
        return context.getResources().getColor(colorRes);
    }
}
