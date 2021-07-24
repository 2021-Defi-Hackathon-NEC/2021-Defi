package com.example.wallet_bottom_nav_2.ui.exchange;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class ExchangeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExchangeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("3D2oetdNuZUqQHPJmcMDDHYoqkyNVsFk9r");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
