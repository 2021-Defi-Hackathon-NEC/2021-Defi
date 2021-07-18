package com.example.wallet_bottom_nav_2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomSpinnerAdapter extends ArrayAdapter<String>{
    String[] spinnerCoins;
    int[] spinnerImages;
    Context mContext;

    public CustomSpinnerAdapter(@NonNull login_2 context, String[] titles, int[] images) {
        super(context, R.layout.spinner_row);
        this.spinnerCoins = titles;
        this.spinnerImages = images;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return spinnerCoins.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.spinner_row, parent, false);
            mViewHolder.mCoin = (ImageView) convertView.findViewById(R.id.imageView_spinner_image);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textview_spinner_name);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mCoin.setImageResource(spinnerImages[position]);
        mViewHolder.mName.setText(spinnerCoins[position]);

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
    private static class ViewHolder {
        ImageView mCoin;
        TextView mName;
    }

}
