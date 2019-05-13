package com.example.zmxweather.mvp.model;

import com.example.zmxweather.bean.CityBean;
import com.example.zmxweather.mvp.presenter.IWeatherPresenter;
import com.zmaplex.common.BaseModel;

import java.util.List;

public interface IWeatherModel extends BaseModel {
    void getCityData(IWeatherPresenter mWeatherPresenter);

    void filterCity(List<CityBean> cityBeans, String key, IWeatherPresenter mWeatherPresenter);

}
