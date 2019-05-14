package com.example.zmxweather.di.component;

import com.example.zmxweather.di.module.RetrofitModule;
import com.example.zmxweather.di.module.WeatherModule;
import com.example.zmxweather.di.scope.ActivityScope;
import com.example.zmxweather.mvp.ui.WeatherViewActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {WeatherModule.class, RetrofitModule.class}, dependencies = AppComponent.class)
public interface WeatherComponent {
    void inject(WeatherViewActivity activity);
}
