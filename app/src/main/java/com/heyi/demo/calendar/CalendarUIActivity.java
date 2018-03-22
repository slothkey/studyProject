package com.heyi.demo.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.heyi.demo.R;

import java.util.ArrayList;
import java.util.Calendar;

public class CalendarUIActivity extends AppCompatActivity {

    private static final String TAG = "CalendarUIActivity";
    private final int FRAGMENTS_COUNT = 4;
    public static final int INITIAL_ITEM = 4 * 120;

    public static int sCurrentPagePosition = 0;


    ArrayList<CalendarFragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_ui);

        ViewPager vp = findViewById(R.id.vp);

        for(int i = 0; i < FRAGMENTS_COUNT; i++){
            Calendar calendar = Calendar.getInstance();
            fragments.add(new CalendarFragment(calendar, vp, i));
        }

        vp.setAdapter(new VpAdapter(getSupportFragmentManager(), fragments, Calendar.getInstance()));
        vp.setCurrentItem(INITIAL_ITEM);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                sCurrentPagePosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
