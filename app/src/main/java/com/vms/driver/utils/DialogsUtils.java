package com.vms.driver.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;

import com.vms.driver.R;

public class DialogsUtils {
    public static Dialog showProgressDialog(Context context, String text) {
        String str = text;
        Dialog dialog = new Dialog(context, android.R.style.Theme_Wallpaper_NoTitleBar_Fullscreen);
        dialog.setContentView(LayoutInflater.from(context).inflate(R.layout.progressbarlayout, null));
        dialog.setCancelable(false);
        dialog.show();
        return dialog;
    }
}
