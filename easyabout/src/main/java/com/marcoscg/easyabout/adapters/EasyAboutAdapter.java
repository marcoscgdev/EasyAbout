package com.marcoscg.easyabout.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

public final class EasyAboutAdapter extends
        RecyclerView.Adapter<EasyAboutAdapter.MyViewHolder> {

    private Context context;
    private List<AboutItem> aboutItemList;

    private final int ITEM_TYPE_HEADER = 0;
    private final int ITEM_TYPE_NORMAL = 1;
    private final int ITEM_TYPE_PERSON = 2;

    public EasyAboutAdapter(@NonNull Context context, List<AboutItem> aboutItemList) {
        this.context = context;
        this.aboutItemList = aboutItemList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout container;
        private TextView title, subtitle;
        private AppCompatImageView icon;

        public MyViewHolder(View view) {
            super(view);
            container = (LinearLayout) view.findViewById(R.id.item_container);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            icon = (AppCompatImageView) view.findViewById(R.id.icon);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AboutItem aboutItem = aboutItemList.get(position);

        int color = ColorUtils.getThemeAttrColor(context, "aboutCardBackground");
        if (color != 0) {
            int primaryColor = ColorUtils.isDark(color) ? getClr(R.color.about_primary_text_color_dark) : getClr(R.color.about_primary_text_color_light);
            int secondaryColor = ColorUtils.isDark(color) ? getClr(R.color.about_secondary_text_color_dark) : getClr(R.color.about_secondary_text_color_light);

            if (holder.icon instanceof IconView)
                ((IconView) holder.icon).setColor(secondaryColor);

            holder.title.setTextColor(primaryColor);
            holder.subtitle.setTextColor(secondaryColor);
        }

        if (aboutItem.getTitle()==null)
            holder.title.setVisibility(View.GONE);
        else holder.title.setText(aboutItem.getTitle());

        if (aboutItem.getSubtitle()==null)
            holder.subtitle.setVisibility(View.GONE);
        else holder.subtitle.setText(aboutItem.getSubtitle());

        if (aboutItem.getIcon()==null)
            holder.icon.setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        else holder.icon.setImageDrawable(aboutItem.getIcon());

        holder.container.setOnClickListener(aboutItem.getOnClickListener());
        holder.container.setOnLongClickListener(aboutItem.getOnLongClickListener());

        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        if (aboutItem.getOnClickListener()!=null || aboutItem.getOnLongClickListener()!=null)
            holder.container.setBackgroundResource(typedValue.resourceId);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;

        if (viewType == ITEM_TYPE_HEADER)
            layout = R.layout.ea_header_about_item;
        else if (viewType == ITEM_TYPE_NORMAL)
            layout = R.layout.ea_normal_about_item;
        else if (viewType == ITEM_TYPE_PERSON)
            layout = R.layout.ea_person_about_item;
        else layout = R.layout.ea_normal_about_item;

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        AboutItem aboutItem = aboutItemList.get(position);

        if (aboutItem instanceof HeaderAboutItem)
            return ITEM_TYPE_HEADER;
        else if (aboutItem instanceof NormalAboutItem)
            return ITEM_TYPE_NORMAL;
        else if (aboutItem instanceof PersonAboutItem)
            return ITEM_TYPE_PERSON;
        else return ITEM_TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return aboutItemList.size();
    }

    private int getClr(int colorRes) {
        return context.getResources().getColor(colorRes);
    }

}
