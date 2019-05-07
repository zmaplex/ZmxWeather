package com.example.zmxweather.mvp.presenter;

import com.example.zmxweather.bean.CityBean;
import com.example.zmxweather.mvp.model.IWeatherModel;
import com.example.zmxweather.mvp.model.WeatherModel;
import com.example.zmxweather.mvp.view.IWeatherView;
import java.util.List;
import timber.log.Timber;

public class WeatherPresenter implements IWeatherPresenter {
    private IWeatherView mIWeatherView;
    private IWeatherModel mIWeatherModel;

    public WeatherPresenter(IWeatherView weatherView) {
        mIWeatherView = weatherView;
        mIWeatherModel = new WeatherModel(this);
    }

    @Override
    public void getCityData() {
        mIWeatherModel.getCityData();
    }

    @Override
    public void getCityDataSuccess(List<CityBean> cityBeans) {
        Timber.e("getCityDataSuccess回调");
        mIWeatherView.setCity(cityBeans);
    }

    @Override
    public void getFilterCity(List<CityBean> cityBeans, String key) {
        mIWeatherModel.filterCity(cityBeans, key);
    }

    @Override
    public void getFilterCityFail(Throwable e) {

    }

    @Override
    public void getFilterCitySuccess(List<CityBean> cityBeans) {

    }

    @Override
    public void getCityDataFail(Throwable e) {

    }


}
