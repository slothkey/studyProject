package com.heyi.demo.quickRv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.heyi.demo.R;

public class ViewHolder extends RecyclerView.ViewHolder{

    public TextView tv;

    public ViewHolder(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.tv);
    }
}
