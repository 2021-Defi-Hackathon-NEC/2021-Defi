package com.example.wallet_bottom_nav_2;

import android.app.Activity;
import android.content.Intent;
import android.view.View;


import com.example.wallet_bottom_nav_2.ui.wallet.BALWalletFragment;

public class MyListener extends Activity implements View.OnClickListener  {

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), BALWalletFragment.class);
        startActivity(intent);
    }
}
