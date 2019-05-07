package com.example.zmxweather.presenter;

import com.example.zmxweather.bean.CityBean;

import java.util.List;

public interface IWeatherPresenter {
    void getCityData();

    void getCityDataSuccess(List<CityBean> cityBeans);

    void getCityDataFail(Throwable e);

    void getFilterCity(List<CityBean> cityBeans, String key);

    void getFilterCitySuccess(List<CityBean> cityBeans);

    void getFilterCityFail(Throwable e);
}
