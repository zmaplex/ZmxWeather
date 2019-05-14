package com.example.zmxweather.di.module;

import com.example.zmxweather.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class RetrofitModule {
    private String mUrl;

    public RetrofitModule(String url) {
        mUrl = url;
    }

    @ActivityScope
    @Provides
    public Retrofit provideApiClient(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(mUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

}
