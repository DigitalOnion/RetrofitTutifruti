
package com.outerspace.retrofittutifruti.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("cod")
    @Expose
    public String cod;
    @SerializedName("message")
    @Expose
    public Double message;
    @SerializedName("cnt")
    @Expose
    public Long cnt;
    @SerializedName("list")
    @Expose
    public java.util.List<WeatherSpot> weatherSpotList = null;
    @SerializedName("city")
    @Expose
    public City city;

}
