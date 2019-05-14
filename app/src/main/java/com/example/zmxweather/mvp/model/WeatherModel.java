package com.example.zmxweather.mvp.model;

import com.example.zmxweather.AppConfig;
import com.example.zmxweather.api.ApiInterfaceService;
import com.example.zmxweather.bean.CityBean;
import com.example.zmxweather.mvp.presenter.IWeatherPresenter;
import com.example.zmxweather.mvp.presenter.WeatherPresenter;
import com.example.zmxweather.utils.RetrofitManger;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import timber.log.Timber;

public class WeatherModel implements IWeatherModel {

    @Inject
    public WeatherModel() {

    }

    @Override
    public void filterCity(List<CityBean> cityBeans, String key, IWeatherPresenter mWeatherPresenter) {
        Observable.create((ObservableOnSubscribe<List<CityBean>>) e -> {
            List<CityBean> mCityBeans;
            mCityBeans = cityBeans.stream()
                    .filter(cityBean -> cityBean.getCity_name().contains(key))
                    .collect(Collectors.toList());
            e.onNext(mCityBeans);
            e.onComplete();
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CityBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<CityBean> cityBeans) {
                        mWeatherPresenter.getCityDataSuccess(cityBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mWeatherPresenter.getFilterCityFail(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void getCityData(IWeatherPresenter mWeatherPresenter) {
        Retrofit retrofit = mWeatherPresenter.getRetrofit();
        retrofit.create(ApiInterfaceService.class)
                .getChinaCities()
                //RxJava 变换
                .map(cityBeans -> {
                    //过滤没有城市代码的元素
                    return cityBeans.stream()
                            .filter(cityBean -> !cityBean.getCity_code().isEmpty())
                            .collect(Collectors.toList());
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CityBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<CityBean> cityBeans) {
                        mWeatherPresenter.getCityDataSuccess(cityBeans);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);
                        mWeatherPresenter.getCityDataFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {

    }
}
