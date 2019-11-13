package com.vms.driver.activities.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileProofFragmentViewModel extends ViewModel {

        private MutableLiveData<String> mText;

    public ProfileProofFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is profile  fragment");
    }

        public LiveData<String> getText() {
        return mText;
    }
}
