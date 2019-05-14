package com.example.zmxweather.mvp.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zmxweather.AppConfig;
import com.example.zmxweather.R;
import com.example.zmxweather.ZmApplication;
import com.example.zmxweather.adapters.CityAdapter;
import com.example.zmxweather.bean.CityBean;
import com.example.zmxweather.di.component.DaggerWeatherComponent;
import com.example.zmxweather.di.module.RetrofitModule;
import com.example.zmxweather.di.module.WeatherModule;
import com.example.zmxweather.mvp.presenter.WeatherPresenter;
import com.example.zmxweather.mvp.view.IWeatherView;
import com.zmaplex.common.BaseMVPActivity;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class WeatherViewActivity extends BaseMVPActivity<WeatherPresenter> implements IWeatherView, SearchView.OnQueryTextListener {

    @Inject
    WeatherPresenter mWeatherPresenter;
    @Inject
    CityAdapter adapter;
    @Inject
    Retrofit retrofit;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        DaggerWeatherComponent.builder()
                .weatherModule(new WeatherModule(this))
                .retrofitModule(new RetrofitModule(AppConfig.city_url))
                .appComponent(ZmApplication.getAppComponent())
                .build()
                .inject(this);
        init();
    }

    private void init() {

        mWeatherPresenter.getCityData();
        recyclerView = findViewById(R.id.recyclerView_City);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void setCity(List<CityBean> cityBeans) {
        adapter.updateData(cityBeans);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mWeatherPresenter.getFilterCity(adapter.getCityBeans(), query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()) {
            mWeatherPresenter.getCityData();
        }
        return false;
    }

}
