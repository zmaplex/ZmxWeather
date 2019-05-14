package com.example.zmxweather.mvp.presenter;

import com.example.zmxweather.bean.CityBean;

import java.util.List;

import retrofit2.Retrofit;

public interface IWeatherPresenter {
    void getCityData();

    Retrofit getRetrofit();
    void getCityDataSuccess(List<CityBean> cityBeans);

    void getCityDataFail(Throwable e);

    void getFilterCity(List<CityBean> cityBeans, String key);

    void getFilterCitySuccess(List<CityBean> cityBeans);

    void getFilterCityFail(Throwable e);
}
