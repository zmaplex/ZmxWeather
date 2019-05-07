package com.example.zmxweather.api;

import com.example.zmxweather.bean.CityBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfaceService {
    @GET("_city.json")
    Observable<List<CityBean>> getChinaCities();
}
