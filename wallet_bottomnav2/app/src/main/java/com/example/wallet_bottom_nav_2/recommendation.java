package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class recommendation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        ImageButton btn_news1 = (ImageButton) findViewById(R.id.img_btn_news1);
        ImageButton btn_news2 = (ImageButton) findViewById(R.id.img_btn_news2);
    }
    public void onClick (View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        switch (v.getId()){
            case R.id.img_btn_news1:
                intent.setData(Uri.parse("https://www.coinmarketcal.com/en/news/amazon-wants-to-hire-a-digital-currency-and-blockchain-product-lead"));
                startActivity(intent);
                break;
            case R.id.img_btn_news2:
                intent.setData(Uri.parse("https://www.coinmarketcal.com/en/news/uk-treasury-moves-toward-implementing-fatfs-crypto-travel-rule-with-public-consultation"));
                startActivity(intent);
                break;
        }
    }
}