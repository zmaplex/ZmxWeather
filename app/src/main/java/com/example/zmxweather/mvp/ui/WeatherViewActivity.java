package com.example.zmxweather.mvp.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zmxweather.R;
import com.example.zmxweather.adapters.CityAdapter;
import com.example.zmxweather.bean.CityBean;
import com.example.zmxweather.di.component.DaggerWeatherComponent;
import com.example.zmxweather.di.module.WeatherModule;
import com.example.zmxweather.mvp.presenter.WeatherPresenter;
import com.example.zmxweather.mvp.view.IWeatherView;

import java.util.List;

import javax.inject.Inject;

public class WeatherViewActivity extends AppCompatActivity implements IWeatherView, SearchView.OnQueryTextListener {
    //初始化城市数据
    @Inject
    WeatherPresenter mWeatherPresenter;
    @Inject
    CityAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        DaggerWeatherComponent.builder()
                .weatherModule(new WeatherModule(this))
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
