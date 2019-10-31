package com.vms.driver.utils;

import android.content.Context;
import android.os.Build;

public class PlatformUtils {
    /**
     * SET COLOR WRAPPER
     * @param context
     * @param id
     * @return
     */
    public static int getColorWrapper(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(id);
        } else {
            //noinspection deprecation
            return context.getResources().getColor(id);
        }
    }
}
