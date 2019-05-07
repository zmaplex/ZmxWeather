package com.example.zmxweather.bean;

public class CityBean {

    /**
     * _id : 1
     * id : 1
     * pid : 0
     * city_code : 101010100
     * city_name : 北京
     */

    private int _id;
    private int id;
    private int pid;
    private String city_code;
    private String city_name;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
