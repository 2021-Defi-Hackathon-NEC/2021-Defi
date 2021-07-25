package com.example.wallet_bottom_nav_2;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import static android.content.Context.CLIPBOARD_SERVICE;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wallet_bottom_nav_2.ui.exchange.ExchangeFragment;
import com.example.wallet_bottom_nav_2.ui.wallet.BALWalletFragment;
import com.example.wallet_bottom_nav_2.ui.wallet.WalletFragment;
import com.example.wallet_bottom_nav_2.ui.wallet.WalletViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wallet_bottom_nav_2.databinding.ActivityMainBinding;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    HashMap<String, String> address_map = new HashMap<String, String>(); // 지갑 주소 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_exchange, R.id.navigation_wallet,
                R.id.navigation_notifications, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

//        btn1 = (Button)findViewById(R.id.button2);
//        view1 = findViewById(R.id.button2);
//
//        btn1.setOnClickListener(this);
    }





    // 코드 수정중
    public void clickBtn(View view){
        Intent intent;
        switch(view.getId()){
            case R.id.button_wallet1: // BAL Wallet
                intent = new Intent(this, BALWalletFragment.class);
                startActivity(intent);
                break;
            case R.id.button_wallet2: // BTC Wallet
                intent = new Intent(this, wallet_BTC.class);
                startActivity(intent);
                break;
            case R.id.button_wallet4: // ETH Wallet
                intent = new Intent(this, wallet_ETH.class);
                startActivity(intent);
                break;
            case R.id.button_show_more: // Show More
                intent = new Intent(this, wallet_coins.class);
                startActivity(intent);
                break;
            case R.id.button_send_crypto: // Send Crypto
                intent = new Intent(this, SendCrypto.class);
                startActivity(intent);
                break;
            case R.id.button_show_more2: // Show More -> coinmarketcap
                intent = new Intent(this, recommendation.class);
                startActivity(intent);
                break;
            case R.id.button_show_more3: // Show More -> coinmarketcap
                intent = new Intent(this, coinmarketcap.class);
                startActivity(intent);
                break;
//            case R.id.button_done: // Send Crypto
//                intent = new Intent(this, WalletFragment.class);
//                startActivity(intent);
//                break;
            default:
                break;
        }

    }

    // 토스트 메시지 출력
    @SuppressLint("NonConstantResourceId")
    public void clickBtn_toast_msg(View view){
        switch(view.getId()){
            case R.id.imageButton5: // copy
                Toast.makeText(getApplicationContext(), "Copied!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton6: // Receive
                Toast.makeText(getApplicationContext(), "Received!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton4: // Send
                Toast.makeText(getApplicationContext(), "Sent!", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void clickBtn_selected(View view){
        final TextView recipient = findViewById(R.id.textView35);
        final EditText address = findViewById(R.id.textView34);
        Button selector_selected;

        // 임시 - address 추가하는 방식으로 되어 있는데 곧 수정할게요
        switch (view.getId()){
            case R.id.button2: // Geniee
                selector_selected = (Button) findViewById(R.id.button2);
                selector_selected.setSelected(!selector_selected.isSelected());
                address_map.put(selector_selected.getText().toString(), "1");
                break;
            case R.id.button7: // Hanhui
                selector_selected = (Button) findViewById(R.id.button7);
                selector_selected.setSelected(!selector_selected.isSelected());
                address_map.put(selector_selected.getText().toString(), "2");
                break;
            case R.id.button11: // Jimin
                selector_selected = (Button) findViewById(R.id.button11);
                selector_selected.setSelected(!selector_selected.isSelected());
                address_map.put(selector_selected.getText().toString(), "3");
                break;
            case R.id.button12: // zoo1
                selector_selected = (Button) findViewById(R.id.button12);
                selector_selected.setSelected(!selector_selected.isSelected());
                address_map.put(selector_selected.getText().toString(), "4");
                break;
            case R.id.button13: // chaerin
                selector_selected = (Button) findViewById(R.id.button13);
                selector_selected.setSelected(!selector_selected.isSelected());
                address_map.put(selector_selected.getText().toString(), "0x0508e99B9Cf2f07c639a05A52743aE6a1Dd48bEB");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        if (selector_selected.isSelected()){
            recipient.setText(selector_selected.getText().toString()); // 버튼 클릭 후 받는 사람 이름 표시
            address.setText(address_map.get(selector_selected.getText().toString()));
            Toast.makeText(getApplicationContext(), "Connected with " + selector_selected.getText().toString() + "!", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void clickBtn_coinSelected(View view){
        final TextView coin = findViewById(R.id.textView40); // coin
        Button selector_selected;

        switch (view.getId()) {
            case R.id.button8: // BTC
                selector_selected = (Button) findViewById(R.id.button8);
                break;
            case R.id.button9: // ETH
                selector_selected = (Button) findViewById(R.id.button9);
                break;
            case R.id.button14: // BNB
                selector_selected = (Button) findViewById(R.id.button14);
                break;
            case R.id.button15: // ETC
                selector_selected = (Button) findViewById(R.id.button15);
                break;
            case R.id.button16: // LINK
                selector_selected = (Button) findViewById(R.id.button16);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        if (true){
            coin.setText(selector_selected.getText().toString()); // 버튼 클릭 후 코인 이름 표시
            Toast.makeText(getApplicationContext(), "You Chose " + selector_selected.getText().toString() + "!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Result");
                builder.setMessage(result.getContents());
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
//                Toast.makeText(getApplicationContext(), "Scanned : " + result.getContents(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "OOPS ... You did not scan anything", Toast.LENGTH_SHORT).show();
            }
        }

//        if (result.getContents() != null) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setTitle("Result");
//            builder.setMessage(result.getContents());
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            });
//            builder.show();
//        } else {
//            Toast.makeText(getApplicationContext(), "OOPS ... You did not scan anything", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.button2:
//                view1.setVisibility(View.GONE);
//        }
    }


    // 클립보드에 복사

//    public void clickBtn_clipboard_copy(View view){
//        switch(view.getId()){
//            case R.id.textView12:
//                TextView title1 = (TextView) findViewById(R.id.textView12);
//                // Gets a handle to the clipboard service.
//                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
//                // Creates a new text clip to put on the clipboard
//                ClipData clip = ClipData.newPlainText("simple text", title1.getText().toString());
//                Toast.makeText(getApplicationContext(), "Copied!", Toast.LENGTH_SHORT).show();
//                // Set the clipboard's primary clip.
//                clipboard.setPrimaryClip(clip);
//        }
//    }

    // if the user selects copy


        // setOnClickListener에서 (혹은 intent 생성 시 onClick에서) NullPointerException 에러가 발생해서 주석 처리함
//        //BAL 버튼 클릭 시 액티비티 전환
//        Button button_wallet1 = findViewById(R.id.button_wallet1);
//        button_wallet1.setOnClickListener(new MyListener());

    // 액션바 버튼
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
//        return true;
//    }
//
//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle presses on the action bar items
//        if (item.getItemId() == R.id.action_btn1) {
//            playBtn();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}