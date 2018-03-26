package com.heyi.demo.gestureLock;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.heyi.demo.R;
import com.heyi.demo.gestureLock.widget.MyStyleLockView;
import com.sevenheaven.gesturelock.GestureLock;
import com.sevenheaven.gesturelock.GestureLockView;

/**
 * todo 其实这个封装的并不好（或者说作者只是给提供一个基础的绘制功能）之后可以看下小智的封装方式，来考虑下自己怎么封装合适自己公司的业务逻辑（或者可以写一个通用的）
 */
public class GestureLockActivity extends AppCompatActivity {

    GestureLock gestureView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_lock);

        gestureView = findViewById(R.id.gesture_lock);
        gestureView.setAdapter(new GestureLock.GestureLockAdapter() {
            @Override
            public int getDepth() {
                return 3;
            }

            @Override
            public int[] getCorrectGestures() {
                return new int[]{0, 1, 2, 5, 8};
            }

            @Override
            public int getUnmatchedBoundary() {
                return 5;
            }

            @Override
            public int getBlockGapSize(){
                return 10;
            }

            @Override
            public GestureLockView getGestureLockViewInstance(Context context, int position) {
                return new MyStyleLockView(context);
//                if(position % 2 == 0){
//                    return new MyStyleLockView(context);
//                }else{
//                    return new NexusStyleLockView(context);
//                }
            }
        });

        gestureView.setOnGestureEventListener(new GestureLock.OnGestureEventListener(){

            @Override
            public void onGestureEvent(boolean matched) {
                Toast.makeText(GestureLockActivity.this, "Match:" + matched, Toast.LENGTH_SHORT).show();
                gestureView.clear();
            }

            @Override
            public void onUnmatchedExceedBoundary() {
                Toast.makeText(GestureLockActivity.this, "输入5次错误!30秒后才能输入", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBlockSelected(int position) {
                Log.d("position", position + "");
            }

        });
    }
}
