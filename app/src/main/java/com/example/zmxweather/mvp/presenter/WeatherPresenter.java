package com.example.zmxweather.mvp.presenter;

import com.example.zmxweather.bean.CityBean;
import com.example.zmxweather.mvp.model.IWeatherModel;
import com.example.zmxweather.mvp.view.IWeatherView;
import com.zmaplex.common.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import timber.log.Timber;

public class WeatherPresenter extends BasePresenter<IWeatherModel, IWeatherView> implements IWeatherPresenter {

    Retrofit retrofit;

    @Inject
    public WeatherPresenter(IWeatherModel WeatherModel, IWeatherView weatherView, Retrofit retrofit) {
        super(WeatherModel, weatherView);
        this.retrofit = retrofit;

    }

    @Override
    public Retrofit getRetrofit() {
        return retrofit;
    }


    @Override
    public void getCityData() {
        mModel.getCityData(this);
    }

    @Override
    public void getCityDataSuccess(List<CityBean> cityBeans) {
        Timber.e("getCityDataSuccess回调");
        mView.setCity(cityBeans);
    }

    @Override
    public void getFilterCity(List<CityBean> cityBeans, String key) {
        mModel.filterCity(cityBeans, key, this);
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
