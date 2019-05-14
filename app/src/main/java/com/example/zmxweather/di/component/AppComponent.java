package com.example.zmxweather.di.component;

import com.example.zmxweather.di.module.AppModule;


import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    OkHttpClient okHttpClient();
}
