package com.outerspace.retrofittutifruti.model;

import com.outerspace.retrofittutifruti.api.WeatherResponse;

public interface DataConsumer {
    public void onDataReady(WeatherResponse response);
}
