package com.heyi.demo;

import android.annotation.SuppressLint;
import android.app.Application;

import org.greenrobot.eventbus.EventBus;

public class StudyApplication extends Application {

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate() {
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();

    }
}
