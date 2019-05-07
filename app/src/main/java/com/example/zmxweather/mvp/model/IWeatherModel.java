package com.example.zmxweather.mvp.model;

import com.example.zmxweather.bean.CityBean;

import java.util.List;

public interface IWeatherModel {
    void getCityData();

    void filterCity(List<CityBean> cityBeans, String key);

}
