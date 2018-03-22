package com.heyi.demo.coordinateLayout;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.heyi.demo.R;
import com.heyi.demo.SpUtils;

import java.util.ArrayList;

public class KehudangBehavior extends CoordinatorLayout.Behavior {

    private static final String TAG = "KehudangBehavior";

    public KehudangBehavior(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.e(TAG, "dependency y: " + dependency.getY() + " height: " + dependency.getHeight());
        child.setTranslationY(dependency.getY());
        int startValue = SpUtils.dip2px(child.getContext(), 140);
        int endValue = SpUtils.dip2px(child.getContext(), 178);
        if(Math.abs(dependency.getY()) > startValue){
            float percent = (Math.abs(dependency.getY()) - startValue) / (endValue - startValue);
            ArrayList<View> childs = new ArrayList<>();
            childs.add(child.findViewById(R.id.iv_collapse_1));
            childs.add(child.findViewById(R.id.iv_collapse_2));
            childs.add(child.findViewById(R.id.iv_collapse_3));
            childs.add(child.findViewById(R.id.iv_collapse_4));
            for(View each: childs){
                each.setAlpha(1f - percent);
                each.setScaleX(1f - percent);
                each.setScaleY(1f- percent);
            }
        }
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
