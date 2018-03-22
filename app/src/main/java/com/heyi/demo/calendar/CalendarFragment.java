package com.heyi.demo.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heyi.demo.R;

import java.util.Calendar;


public class CalendarFragment extends Fragment {

    private static final String TAG = "CalendarFragment";
    private View outer;
    private TextView tvTitle;
    private RecyclerView rv;

    private Calendar mCalendar;
    private ViewPager mViewPager;
    private int mIndex;

    @SuppressLint("ValidFragment")
    public CalendarFragment(Calendar calendar, ViewPager viewPager, int i){
        this.mCalendar = calendar;
        this.mViewPager = viewPager;
        mIndex = i;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach" + mViewPager.getCurrentItem());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate" + mViewPager.getCurrentItem());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView" + mViewPager.getCurrentItem());
        outer = inflater.inflate(R.layout.fragment_calendar, container, false);
        tvTitle = outer.findViewById(R.id.tv_title);
        rv = outer.findViewById(R.id.rv);
        return outer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onActivityCreated" + mViewPager.getCurrentItem());
        super.onActivityCreated(savedInstanceState);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mCalendar.getTimeInMillis());
        tvTitle.setText(mCalendar.get(Calendar.YEAR) + "年" + CalendarUtils.getActualMonth(mCalendar) + "月");
        rv.setLayoutManager(new GridLayoutManager(getContext(), 7));
        RvAdapter adapter = new RvAdapter(mCalendar, mIndex);
        rv.setAdapter(adapter);
    }

    public Calendar getCalendar(){
        return mCalendar;
    }
}