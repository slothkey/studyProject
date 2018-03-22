package com.heyi.demo.quickRv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heyi.demo.R;

public class SimpleAdapter extends RecyclerView.Adapter<ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText("这是第： " + position +" 个");
    }

    @Override
    public int getItemCount() {
        return 30;
    }
}
