package com.outerspace.retrofittutifruti.model;

public interface DataProducer {

    public void requestData(String query);

    public void setConsumer(DataConsumer consumer);

}
