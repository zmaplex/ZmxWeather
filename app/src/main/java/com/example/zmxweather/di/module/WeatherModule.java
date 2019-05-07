package com.example.zmxweather.di.module;

import com.example.zmxweather.adapters.CityAdapter;
import com.example.zmxweather.mvp.presenter.WeatherPresenter;
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
    public WeatherPresenter providesWeatherPresenter() {
        return new WeatherPresenter(mIWeatherView);
    }

    @Provides
    public CityAdapter providesCityAdapter() {
        return new CityAdapter();
    }
}
