package com.vms.driver.activities.ui.incentive;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IncentiveFragmentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IncentiveFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is incentive fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}