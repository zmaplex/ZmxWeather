package com.example.zmxweather.di.component;

import com.example.zmxweather.adapters.CityAdapter;
import com.example.zmxweather.di.module.RetrofitModule;
import com.example.zmxweather.di.scope.ActivityScope;
import com.example.zmxweather.mvp.model.WeatherModel;
import com.example.zmxweather.mvp.ui.WeatherViewActivity;

import dagger.Component;

@ActivityScope
@Component(modules = RetrofitModule.class, dependencies = AppComponent.class)
public interface RetrofitComponent {
    void inject(CityAdapter cityAdapter);
    //void inject(WeatherViewActivity weatherViewActivity);
}
