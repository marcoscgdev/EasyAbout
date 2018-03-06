package com.marcoscg.easyabout.helpers;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;

import com.marcoscg.easyabout.items.HeaderAboutItem;
import com.marcoscg.easyabout.items.NormalAboutItem;

/**
 * Created by @MarcosCGdev on 21/02/2018.
 */

public final class AboutItemBuilder {

    public static HeaderAboutItem.Builder generateAppTitleItem(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return new HeaderAboutItem.Builder(context)
                .setTitle(packageManager.getApplicationLabel(applicationInfo).toString())
                .setIcon(packageManager.getApplicationIcon(applicationInfo));
    }

    public static NormalAboutItem.Builder generateAppVersionItem(Context context, boolean withVersionCode) {
        PackageManager packageManager = context.getPackageManager();
        String version = "";
        try {
            version = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            if (withVersionCode)
                version += " (" + packageManager.getPackageInfo(context.getPackageName(), 0).versionCode + ")";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new NormalAboutItem.Builder(context)
                .setTitle("Version")
                .setSubtitle(version);
    }

    public static NormalAboutItem.Builder generateLinkItem(final Context context, final String url) {
        return new NormalAboutItem.Builder(context)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    }
                });
    }

    public static NormalAboutItem.Builder generateEmailItem(final Context context, final String email) {
        return generateLinkItem(context, "mailto:" + email);
    }

    public static NormalAboutItem.Builder generatePlayStoreItem(final Context context) {
        final String appPackageName = context.getPackageName();
        return new NormalAboutItem.Builder(context)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (ActivityNotFoundException anfe) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                });
    }

}
