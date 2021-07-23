package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wallet_bottom_nav_2.ui.wallet.BALWalletFragment;
import com.example.wallet_bottom_nav_2.ui.wallet.WalletFragment;

public class wallet_coins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_coins);
    }

    public void clickBtn_toast_msg(View view){
        switch(view.getId()){
            case R.id.button_confirm: // Confirm Button
                Toast.makeText(getApplicationContext(), "Confirmed", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}