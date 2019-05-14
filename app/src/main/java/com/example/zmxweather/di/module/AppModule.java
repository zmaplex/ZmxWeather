package com.example.zmxweather.di.module;

import com.example.zmxweather.ZmApplication;
import com.example.zmxweather.utils.HttpCacheInterceptor;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


@Module
public class AppModule {
    private boolean mDebug;

    public AppModule(boolean debug) {
        mDebug = debug;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        //设置缓存100M
        Cache cache = new Cache(new File(ZmApplication.getContext().getCacheDir(), "httpCache"), 1024 * 1024 * 100);
        return new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .addInterceptor(
                        new HttpLoggingInterceptor().setLevel(
                                mDebug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .build();
    }
}
