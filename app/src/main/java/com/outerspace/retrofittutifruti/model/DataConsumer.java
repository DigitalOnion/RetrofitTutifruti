package com.outerspace.retrofittutifruti.model;

import com.outerspace.retrofittutifruti.api.Pixabay;

public interface DataConsumer {

    public void onDataReady(Pixabay response);

    public void onDataError(String errorMessage);

}
