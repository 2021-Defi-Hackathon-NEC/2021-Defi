package com.example.wallet_bottom_nav_2.ui.exchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.wallet_bottom_nav_2.Capture;
import com.example.wallet_bottom_nav_2.R;
import com.example.wallet_bottom_nav_2.databinding.FragmentExchangeBinding;
import com.google.zxing.integration.android.IntentIntegrator;

public class ExchangeFragment extends Fragment implements View.OnClickListener{

    private ExchangeViewModel exchangeViewModel;
    private FragmentExchangeBinding binding;
    private ImageButton btScan;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exchangeViewModel =
                new ViewModelProvider(this).get(ExchangeViewModel.class);

        binding = FragmentExchangeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btScan = binding.btScan;
        btScan.setOnClickListener(this);

        // address 텍스트뷰 반환
        final TextView textView = binding.textView34;
        exchangeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // 버튼 눌린 상태 커스텀
        View view = inflater.inflate(R.layout.fragment_exchange, container, false);
        final Button selector_selected = (Button) view.findViewById(R.id.button2);
        // 클릭시 선택된다.
        selector_selected.setOnClickListener(this);


        return root;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        IntentIntegrator integrator = IntentIntegrator.forSupportFragment(ExchangeFragment.this);
        integrator.setPrompt("Scan QR code");
        integrator.setBeepEnabled(true);
        integrator.setOrientationLocked(true);
        integrator.setCaptureActivity(Capture.class);
        integrator.initiateScan();
    }


}
