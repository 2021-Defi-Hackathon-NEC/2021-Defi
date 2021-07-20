package com.example.wallet_bottom_nav_2.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> mText2;
    int bal = 1500;
    String unit = "NIM";

//    double bal_to_USD = 5.2;
//    String convert_unit = "USD";

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(bal + " " + unit);
    }

    public LiveData<String> getText() {
        return mText;
    }
}