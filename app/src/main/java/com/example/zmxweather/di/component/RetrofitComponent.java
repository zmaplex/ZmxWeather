package com.example.zmxweather.di.component;

import com.example.zmxweather.adapters.CityAdapter;
import com.example.zmxweather.di.module.RetrofitModule;
import com.example.zmxweather.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = RetrofitModule.class, dependencies = AppComponent.class)
public interface RetrofitComponent {
    void inject(CityAdapter cityAdapter);
}
