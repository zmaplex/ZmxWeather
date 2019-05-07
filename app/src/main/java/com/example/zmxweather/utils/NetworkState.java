package com.example.zmxweather.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NetworkState {

    @Nullable
    private ConnectivityManager connectivity;
    @Nullable
    private NetworkInfo networkInfo;

    private NetworkState(@NonNull Context context) {
        this.connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        this.networkInfo = this.connectivity != null ? this.connectivity.getActiveNetworkInfo() : null;
    }

    /**
     * 获取网络状态
     *
     * @param context Context
     */
    @NonNull
    public static NetworkState get(@NonNull Context context) {
        return new NetworkState(context);
    }

    /**
     * 是否有可用的网络连接
     */
    public boolean isActivated() {
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * 是否有可用的 wifi 网络连接
     */
    @SuppressWarnings("unused")
    public boolean isWifiActivated() {
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 是否有可用的移动数据网络连接
     */
    @SuppressWarnings("unused")
    public boolean isMobileActivated() {
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
    }

    /**
     * 是否有可用的蓝牙网络连接
     */
    @SuppressWarnings("unused")
    public boolean isBluetoothActivated() {
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_BLUETOOTH;
    }

    /**
     * 是否有可用的蓝牙网络连接
     */
    @SuppressWarnings("unused")
    public boolean isVPNActivated() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && networkInfo != null
                && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_VPN;
    }

    /**
     * 当前网络是否是计量的，比如移动数据肯定是计量的，还有热点 wifi 也是计量的
     */
    @SuppressWarnings("unused")
    public boolean isMetered() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && connectivity != null && connectivity.isActiveNetworkMetered();
    }

    /**
     * 是否是漫游网络
     */
    @SuppressWarnings("unused")
    public boolean isRoaming() {
        return networkInfo != null && networkInfo.isRoaming();
    }

    /**
     * 是否是故障转移网络
     */
    @SuppressWarnings("unused")
    public boolean isFailover() {
        return networkInfo != null && networkInfo.isFailover();
    }

    /**
     * 获取网络类型名字
     */
    @SuppressWarnings("unused")
    @NonNull
    public String getTypeName() {
        return networkInfo != null ? networkInfo.getTypeName() : "NoNetwork";
    }

    @SuppressWarnings("unused")
    @Nullable
    public NetworkInfo getNetworkInfo() {
        return networkInfo;
    }

    @SuppressWarnings("unused")
    @Nullable
    public ConnectivityManager getConnectivity() {
        return connectivity;
    }
}

