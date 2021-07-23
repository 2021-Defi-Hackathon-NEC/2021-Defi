package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class wallet_ETH extends AppCompatActivity {

    TextView tvAddress;
    ImageView ivAddressQR;
    Button btnCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_eth);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("ETH Wallet");

        tvAddress = findViewById(R.id.textView12);
        ivAddressQR = findViewById(R.id.imageView5);
        btnCopy = findViewById(R.id.button5);



//        String sText = tvAddress.getText().toString().trim();
//        MultiFormatWriter writer = new MultiFormatWriter();
//
//        try {
//
//            BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE, 350,350);
//            BarcodeEncoder encoder = new BarcodeEncoder();
//            Bitmap bitmap = encoder.createBitmap(matrix);
//            ivAddressQR.setImageBitmap(bitmap);
//            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            manager.hideSoftInputFromWindow(tvAddress.getApplicationWindowToken(), 0);
//
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
    }

    public void clickBtn_toast_msg(View view){
        switch(view.getId()){
            case R.id.imageButton: // ETH_Wallet refresh
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