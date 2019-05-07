package com.example.zmxweather;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zmxweather.api.ApiInterfaceService;
import com.example.zmxweather.bean.CityBean;
import com.example.zmxweather.utils.RetrofitManger;
import com.example.zmxweather.view.WeatherView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, WeatherView.class);
        startActivity(intent);
    }

}
