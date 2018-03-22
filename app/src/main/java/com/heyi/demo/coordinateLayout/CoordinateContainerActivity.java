package com.heyi.demo.coordinateLayout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.heyi.demo.R;
import com.heyi.demo.quickRv.SimpleAdapter;

// ==================== note

// activity_coordinate_layout_1: 是最简单的布局。
// 1 就是 AppBarLayout 中有两个子view，上滑隐藏的view加app:layout_scrollFlags="scroll|enterAlwaysCollapsed"，另一个什么都不加
// 2 在本例中，每个子view都是继承自View，其实如果是LinearLayout之类的ViewGroup完全是一样的

// activity_coordinate_layout_2: 用了 CollpsingToolbarLayout（但是非常简洁）
//1 collapsingLayout 设置
//      app:layout_scrollFlags="scroll|exitUntilCollapsed"
//      app:contentScrim="@color/colorPrimary"
//      app:title="collapsing"
//2 imageview 设置
//      app:collapseMode
//      设置 adjustViewBounds   是否保持iv宽高比
//3 CollapsingToolBarLayout 中如果有一个Toolbar，只设置了宽高（宽 match_parent 高 任何一个固定的值，非wrap_content）
//  经测试，如果没有 Toolbar，是任意一个view，上滑的时候最终都滑上去了，并没有保持一个固定的最小高度

public class CoordinateContainerActivity extends AppCompatActivity {

    public static final String PARAMS_TYPE = "params_type";
    public static final int TYPE_SIMPLE = 1001;
    public static final int TYPE_SIMPLE_COLLAPSING = 1002;
    public static final int TYPE_KEHUDANG_SIMPLE = 1003;
    public static final int TYPE_KEHUDANG_HARD = 1004;

    public static void newInstance(Context context, int type) {
        Intent intent = new Intent(context, CoordinateContainerActivity.class);
        intent.putExtra(PARAMS_TYPE, type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int resId = 0;
        switch (getIntent().getIntExtra(PARAMS_TYPE, TYPE_SIMPLE)){
            case TYPE_SIMPLE:
                resId = R.layout.activity_coordinate_layout_1;
                break;
            case TYPE_SIMPLE_COLLAPSING:
                resId = R.layout.activity_coordinate_layout_2;
                break;
            case TYPE_KEHUDANG_SIMPLE:
                resId = R.layout.activity_heyi_coordinate;
                break;
            case TYPE_KEHUDANG_HARD:
                resId = R.layout.activity_heyi_coordinate_2;
                break;
        }
        setContentView(resId);

        quickRv();
    }

    private void quickRv() {
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new SimpleAdapter());
    }


}
