package com.example.wallet_bottom_nav_2.ui.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wallet_bottom_nav_2.R;

public class BALWalletFragment extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_wallet_bal);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("BAL Wallet");
    }

    // 코드 수정중
//    public void clickBtn(View view){
//        Intent intent = new Intent(this, BALWalletFragment.class);
//        startActivity(intent);
//    }

}



