package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class wallet_BTC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_btc);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("BTC Wallet");
    }

    public void clickBtn_clipboard_copy(View view){
        switch(view.getId()){
            case R.id.button5: // copy button
                TextView title1 = (TextView) findViewById(R.id.textView12);
                // Gets a handle to the clipboard service.
                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                // Creates a new text clip to put on the clipboard
                ClipData clip = ClipData.newPlainText("simple text", title1.getText().toString());
                Toast.makeText(getApplicationContext(), "Copied!", Toast.LENGTH_SHORT).show();
                // Set the clipboard's primary clip.
                clipboard.setPrimaryClip(clip);

                // 클립보드에서 붙여넣기
                clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                String pasteData = "";


        }
    }

    public void clickBtn_toast_msg(View view){
        switch(view.getId()){
            case R.id.imageButton2: // BTC_Wallet refresh
                Toast.makeText(getApplicationContext(), "Refreshed", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}