package com.outerspace.retrofittutifruti.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.outerspace.retrofittutifruti.api.Pixabay;
import com.outerspace.retrofittutifruti.api.signature.PixabayApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallbackMethod implements DataProducer {

    private String query;

    private DataConsumer consumer;

    public CallbackMethod(DataConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void requestData(String query) {
        this.query = query;

        Gson gson = new GsonBuilder()
                .setLenient()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PixabayApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PixabayApi api = retrofit.create(PixabayApi.class);

        Call<Pixabay> requestPixabay = api.requestPixabay(query, PixabayApi.API_KEY);
        requestPixabay.enqueue(new PixabayCallback());
    }

    @Override
    public void setConsumer(DataConsumer consumer) {
        this.consumer = consumer;
    }

    private class PixabayCallback implements Callback<Pixabay> {

        @Override
        public void onResponse(Call<Pixabay> call, Response<Pixabay> response) {
            if(response.isSuccessful())
                consumer.onDataReady(response.body());
            else
                consumer.onDataError(response.message());
        }

        @Override
        public void onFailure(Call<Pixabay> call, Throwable t) {
            consumer.onDataError(t.getMessage());
        }
    }
}
