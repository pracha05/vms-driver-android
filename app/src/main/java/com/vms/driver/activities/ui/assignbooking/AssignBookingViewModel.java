package com.vms.driver.activities.ui.assignbooking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AssignBookingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AssignBookingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Assign booking fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}