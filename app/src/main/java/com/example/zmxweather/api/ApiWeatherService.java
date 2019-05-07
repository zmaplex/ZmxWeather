package com.example.zmxweather.api;

import com.example.zmxweather.bean.WeatherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiWeatherService {
    //weather/city/101030100

    @GET("weather/city/{cityCode}")
    Observable<WeatherBean> getCityWeather(@Path("cityCode") String cityCode);

}
