package com.heyi.demo.testApt;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Constructor;

public class InjectHelper {

    public static void inject(Activity host){
        String classFullName = host.getClass().getName() + "$$ViewInjector";
        try {
            Log.e("InjectHelper", "正常执行");
            Class proxy = Class.forName(classFullName);
            Constructor constructor = proxy.getConstructor(host.getClass());
            constructor.newInstance(host);
        } catch (Exception e) {
            Log.e("InjectHelper", "有了exception");
            e.printStackTrace();
        }
    }

}
