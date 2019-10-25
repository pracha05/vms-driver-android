package com.vms.driver.utils;

import android.content.Context;
import android.widget.Toast;

public class MessageToast {
    public static void showToastMethod(Context context, String message) {
        Toast toast = Toast.makeText(context, message, 0);
        toast.setGravity(17, 0, 0);
        toast.show();
    }
}
