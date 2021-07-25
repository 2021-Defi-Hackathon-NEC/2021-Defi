package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import android.os.Bundle;

import static android.widget.Toast.*;

public class login2 extends AppCompatActivity {
    private Spinner spinner_coins;
    String[] spinnerNames;
    int[] spinnerImages;
    int selected_coin_idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        spinner_coins = (Spinner)findViewById(R.id.spinner_coins);

        spinnerNames = new String[]{"Bitcoin", "Ethereum", "Ethereum Classic", "Binance coin", "ChainLink"};
        spinnerImages = new int[]{R.drawable.bitcoin
                , R.drawable.ethereum
                , R.drawable.ethereum_classic
                , R.drawable.binance
                , R.drawable.link};

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(login2.this, spinnerNames, spinnerImages);
        spinner_coins.setAdapter(customSpinnerAdapter);

        spinner_coins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                selected_coin_idx = spinner_coins.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
    }
}