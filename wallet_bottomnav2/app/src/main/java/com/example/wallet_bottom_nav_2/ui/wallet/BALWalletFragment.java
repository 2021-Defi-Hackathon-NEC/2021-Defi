package com.example.wallet_bottom_nav_2.ui.wallet;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wallet_bottom_nav_2.R;

public class BALWalletFragment extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_wallet_bal);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("BAL Wallet");
    }

    public void clickBtn_toast_msg(View view){
        switch(view.getId()){
            case R.id.imageButton: // BAL_Wallet refresh
                Toast.makeText(getApplicationContext(), "Refreshed", Toast.LENGTH_SHORT).show();
                break;
        }
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
}



