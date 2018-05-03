package com.outerspace.retrofittutifruti.model;

public interface DataProducer {

    public void requestData(String query) throws Exception;

    public void setConsumer(DataConsumer consumer);

}
