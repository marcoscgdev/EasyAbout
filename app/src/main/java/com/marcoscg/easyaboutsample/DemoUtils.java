package com.marcoscg.easyaboutsample;

import android.content.Context;

import com.marcoscg.licenser.Library;
import com.marcoscg.licenser.License;
import com.marcoscg.licenser.LicenserDialog;

/**
 * Created by @MarcosCGdev on 21/02/2018.
 */

public class DemoUtils {

    public static void showLicensesDialog(Context context) {
        new LicenserDialog(context)
                .setTitle("Licenses")
                .setLibrary(new Library("Android Support Libraries",
                        "https://developer.android.com/topic/libraries/support-library/index.html",
                        License.APACHE))
                .setLibrary(new Library("Easy About",
                        "https://github.com/marcoscgdev/EasyAbout",
                        License.MIT))
                .setLibrary(new Library("Licenser",
                        "https://github.com/marcoscgdev/Licenser",
                        License.MIT))
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

}
