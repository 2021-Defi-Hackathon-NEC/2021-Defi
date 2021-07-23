package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login3_ethereum extends AppCompatActivity {
    private EditText Mnemonic = (EditText) findViewById(R.id.Mnemonic);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3_ethereum);
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