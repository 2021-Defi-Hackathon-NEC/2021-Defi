package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        Button imageButton = (Button) findViewById(R.id.button4);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login3_ethereum.class);
                startActivity(intent);
            }
        });
    }
}