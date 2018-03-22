package com.heyi.demo.calendar;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.heyi.demo.R;

import java.util.Calendar;

public class RvAdapter extends RecyclerView.Adapter {

    private static final String TAG = "RvAdapter";

    private static final int TYPE_TITLE = 1001;
    private static final int TYPE_CONTENT = 1002;

    private int firstDay; // 显示的第一个是上月的第几号
    private int firstDayInMonth; // 本月的第一天是周几
    private int lastDayInMonth; // 本月的最后一天是周几
    private int lastDay; // 显示的最后一个是下月的第几号
    private int lineCounts; // 一共显示多少行

    public RvAdapter(Calendar calendar, int index){
        initDays(calendar);
    }

    public void initDays(Calendar pCalendar) {
        if(pCalendar == null){
            return;
        }
        // 周几：周一返回2 周日返回1
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(pCalendar.getTimeInMillis());
        calendar.set(Calendar.DATE, 1);  // 3月1日
        firstDayInMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 如果是周一，是1；如果是周日，是0；
        firstDayInMonth = firstDayInMonth == 0 ? 7 : firstDayInMonth; // 把周日改成7
        calendar.add(Calendar.DATE, -1); // 现在变成上个月的最后一天了 2月28日
        firstDay = calendar.get(Calendar.DATE) - firstDayInMonth + 2;
        calendar.add(Calendar.DATE, 1); // 3月1日
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1); // 4月1日
        calendar.add(Calendar.DATE, -1); // 3月31日
        lastDayInMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        lastDayInMonth = lastDayInMonth == 0 ? 7 : lastDayInMonth;
        lastDay = 7 - lastDayInMonth;
        lineCounts = (firstDayInMonth + calendar.get(Calendar.DATE) + lastDay - 1) / 7;
        Log.e(TAG, "month: " + calendar.get(Calendar.MONTH) + " " + firstDay + " " + firstDayInMonth + " " + lastDayInMonth + " " + lastDay + " ");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_TITLE){
            return new TitleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false));
        }else if(viewType == TYPE_CONTENT){
            return new ContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_TITLE){
            TitleViewHolder titleHolder = (TitleViewHolder) holder;
            titleHolder.tvTitle.setText(CalendarUtils.numToStringWeeks(position));
        }else if(getItemViewType(position) == TYPE_CONTENT){
            ContentViewHolder titleHolder = (ContentViewHolder) holder;
            int realPosition = position - 7;
            if(realPosition <= firstDayInMonth - 2){ // 说明是上个月的
                titleHolder.tvDay.setText("" + (realPosition + firstDay));
                titleHolder.tvDay.setTextColor(Color.GRAY);
            }else if(realPosition >= getItemCount() - 7 - lastDay){ // 说明是下个月的
                titleHolder.tvDay.setText((realPosition - (getItemCount() - 7 - lastDay) + 1) + "");
                titleHolder.tvDay.setTextColor(Color.GRAY);
            }else{
                titleHolder.tvDay.setText((realPosition - firstDayInMonth + 2) + "");
                titleHolder.tvDay.setTextColor(Color.BLACK);
            }

        }
    }

    @Override
    public int getItemCount() {
        return (lineCounts + 1) * 7;
    }

    @Override
    public int getItemViewType(int position) {
        if(position < 7){
            return TYPE_TITLE;
        }
        return TYPE_CONTENT;
    }


}
