package com.vms.driver.activities.ui.accounting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountingFragmentModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AccountingFragmentModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}