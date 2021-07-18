package com.example.wallet_bottom_nav_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
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
                    .setTitle("PIN 번호를 인증해주세요")
                    .setLeftButton("취소")
                    .setNextButton("다음")
                    .setCodeLength(6);
        }else {
            Log.d("encoded_pin_code","저장된 핀코드 확인 ...");
            Toast.makeText(getApplicationContext(), "저장된 핀번호가 없습니다. 핀번호를 생성해주세요.", Toast.LENGTH_LONG).show();
            builder = new PFFLockScreenConfiguration.Builder(this).
                    setMode(PFFLockScreenConfiguration.MODE_CREATE)
                    .setTitle("PIN 번호를 생성해주세요")
                    .setNewCodeValidation(true)
                    .setNewCodeValidationTitle("다시 한 번 PIN 번호를 입력해주세요")
                    .setNextButton("다음")
                    .setUseFingerprint(false)
                    .setCodeLength(6);
        }

        fragment.setConfiguration(builder.build());
        fragment.setOnLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "핀번호가 초기화되었습니다.", Toast.LENGTH_LONG);

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
                Log.d("encoded_pin_code", "인증 성공");
                Toast.makeText(context, "핀번호 인증에 성공하였습니다.", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onFingerprintSuccessful() {
                Log.d("encoded_pin_code", "지문 인증 성공");
            }

            @Override
            public void onPinLoginFailed() {
                Log.d("encoded_pin_code", "핀 인증 실패");
                Toast.makeText(getApplicationContext(), "핀번호 인증에 실패하였습니다.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFingerprintLoginFailed() {
                Log.d("encoded_pin_code", "지문 인증 실패");
            }
        });

        fragment.setCodeCreateListener(new PFLockScreenFragment.OnPFLockScreenCodeCreateListener() {
            @Override
            public void onCodeCreated(String encodedCode) {
                editor.putString("encoded_pin_code", encodedCode);
                editor.commit();
                Log.d("encoded_pin_code", "핀 번호 생성 완료 : " + encodedCode);
                Toast.makeText(getApplicationContext(), "핀번호가 생성되었습니다.", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onNewCodeValidationFailed() {
                Toast.makeText(getApplicationContext(), "핀번호를 이전과 똑같이 입력해주세요.", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(auth_pincode.this, "핀 정보를 가져올 수 없습니다.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        showLockScreenFragment(result.getResult());
                    }
                });
    }
}