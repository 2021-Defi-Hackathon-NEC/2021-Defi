package com.example.wallet_bottom_nav_2.ui.exchange;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.wallet_bottom_nav_2.R;
import com.example.wallet_bottom_nav_2.databinding.FragmentExchangeBinding;

public class ExchangeFragment extends Fragment implements View.OnClickListener{

    private ExchangeViewModel exchangeViewModel;
    private FragmentExchangeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exchangeViewModel =
                new ViewModelProvider(this).get(ExchangeViewModel.class);

        binding = FragmentExchangeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        // 버튼 눌린 상태 커스텀
        View view = inflater.inflate(R.layout.fragment_exchange, container, false);
        final Button selector_selected = (Button) view.findViewById(R.id.button2);
        // 클릭시 선택된다.
        selector_selected.setOnClickListener(this);



        //    // 클릭시 포커스를 준다.
        //        selector_focused.setOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View view) {
        //            selector_focused.requestFocus();
        //        }
        //    })
        //
        //    // 클릭시 비사용 모드로 바꾼다.
        //        selector_endabled.setOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View view) {
        //            selector_endabled.setEnabled(false);
        //        }
        //    })

        // address 텍스트뷰 반환
        final TextView textView = binding.textView34;
        exchangeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {

    }


}
