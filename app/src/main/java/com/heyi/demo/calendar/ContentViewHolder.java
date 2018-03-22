package com.heyi.demo.calendar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.heyi.demo.R;

public class ContentViewHolder extends RecyclerView.ViewHolder {

    public TextView tvDay;

    public ContentViewHolder(View itemView) {
        super(itemView);
        tvDay = itemView.findViewById(R.id.tv_day);
    }
}
