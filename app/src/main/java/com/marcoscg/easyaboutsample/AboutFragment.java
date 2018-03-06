package com.marcoscg.easyaboutsample;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.marcoscg.easyabout.EasyAboutFragment;
import com.marcoscg.easyabout.helpers.AboutItemBuilder;
import com.marcoscg.easyabout.items.AboutCard;
import com.marcoscg.easyabout.items.NormalAboutItem;
import com.marcoscg.easyabout.items.PersonAboutItem;

/**
 * Created by @MarcosCGdev on 19/02/2018.
 */

public class AboutFragment extends EasyAboutFragment {

    @Override
    protected void configureFragment(final Context context, View rootView) {
        addCard(new AboutCard.Builder(context)
                .addItem(AboutItemBuilder.generateAppTitleItem(context)
                        .setSubtitle("by @MarcosCGdev."))
                .addItem(AboutItemBuilder.generateAppVersionItem(context, true)
                        .setIcon(R.drawable.ic_info_outline_black_24dp))
                .addItem(new NormalAboutItem.Builder(context)
                        .setTitle("Licenses")
                        .setIcon(R.drawable.ic_description_black_24dp)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                DemoUtils.showLicensesDialog(context);
                            }
                        })
                        .build())
                .build());

        addCard(new AboutCard.Builder(context)
                .setTitle("Author")
                .addItem(new PersonAboutItem.Builder(context)
                        .setTitle("Marcos Calvo García")
                        .setSubtitle("Zaragoza, Spain.")
                        .setIcon(R.drawable.profile)
                        .build())
                .addItem(AboutItemBuilder.generateLinkItem(context, "https://github.com/marcoscgdev/EasyAbout")
                        .setTitle("Fork on GitHub")
                        .setIcon(R.drawable.ic_social_github_black_24dp))
                .addItem(AboutItemBuilder.generateLinkItem(context, "http://www.marcoscg.com")
                        .setTitle("Visit my website")
                        .setIcon(R.drawable.ic_web_black_24dp))
                .addItem(AboutItemBuilder.generateEmailItem(context, "marcoscgdev@gmail.com")
                        .setTitle("Send me an email")
                        .setIcon(R.drawable.ic_mail_outline_black_24dp))
                .build());

        addCard(new AboutCard.Builder(context)
                .setTitle("Support")
                .addItem(AboutItemBuilder.generatePlayStoreItem(context)
                        .setTitle("Rate application")
                        .setIcon(R.drawable.ic_star_black_24dp))
                .addItem(AboutItemBuilder.generateLinkItem(context, "https://github.com/marcoscgdev/EasyAbout/issues/new")
                        .setTitle("Report bugs")
                        .setIcon(R.drawable.ic_bug_report_black_24dp))
                .addItem(new NormalAboutItem.Builder(context)
                        .setTitle("Clickable item")
                        .setSubtitle("This item has onClick and onLongClick listener.")
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View view) {
                                Toast.makeText(context, "onLongClick", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        })
                        .setIcon(R.drawable.ic_mouse_black_24dp)
                        .build())
                .build());
    }
}
