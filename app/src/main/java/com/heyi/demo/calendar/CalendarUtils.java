package com.heyi.demo.calendar;

import android.util.Log;

import java.util.Calendar;

public class CalendarUtils {

    public static final String TAG = "CalendarUtils";

    public static int getActualMonth(Calendar calendar){
        return calendar.get(Calendar.MONTH) + 1;
    }

    // 为了看一些api是什么意思
    public static void log(Calendar calendar){
        Log.e(TAG, "getFirstDayOfWeek: " + calendar.getFirstDayOfWeek());

    }

    // 传入1，返回周二
    public static String numToStringWeeks(int day){
        switch (day){
            case 0:
                return "周一";
            case 1:
                return "周二";
            case 2:
                return "周三";
            case 3:
                return "周四";
            case 4:
                return "周五";
            case 5:
                return "周六";
            case 6:
                return "周日";
        }
        return "周几";
    }
}
