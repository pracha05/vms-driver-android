package com.vms.driver.utils;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

public class HideKeyboard {
    public static void hideSoftKeyboard(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
