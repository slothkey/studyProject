package com.heyi.demo.annotation;

import android.util.Log;

public class TestClass {

    private static final String TAG = "TestClass";

    @BindAddress()
    private String adddress;
    @BindPort()
    private String port;

    public void printInfo(){
        Log.e(TAG, "info is: " + adddress + ":" + port);
    }

    @BindGet("mike")
    void getHttp(String param){
        String url = "http://www.baidu.com/?username"+param;
        Log.e(TAG, url);
    }
}
