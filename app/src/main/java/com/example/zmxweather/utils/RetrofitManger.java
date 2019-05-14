package com.example.zmxweather.utils;

import com.example.zmxweather.ZmApplication;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManger {
    public static boolean isDebug = false;
    private static RetrofitManger mInstance;

    public static synchronized RetrofitManger getInstance() {
        if (mInstance == null)
            mInstance = new RetrofitManger();
        return mInstance;
    }

    public void deBug(boolean isDebug) {
        RetrofitManger.isDebug = isDebug;
    }

    // create retrofit singleton
    @Deprecated
    public Retrofit createApiClient(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createOkHttpClient(isDebug))
                .build();
    }

    // create okHttpClient singleton
    private OkHttpClient createOkHttpClient(boolean debug) {
        //设置缓存100M
        Cache cache = new Cache(new File(ZmApplication.getContext().getCacheDir(), "httpCache"), 1024 * 1024 * 100);
        return new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .addInterceptor(
                        new HttpLoggingInterceptor().setLevel(
                                debug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .build();
    }
}