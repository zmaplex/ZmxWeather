package com.example.zmxweather;

import android.app.Application;
import android.content.Context;

import com.example.zmxweather.di.component.AppComponent;
import com.example.zmxweather.di.component.DaggerAppComponent;
import com.example.zmxweather.di.module.AppModule;

import timber.log.Timber;

public class ZmApplication extends Application {
    private static Context context;
    private static AppComponent mAppComponent;
    public static Context getContext() {
        return ZmApplication.context;
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(true))
                    .build();
        } else {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(false))
                    .build();
        }
    }
}
