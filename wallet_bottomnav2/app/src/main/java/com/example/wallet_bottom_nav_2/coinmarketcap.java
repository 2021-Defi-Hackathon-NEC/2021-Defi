////package com.example.wallet_bottom_nav_2;
////
////import androidx.annotation.NonNull;
////import androidx.appcompat.app.AppCompatActivity;
////
////import com.android.volley.Request;
////import com.android.volley.RequestQueue;
////import com.android.volley.Response;
////import com.android.volley.toolbox.Volley;
////
////import android.os.Bundle;
////import android.util.Log;
////import android.widget.EditText;
////import android.widget.Button;
////import android.view.View;
////import android.widget.TextView;
////import org.json.JSONArray;
////import org.json.JSONException;
////
////
////public class coinmarketcap extends AppCompatActivity {
////
////    private RequestQueue requestQueue;
////
////    private static final String TAG = "Main";
////
////    EditText edit_coinNm;
////    TextView opening_price; //시가
////    TextView high_price; //고가
////    TextView low_price; //저가
////    TextView trade_price; //종가
////    TextView prev_closing_price; //전일 증가
////    TextView acc_trade_price_24h; //24시간 누적 거래대금
////    TextView acc_trade_volume_24h; //24시간 누적 거래량
////    Button btn_search;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        opening_price = findViewById(R.id.opening_price);
////        high_price = findViewById(R.id.high_price);
////        low_price = findViewById(R.id.low_price);
////        trade_price = findViewById(R.id.trade_price);
////        prev_closing_price = findViewById(R.id.prev_closing_price);
////        acc_trade_price_24h = findViewById(R.id.acc_trade_price_24h);
////        acc_trade_volume_24h = findViewById(R.id.acc_trade_volume_24h);
////        button btn_search = findViewById(R.id.btn_search);
////        btn_search.setOnClickListener(new View.OnClickListener(){
////            @Override
////            public void onClick(View view) {
////                edit_coinNm = findViewById(R.id.edit_coinNm);
////
////                String coinNm = edit_coinNm.getText().toString().toUpperCase();
////
////                if(!coinNm.isEnpty()){
////                    getTicker(coinNm);
////                }
////            }
////        });
////
////        if(requestQueue == null){
////            requestQueue = Volley.newRequestQueue(getApplicationContext());
////        }
////    }
////
////    private void getTicker(String coinNm){
////        final String coinName = coinNm;
////        String url = "https://api.upbit.com/v1/ticker?markets=KRW-"+coinName;
////        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
////            @Override
////            public void onResponse(String response) {
////                getTickerData(responce);
////            }
////        },
////                new Response.ErrorListener() {
////                    @Override
////                    public void onErrorResponse(VollyError error) {
////                        Log.d(TAG, "onErrorResponse:" + error.getMessage());
////                    }
////                }) {
////        };
////        request.setShouldCache(false);
////        requestQueue.add(request);
////    }
////    private void getTickerData(String data) {
////
////        try{
////            JSONArray jsonArray = new JSONArray(data);
////
////            for (int i = 0; i< jsonArray.length(); i++) {
////                JSONObject jsonArray = jsonArray.getJSONObject(i);
////
////                String sPpening_price = jsonObject.get("opening_price").toString(); //시가
////                String sHigh_price = jsonObject.get("high_price").toString(); //고가
////                String sLow_price = jsonObject.get("low_price").toString(); //저가
////                String sTrade_price = jsonObject.get("trade_price").toString(); //종가
////                String sPrev_closing_price = jsonObject.get("prev_closing_price").toString(); //전일가
////                String sAcc_trade_price_24h = jsonObject.get("acc_trade_price_24h").toString(); //24시간 누적 거래대금
////                String sAcc_trade_volume_24h = jsonObject.get("acc_trade_volume_24h").toString(); //24시간 누적 거래량
////
////                //나중에 프론트에서 텍스트뷰에서 사용해야 하기 때문에......... 포멧을 예쁘게...
////
//package com.example.wallet_bottom_nav_2;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.EditText;
//import android.widget.Button;
//import android.view.View;
//import android.widget.TextView;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//
//public class coinmarketcap extends AppCompatActivity {
//
//    private RequestQueue requestQueue;
//
//    private static final String TAG = "Main";
//
//    EditText edit_coinNm;
//    public TextView opening_price; //시가
//    public TextView high_price; //고가
//    public TextView low_price; //저가
//    public TextView trade_price; //종가
//    public TextView prev_closing_price; //전일 증가
//    public TextView acc_trade_price_24h; //24시간 누적 거래대금
//    public TextView acc_trade_volume_24h; //24시간 누적 거래량
//    public Button btn_search;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        opening_price = findViewById(R.id.opening_price);
//        high_price = findViewById(R.id.high_price);
//        low_price = findViewById(R.id.low_price);
//        trade_price = findViewById(R.id.trade_price);
//        prev_closing_price = findViewById(R.id.prev_closing_price);
//        acc_trade_price_24h = findViewById(R.id.acc_trade_price_24h);
//        acc_trade_volume_24h = findViewById(R.id.acc_trade_volume_24h);
//
//        Button btn_search = findViewById(R.id.btn_search);
//        btn_search.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                edit_coinNm = findViewById(R.id.edit_coinNm);
//
//                String coinNm = edit_coinNm.getText().toString().toUpperCase();
//
//                if(!coinNm.isEmpty()){
//                    getTicker(coinNm);
//                }
//            }
//        });
//
//        if(requestQueue == null){
//            requestQueue = Volley.newRequestQueue(getApplicationContext());
//        }
//    }
//
//    private void getTicker(String coinNm){
//        final String coinName = coinNm;
//        String url = "https://api.upbit.com/v1/ticker?markets=KRW-"+coinName;
//        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                getTickerData(response);
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d(TAG, "onErrorResponse:" + error.getMessage());
//                    }
//                }) {
//        };
//        request.setShouldCache(false);
//        requestQueue.add(request);
//    }
//    private void getTickerData(String data) {
//
//        try{
//            JSONArray jsonArray = new JSONArray(data);
//
//            for (int i = 0; i< jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                String sPening_price = jsonObject.get("opening_price").toString(); //시가
//                String sHigh_price = jsonObject.get("high_price").toString(); //고가
//                String sLow_price = jsonObject.get("low_price").toString(); //저가
//                String sTrade_price = jsonObject.get("trade_price").toString(); //종가
//                String sPrev_closing_price = jsonObject.get("prev_closing_price").toString(); //전일가
//                String sAcc_trade_price_24h = jsonObject.get("acc_trade_price_24h").toString(); //24시간 누적 거래대금
//                String sAcc_trade_volume_24h = jsonObject.get("acc_trade_volume_24h").toString(); //24시간 누적 거래량
//
//                //나중에 프론트에서 텍스트뷰에서 사용해야 하기 때문에......... 포멧을 예쁘게...
//                opening_price.setText((int) Double.parseDouble(sPening_price));
//                high_price.setText((int) Double.parseDouble(sHigh_price));
//                low_price.setText((int) Double.parseDouble(sLow_price));
//                trade_price.setText((int) Double.parseDouble(sTrade_price));
//                prev_closing_price.setText((int) Double.parseDouble(sPrev_closing_price));
//                acc_trade_price_24h.setText((int) Double.parseDouble(sAcc_trade_price_24h));
//                acc_trade_volume_24h.setText((int) Double.parseDouble(sAcc_trade_volume_24h));
////                opening_price.setText(toDoubleFormat(Double.parseDouble(sPpening_price)));
////                high_price.setText(toDoubleFormat(Double.parseDouble(sHigh_price)));
////                low_price.setText(toDoubleFormat(Double.parseDouble(sLow_price)));
////                trade_price.setText(toDoubleFormat(Double.parseDouble(sTrade_price)));
////                prev_closing_price.setText(toDoubleFormat(Double.parseDouble(sPrev_closing_price)));
////                acc_trade_price_24h.setText(toDoubleFormat(Double.parseDouble(sAcc_trade_price_24h)));
////                acc_trade_volume_24h.setText(toDoubleFormat(Double.parseDouble(sAcc_trade_volume_24h)));
////            }
////        }catch (JSONException e){
////            e.printStackTrace();
////        }
////    }
////}
////// 유효숫자 맞추는 코드는 나중에..
//            }
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//    }
//}
//// 유효숫자 맞추는 코드는 나중에..
