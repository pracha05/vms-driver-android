package com.vms.driver.utils;

import android.content.Context;

import com.vms.driver.R;

public class AppFonts {
    Context mContext;

    public AppFonts(Context mContext1) {
        this.mContext = mContext1;
    }

    public static String GetRobotoRegular(Context context) {
        return context.getString(R.string.RobotoRegular);
    }

    public static String GetRobotoBold(Context context) {
        return context.getString(R.string.RobotoBold);
    }
}
