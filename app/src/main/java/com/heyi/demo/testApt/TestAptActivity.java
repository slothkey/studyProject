package com.heyi.demo.testApt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alamkanak.annotations.BindView;
import com.heyi.demo.R;

public class TestAptActivity extends AppCompatActivity{

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_apt);

        InjectHelper.inject(this);
        tv.setText("I am injected");
    }
}
