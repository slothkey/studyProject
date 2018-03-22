package com.heyi.demo.calendar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.heyi.demo.R;

public class TitleViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle;

    public TitleViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv);
    }
}
