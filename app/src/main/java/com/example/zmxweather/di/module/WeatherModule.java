package com.example.zmxweather.di.module;

import com.example.zmxweather.adapters.CityAdapter;
import com.example.zmxweather.mvp.model.IWeatherModel;
import com.example.zmxweather.mvp.model.WeatherModel;
import com.example.zmxweather.mvp.view.IWeatherView;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModule {
    private IWeatherView mIWeatherView;

    public WeatherModule(IWeatherView weatherView) {
        mIWeatherView = weatherView;

    }

    @Provides
    public IWeatherView providesWeatherView() {
        return mIWeatherView;
    }

    @Provides
    public IWeatherModel providesWeatherModel(WeatherModel model) {
        return model;
    }

    @Provides
    public CityAdapter providesCityAdapter() {
        return new CityAdapter();
    }
}
