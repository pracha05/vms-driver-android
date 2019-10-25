package com.vms.driver.activities.ui.jobfinder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JobFinderViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public JobFinderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}