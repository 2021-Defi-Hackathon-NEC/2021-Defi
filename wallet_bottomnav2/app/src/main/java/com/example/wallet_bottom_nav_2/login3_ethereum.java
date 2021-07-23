package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class login3_ethereum extends AppCompatActivity {
    private EditText Mnemonic = (EditText) findViewById(R.id.Mnemonic);
    private Spinner spinner_coins;
    String[] spinnerNames;
    int[] spinnerImages;
    int selected_coin_idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3_ethereum);

        spinner_coins = (Spinner)findViewById(R.id.spinner_coins);

        spinnerNames = new String[]{"Bitcoin", "Ethereum", "Ethereum Classic", "Binance coin", "ChainLink"};
        spinnerImages = new int[]{R.drawable.bitcoin
                , R.drawable.ethereum
                , R.drawable.ethereum_classic
                , R.drawable.binance
                , R.drawable.link};

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(login3_ethereum.this, spinnerNames, spinnerImages);
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


        Button addButton = (Button) findViewById(R.id.addButton) ;
        Mnemonic.setTypeface(Typeface.DEFAULT);

        addButton.setVisibility(View.GONE);
        addButton.setClickable(false);


        Mnemonic.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 3) {
                    addButton.setVisibility(View.VISIBLE);
                    addButton.setClickable(true);
                } else {
                    addButton.setClickable(false);
                }
            }
        });

    }
}