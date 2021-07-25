package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import jnr.ffi.annotations.In;

import static android.R.layout.simple_spinner_item;

public class login2 extends AppCompatActivity {
    private EditText Mnemonic = (EditText) findViewById(R.id.Mnemonic);
    private Button nextButton = (Button) findViewById(R.id.nextButton);
    private EditText privatekey = (EditText) findViewById(R.id.editPrivate);
    private Spinner spinner_coins;
    String[] spinnerNames;
    int[] spinnerImages;
    int selected_coin_idx = 0;
    private boolean eth = false;

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

        // Button 추가 코드
        Button addButton = (Button) findViewById(R.id.addButton) ;
        Mnemonic.setTypeface(Typeface.DEFAULT);

        // Button invisible
        addButton.setVisibility(View.GONE);
        addButton.setClickable(false);
        Mnemonic.setVisibility(View.GONE);
        Mnemonic.setClickable(false);
        nextButton.setVisibility(View.GONE);
        nextButton.setClickable(false);

        // Ethereum Mnemonic
        ArrayAdapter<String> coinAdapter = new ArrayAdapter<>(this, simple_spinner_item, spinnerNames);
        coinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_coins.setAdapter(coinAdapter);

        spinner_coins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinnerNames[position].equals("Ethereum")){
                    Mnemonic.setClickable(true);
                    Mnemonic.setVisibility(View.VISIBLE);
                    addButton.setVisibility(View.VISIBLE);
                    addButton.setClickable(true);
                    nextButton.setVisibility(View.VISIBLE);
                    eth = true;

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
                                nextButton.setClickable(true);
                            } else {
                                nextButton.setClickable(false);
                            }
                        }
                    });
                }
                else{
                    addButton.setClickable(true);
                    addButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        한희님 여기예요
//        여기 고칠거 많아요
//        주목해주세요
        nextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if ((eth&&(Mnemonic==privatekey))|| !eth) {
                    Intent intent = new Intent(login2.this, login_popup_great.class);
                }
                else{
                    Intent intent = new Intent(login2.this, login_popup_error.class);
                }
            }

        });

    }
}