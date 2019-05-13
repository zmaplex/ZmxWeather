package com.example.zmxweather.mvp.view;

import com.example.zmxweather.bean.CityBean;
import com.zmaplex.common.BaseView;

import java.util.List;

public interface IWeatherView extends BaseView {
    //初始化城市数据
    void setCity(List<CityBean> cityBeans);
}
