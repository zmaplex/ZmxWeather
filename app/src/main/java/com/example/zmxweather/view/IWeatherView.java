package com.example.zmxweather.view;

import com.example.zmxweather.bean.CityBean;

import java.util.List;

public interface IWeatherView {
    //初始化城市数据
    void setCity(List<CityBean> cityBeans);
}
