package com.example.zmxweather.di.component;

import com.example.zmxweather.di.module.WeatherModule;
import com.example.zmxweather.mvp.ui.WeatherViewActivity;

import dagger.Component;

@Component(modules = WeatherModule.class)
public interface WeatherComponent {
    void inject(WeatherViewActivity activity);
}
