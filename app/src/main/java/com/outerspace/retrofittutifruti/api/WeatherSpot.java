
package com.outerspace.retrofittutifruti.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherSpot {

    @SerializedName("dt")
    @Expose
    public Long dt;
    @SerializedName("main")
    @Expose
    public Main main;
    @SerializedName("weather")
    @Expose
    public java.util.List<Weather> weatherList = null;
    @SerializedName("clouds")
    @Expose
    public Clouds clouds;
    @SerializedName("wind")
    @Expose
    public Wind wind;
    @SerializedName("rain")
    @Expose
    public Rain rain;
    @SerializedName("sys")
    @Expose
    public Sys sys;
    @SerializedName("dt_txt")
    @Expose
    public String dtTxt;

}
