package com.heyi.demo.coordinateLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.heyi.demo.R;

public class CoordinateActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);

        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                CoordinateContainerActivity.newInstance(this, CoordinateContainerActivity.TYPE_SIMPLE);
                break;
            case R.id.bt2:
                CoordinateContainerActivity.newInstance(this, CoordinateContainerActivity.TYPE_SIMPLE_COLLAPSING);
                break;
            case R.id.bt3:
                CoordinateContainerActivity.newInstance(this, CoordinateContainerActivity.TYPE_KEHUDANG_SIMPLE);
                break;
            case R.id.bt4:
                CoordinateContainerActivity.newInstance(this, CoordinateContainerActivity.TYPE_KEHUDANG_HARD);
                break;
        }
    }
}
