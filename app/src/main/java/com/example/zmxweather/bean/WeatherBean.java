package com.example.zmxweather.bean;

import java.util.List;

public class WeatherBean {
    /**
     * time : 2019-05-05 13:21:04
     * cityInfo : {"city":"天津市","cityId":"101030100","parent":"天津","updateTime":"12:44"}
     * date : 20190505
     * message : Success !
     * status : 200
     * data : {"shidu":"25%","pm25":58,"pm10":121,"quality":"良","wendu":"22","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"04","sunrise":"05:12","high":"高温 28.0℃","low":"低温 15.0℃","sunset":"19:06","aqi":82,"ymd":"2019-05-04","week":"星期六","fx":"西南风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"},"forecast":[{"date":"05","sunrise":"05:11","high":"高温 22.0℃","low":"低温 11.0℃","sunset":"19:07","aqi":114,"ymd":"2019-05-05","week":"星期日","fx":"东北风","fl":"5-6级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"06","sunrise":"05:09","high":"高温 24.0℃","low":"低温 14.0℃","sunset":"19:08","aqi":39,"ymd":"2019-05-06","week":"星期一","fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"07","sunrise":"05:08","high":"高温 26.0℃","low":"低温 15.0℃","sunset":"19:08","aqi":48,"ymd":"2019-05-07","week":"星期二","fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"08","sunrise":"05:07","high":"高温 27.0℃","low":"低温 16.0℃","sunset":"19:09","aqi":54,"ymd":"2019-05-08","week":"星期三","fx":"西南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"09","sunrise":"05:06","high":"高温 28.0℃","low":"低温 17.0℃","sunset":"19:10","aqi":69,"ymd":"2019-05-09","week":"星期四","fx":"南风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"10","sunrise":"05:05","high":"高温 29.0℃","low":"低温 18.0℃","sunset":"19:11","aqi":87,"ymd":"2019-05-10","week":"星期五","fx":"南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"11","sunrise":"05:04","high":"高温 26.0℃","low":"低温 16.0℃","sunset":"19:12","ymd":"2019-05-11","week":"星期六","fx":"南风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"12","sunrise":"05:03","high":"高温 27.0℃","low":"低温 15.0℃","sunset":"19:13","ymd":"2019-05-12","week":"星期日","fx":"北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","sunrise":"05:02","high":"高温 26.0℃","low":"低温 18.0℃","sunset":"19:14","ymd":"2019-05-13","week":"星期一","fx":"南风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"14","sunrise":"05:01","high":"高温 31.0℃","low":"低温 21.0℃","sunset":"19:15","ymd":"2019-05-14","week":"星期二","fx":"东南风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"15","sunrise":"05:00","high":"高温 29.0℃","low":"低温 20.0℃","sunset":"19:16","ymd":"2019-05-15","week":"星期三","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"16","sunrise":"04:59","high":"高温 25.0℃","low":"低温 19.0℃","sunset":"19:17","ymd":"2019-05-16","week":"星期四","fx":"东风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"17","sunrise":"04:58","high":"高温 28.0℃","low":"低温 18.0℃","sunset":"19:18","ymd":"2019-05-17","week":"星期五","fx":"南风","fl":"4-5级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"18","sunrise":"04:57","high":"高温 23.0℃","low":"低温 16.0℃","sunset":"19:19","ymd":"2019-05-18","week":"星期六","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"19","sunrise":"04:57","high":"高温 27.0℃","low":"低温 20.0℃","sunset":"19:20","ymd":"2019-05-19","week":"星期日","fx":"北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}]}
     */

    private String time;
    private CityInfoBean cityInfo;
    private String date;
    private String message;
    private int status;
    private DataBean data;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfoBean getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoBean cityInfo) {
        this.cityInfo = cityInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class CityInfoBean {
        /**
         * city : 天津市
         * cityId : 101030100
         * parent : 天津
         * updateTime : 12:44
         */

        private String city;
        private String cityId;
        private String parent;
        private String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class DataBean {
        /**
         * shidu : 25%
         * pm25 : 58.0
         * pm10 : 121.0
         * quality : 良
         * wendu : 22
         * ganmao : 极少数敏感人群应减少户外活动
         * yesterday : {"date":"04","sunrise":"05:12","high":"高温 28.0℃","low":"低温 15.0℃","sunset":"19:06","aqi":82,"ymd":"2019-05-04","week":"星期六","fx":"西南风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"}
         * forecast : [{"date":"05","sunrise":"05:11","high":"高温 22.0℃","low":"低温 11.0℃","sunset":"19:07","aqi":114,"ymd":"2019-05-05","week":"星期日","fx":"东北风","fl":"5-6级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"06","sunrise":"05:09","high":"高温 24.0℃","low":"低温 14.0℃","sunset":"19:08","aqi":39,"ymd":"2019-05-06","week":"星期一","fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"07","sunrise":"05:08","high":"高温 26.0℃","low":"低温 15.0℃","sunset":"19:08","aqi":48,"ymd":"2019-05-07","week":"星期二","fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"08","sunrise":"05:07","high":"高温 27.0℃","low":"低温 16.0℃","sunset":"19:09","aqi":54,"ymd":"2019-05-08","week":"星期三","fx":"西南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"09","sunrise":"05:06","high":"高温 28.0℃","low":"低温 17.0℃","sunset":"19:10","aqi":69,"ymd":"2019-05-09","week":"星期四","fx":"南风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"10","sunrise":"05:05","high":"高温 29.0℃","low":"低温 18.0℃","sunset":"19:11","aqi":87,"ymd":"2019-05-10","week":"星期五","fx":"南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"11","sunrise":"05:04","high":"高温 26.0℃","low":"低温 16.0℃","sunset":"19:12","ymd":"2019-05-11","week":"星期六","fx":"南风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"12","sunrise":"05:03","high":"高温 27.0℃","low":"低温 15.0℃","sunset":"19:13","ymd":"2019-05-12","week":"星期日","fx":"北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","sunrise":"05:02","high":"高温 26.0℃","low":"低温 18.0℃","sunset":"19:14","ymd":"2019-05-13","week":"星期一","fx":"南风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"14","sunrise":"05:01","high":"高温 31.0℃","low":"低温 21.0℃","sunset":"19:15","ymd":"2019-05-14","week":"星期二","fx":"东南风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"15","sunrise":"05:00","high":"高温 29.0℃","low":"低温 20.0℃","sunset":"19:16","ymd":"2019-05-15","week":"星期三","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"16","sunrise":"04:59","high":"高温 25.0℃","low":"低温 19.0℃","sunset":"19:17","ymd":"2019-05-16","week":"星期四","fx":"东风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"17","sunrise":"04:58","high":"高温 28.0℃","low":"低温 18.0℃","sunset":"19:18","ymd":"2019-05-17","week":"星期五","fx":"南风","fl":"4-5级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"18","sunrise":"04:57","high":"高温 23.0℃","low":"低温 16.0℃","sunset":"19:19","ymd":"2019-05-18","week":"星期六","fx":"东南风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"19","sunrise":"04:57","high":"高温 27.0℃","low":"低温 20.0℃","sunset":"19:20","ymd":"2019-05-19","week":"星期日","fx":"北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}]
         */

        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 04
             * sunrise : 05:12
             * high : 高温 28.0℃
             * low : 低温 15.0℃
             * sunset : 19:06
             * aqi : 82.0
             * ymd : 2019-05-04
             * week : 星期六
             * fx : 西南风
             * fl : 3-4级
             * type : 阴
             * notice : 不要被阴云遮挡住好心情
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String ymd;
            private String week;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 05
             * sunrise : 05:11
             * high : 高温 22.0℃
             * low : 低温 11.0℃
             * sunset : 19:07
             * aqi : 114.0
             * ymd : 2019-05-05
             * week : 星期日
             * fx : 东北风
             * fl : 5-6级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String ymd;
            private String week;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
