package com.example.wallet_bottom_nav_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wallet_bottom_nav_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Spinner mSpinner;
    String[] spinnerCoins;
    int[] spinnerImages;
    int selected_coin_idx = 0;

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

        //super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner)findViewById(R.id.spinner);

        spinnerCoins = new String[]{"Ethereum", "Bitcoin", "Ethereum Classic", "Persistence", "Solana"};
        spinnerImages = new int[]{R.drawable.bitcoin
                , R.drawable.bitcoin
                , R.drawable.bitcoin
                , R.drawable.bitcoin
                , R.drawable.bitcoin};

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(MainActivity.this, spinnerCoins, spinnerImages);
        mSpinner.setAdapter(customSpinnerAdapter);



        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                selected_coin_idx = mSpinner.getSelectedItemPosition();
                Toast.makeText(MainActivity.this, spinnerCoins[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        CustomSpinnerAdapter mCustomAdapter = new CustomSpinnerAdapter(MainActivity.this, spinnerCoins, spinnerImages);
        mSpinner.setAdapter(mCustomAdapter);

    }




    
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