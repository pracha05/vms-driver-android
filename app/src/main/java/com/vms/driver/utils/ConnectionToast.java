package com.vms.driver.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vms.driver.R;

public class ConnectionToast {
    public static void showNoNetworkToastMessage(Context context) {
        View layout = ((Activity) context).getLayoutInflater().inflate(R.layout.custom_toastfor_network, (ViewGroup) ((Activity) context).findViewById(R.id.custom_toast_network));
        TextView errorMessageTextView = (TextView) layout.findViewById(R.id.networkMessageTextView);
        TextView errorHeaderTextView = (TextView) layout.findViewById(R.id.networkHeaderTextView);
        errorMessageTextView.setText("Please check internet connection");
        errorMessageTextView.setWidth(800);
        errorHeaderTextView.setWidth(800);
        Toast toast = new Toast(context);
        toast.setGravity(16, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
