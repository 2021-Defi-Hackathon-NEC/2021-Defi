package com.example.wallet_bottom_nav_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wallet_bottom_nav_2.ui.wallet.BALWalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wallet_bottom_nav_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

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