package com.heyi.demo.calendar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.Calendar;

import static com.heyi.demo.calendar.CalendarUIActivity.INITIAL_ITEM;

public class VpAdapter extends FragmentStatePagerAdapter {

    private ArrayList<CalendarFragment> fragments;
    private Calendar mCalendar;

    public VpAdapter(FragmentManager fm, ArrayList<CalendarFragment> fragments, Calendar calendar) {
        super(fm);
        this.fragments = fragments;
        this.mCalendar = calendar;
    }

    @Override
    public Fragment getItem(int position) {
        int realPosition = position % fragments.size();
        CalendarFragment fragment = fragments.get(realPosition);
        Calendar calendar = fragment.getCalendar();
        calendar.setTimeInMillis(mCalendar.getTimeInMillis());
        calendar.add(Calendar.MONTH, position - INITIAL_ITEM);
        return fragment;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
