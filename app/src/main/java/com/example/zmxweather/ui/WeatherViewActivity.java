package com.example.zmxweather.ui;

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
import com.example.zmxweather.presenter.IWeatherPresenter;
import com.example.zmxweather.presenter.WeatherPresenter;
import com.example.zmxweather.view.IWeatherView;

import java.util.List;

public class WeatherViewActivity extends AppCompatActivity implements IWeatherView, SearchView.OnQueryTextListener {
    //初始化城市数据

    IWeatherPresenter mIWeatherPresenter;
    CityAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        init();
    }

    private void init() {
        mIWeatherPresenter = new WeatherPresenter(this);
        mIWeatherPresenter.getCityData();
        recyclerView = findViewById(R.id.recyclerView_City);
        adapter = new CityAdapter();
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


        mIWeatherPresenter.getFilterCity(adapter.getCityBeans(), query);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()) {
            mIWeatherPresenter.getCityData();
        }
        return false;
    }

}
