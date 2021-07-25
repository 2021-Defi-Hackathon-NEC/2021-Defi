package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

public class before_main extends AppCompatActivity {

    private Context context;
    private boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_main);
        context = this;

        Handler hd = new Handler(Looper.getMainLooper());
        hd.postDelayed(new SplashHandler(), 3000);

        // 액션바 숨기기
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) { actionbar.hide(); }

        // 상태바 숨기기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());
            }
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }

        String user = PreferenceManager.getString(context, "user");
        if (user.equals("")) { isLoggedIn = false; }

    }
    
    private class SplashHandler implements Runnable {
        public void run(){
            if (isLoggedIn) {
                startActivity(new Intent(getApplication(), login_1.class));
            } else {
//                startActivity(new Intent(getApplication(), login_1.class));
                startActivity(new Intent(getApplication(), login_1.class));
            }
            before_main.this.finish();
        }
    }

}

