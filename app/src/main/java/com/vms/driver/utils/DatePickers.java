package com.vms.driver.utils;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePickers {
    public static int mDay;
    public static int mMonth;
    public static int mYear;
    public static String mydate;

    public static void mypicker(Context context, final TextView textView) {
        Calendar mcurrentDate = Calendar.getInstance();
        mYear = mcurrentDate.get(Calendar.YEAR);
        mMonth = mcurrentDate.get(Calendar.MONTH);
        mDay = mcurrentDate.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                Calendar myCalendar = Calendar.getInstance();
                try {
                    myCalendar.set(Calendar.YEAR, selectedyear);
                    myCalendar.set(Calendar.MONTH, selectedmonth);
                    myCalendar.set(Calendar.DATE, selectedday);
                    DatePickers.mydate = new SimpleDateFormat("yyyy-MM-dd").format(myCalendar.getTime());
                    textView.setText(DatePickers.mydate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                DatePickers.mDay = selectedday;
                DatePickers.mMonth = selectedmonth;
                DatePickers.mYear = selectedyear;
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
        StringBuilder sb = new StringBuilder();
        sb.append(" Date ===> ");
        sb.append(mydate);
        Log.e("Info ", sb.toString());
    }
}
