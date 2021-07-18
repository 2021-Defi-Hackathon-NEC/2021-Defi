package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class before_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_main);

        Handler hd = new Handler(Looper.getMainLooper());
        hd.postDelayed(new SplashHandler(), 3000);

        // 액션바 숨기기
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

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

        
    }

    
    
    private class SplashHandler implements Runnable {
        public void run(){
            startActivity(new Intent(getApplication(), MainActivity.class));
            before_main.this.finish();
        }



    }

}

