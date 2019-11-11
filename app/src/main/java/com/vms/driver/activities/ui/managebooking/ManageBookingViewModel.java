package com.vms.driver.activities.ui.managebooking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ManageBookingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ManageBookingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is manage booking fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}