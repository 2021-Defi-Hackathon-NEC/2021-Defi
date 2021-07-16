package com.example.wallet_bottom_nav_2.ui.wallet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WalletViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WalletViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is wallet fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
