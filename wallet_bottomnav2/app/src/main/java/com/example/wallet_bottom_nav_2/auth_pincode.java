package com.example.wallet_bottom_nav_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.beautycoder.pflockscreen.PFFLockScreenConfiguration;
import com.beautycoder.pflockscreen.fragments.PFLockScreenFragment;
import com.beautycoder.pflockscreen.security.PFResult;
import com.beautycoder.pflockscreen.security.PFSecurityManager;
import com.beautycoder.pflockscreen.security.callbacks.PFPinCodeHelperCallback;
import com.beautycoder.pflockscreen.viewmodels.PFPinCodeViewModel;

import java.io.IOException;
import java.security.GeneralSecurityException;



public class auth_pincode extends AppCompatActivity {

    String masterKeyAlias;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    PFLockScreenFragment fragment;
    PFFLockScreenConfiguration.Builder builder;
    Context context;
    Boolean isPinExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_pincode);

        context = this;
        showLockScreenFragment();

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

    private void showLockScreenFragment(boolean isPinExist) {
        try {
            masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            sharedPreferences = EncryptedSharedPreferences.create(
                    "secret",
                    masterKeyAlias,
                    this,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editor = sharedPreferences.edit();
        fragment = new PFLockScreenFragment();

        if(isPinExist && !sharedPreferences.getString("encoded_pin_code", "").equals("")) {
            fragment.setEncodedPinCode(sharedPreferences.getString("encoded_pin_code", ""));
            builder = new PFFLockScreenConfiguration.Builder(this).
                    setMode(PFFLockScreenConfiguration.MODE_AUTH)
                    .setTitle("Enter the Password")
                    .setLeftButton("Cancel")
                    .setNextButton("Continue")
                    .setCodeLength(6);
        }else {
            Log.d("encoded_pin_code","Checking the password ...");
            Toast.makeText(getApplicationContext(), "There is no saved password. Please create it.", Toast.LENGTH_LONG).show();
            builder = new PFFLockScreenConfiguration.Builder(this).
                    setMode(PFFLockScreenConfiguration.MODE_CREATE)
                    .setTitle("Create a Password")
                    .setNewCodeValidation(true)
                    .setNewCodeValidationTitle("Enter the Password again")
                    .setNextButton("Continue")
                    .setUseFingerprint(false)
                    .setCodeLength(6);
        }

        fragment.setConfiguration(builder.build());
        fragment.setOnLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Password has been initialized.", Toast.LENGTH_LONG);

                /*
                 * 테스트용 핀번호 초기화 코드
                 * */
                PFSecurityManager.getInstance().getPinCodeHelper().delete(new PFPinCodeHelperCallback<Boolean>() {
                    @Override
                    public void onResult(PFResult<Boolean> result) {
                        Log.d("encoded_pin_code", "코드 삭제 결과" + result.getResult());

                    }
                });
                // getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                finish();
            }
        });

        fragment.setLoginListener(new PFLockScreenFragment.OnPFLockScreenLoginListener() {
            @Override
            public void onCodeInputSuccessful() {
                Log.d("encoded_pin_code", "Authentication complete");
                Toast.makeText(context, "Password is certified", Toast.LENGTH_LONG).show();
                // finish();
                startActivity(new Intent(getApplication(), MainActivity.class));
            }

            @Override
            public void onFingerprintSuccessful() {
                Log.d("encoded_pin_code", "Fingerprint Authentication success");
            }

            @Override
            public void onPinLoginFailed() {
                Log.d("encoded_pin_code", "Try Again");
                Toast.makeText(getApplicationContext(), "Input value does not match", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFingerprintLoginFailed() {
                Log.d("encoded_pin_code", "Fingerprint Authentication fail");
            }
        });

        fragment.setCodeCreateListener(new PFLockScreenFragment.OnPFLockScreenCodeCreateListener() {
            @Override
            public void onCodeCreated(String encodedCode) {
                editor.putString("encoded_pin_code", encodedCode);
                editor.commit();
                Log.d("encoded_pin_code", "Password generation completed : " + encodedCode);
                Toast.makeText(getApplicationContext(), "Password generated Successfully", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onNewCodeValidationFailed() {
                Toast.makeText(getApplicationContext(), "Enter the password again.", Toast.LENGTH_LONG).show();
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.auth_pincode_container, fragment).commit();
    }
    private void showLockScreenFragment() {
        new PFPinCodeViewModel().isPinCodeEncryptionKeyExist().observe(this,
                new Observer<PFResult<Boolean>>() {
                    @Override
                    public void onChanged(PFResult<Boolean> result) {
                        Log.d("encoded_pin_code", "on Changed");

                        if (result == null) {
                            return;
                        }
                        if(result.getError() != null) {
                            Toast.makeText(auth_pincode.this, "There is no password data.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        showLockScreenFragment(result.getResult());
                    }
                });
    }
}