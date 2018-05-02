package com.outerspace.retrofittutifruti.model;

public class WeatherCallbackMethod implements DataProducer {

    private DataConsumer consumer;

    @Override
    public void requestData() {
        
    }

    @Override
    public void setConsumer(DataConsumer consumer) {
        this.consumer = consumer;
    }


}
