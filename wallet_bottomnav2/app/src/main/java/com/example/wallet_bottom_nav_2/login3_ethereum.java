package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login3_ethereum extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3_ethereum);
        Button button4 = (Button) findViewById(R.id.button4) ;

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 3) {
                    button4.setClickable(true);
                    button4.setBackgroundColor(Color.BLUE);
                } else {
                    button4.setClickable(false);
                    button4.setBackgroundColor(Color.GRAY);
                }
            }
        });

    }
}