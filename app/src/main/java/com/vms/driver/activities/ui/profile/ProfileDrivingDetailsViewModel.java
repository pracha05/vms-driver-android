package com.vms.driver.activities.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileDrivingDetailsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ProfileDrivingDetailsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is profile fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
