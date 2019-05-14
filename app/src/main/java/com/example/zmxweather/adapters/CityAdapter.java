package com.example.zmxweather.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zmxweather.AppConfig;
import com.example.zmxweather.R;
import com.example.zmxweather.ZmApplication;
import com.example.zmxweather.api.ApiWeatherService;
import com.example.zmxweather.bean.CityBean;
import com.example.zmxweather.bean.WeatherBean;
import com.example.zmxweather.di.component.DaggerRetrofitComponent;
import com.example.zmxweather.di.module.RetrofitModule;
import com.example.zmxweather.utils.RetrofitManger;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import timber.log.Timber;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    @Inject
    Retrofit retrofit;
    private List<CityBean> cityBeans = new ArrayList<>();

    public CityAdapter() {
        DaggerRetrofitComponent.builder().retrofitModule(new RetrofitModule(AppConfig.weather_url))
                .appComponent(ZmApplication.getAppComponent())
                .build()
                .inject(this);
    }

    public List<CityBean> getCityBeans() {
        return cityBeans;
    }

    public void updateData(List<CityBean> cityBeans) {
        this.cityBeans = cityBeans;
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.city_lists, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        String cityCode = cityBeans.get(position).getCity_code();
        holder.textCityNameView.setText(cityBeans.get(position).getCity_name());
        holder.textCityCodeView.setText(cityCode);
        retrofit.create(ApiWeatherService.class)
                .getCityWeather(cityCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        String humidity = weatherBean.getData().getShidu();
                        String temperature = weatherBean.getData().getWendu();
                        String climate = weatherBean.getData().getForecast().get(0).getType();
                        holder.temperatureTextView.setText(temperature + "°C");
                        holder.humidityTextView.setText(humidity + "  " + climate);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    @Override
    public int getItemCount() {
        return cityBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textCityNameView;
        TextView textCityCodeView;
        TextView temperatureTextView;
        TextView humidityTextView;

        ViewHolder(View itemView) {
            super(itemView);
            this.textCityNameView = itemView.findViewById(R.id.textCityNameView);
            this.textCityCodeView = itemView.findViewById(R.id.textCityCodeView);
            this.temperatureTextView = itemView.findViewById(R.id.temperatureTextView);
            this.humidityTextView = itemView.findViewById(R.id.humidityTextView);

        }
    }
}

