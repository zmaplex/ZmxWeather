package com.example.zmxweather.model;

import com.example.zmxweather.bean.CityBean;

import java.util.List;

public interface IWeatherModel {
    void getCityData();

    void filterCity(List<CityBean> cityBeans, String key);

}
