package com.example.wallet_bottom_nav_2;

import android.app.Activity;
import android.content.Intent;
import android.view.View;


import com.example.wallet_bottom_nav_2.ui.wallet.BALWalletFragment;
import com.example.wallet_bottom_nav_2.ui.wallet.WalletFragment;

public class MyListener extends Activity implements View.OnClickListener  {

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case 1:
                intent = new Intent(getApplicationContext(), BALWalletFragment.class);
                startActivity(intent);
                break;
        }

    }
}
