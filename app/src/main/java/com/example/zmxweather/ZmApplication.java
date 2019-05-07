package com.example.zmxweather;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

public class ZmApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return ZmApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
