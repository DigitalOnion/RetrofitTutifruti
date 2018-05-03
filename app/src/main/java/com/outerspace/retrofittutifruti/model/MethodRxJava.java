package com.outerspace.retrofittutifruti.model;

import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.outerspace.retrofittutifruti.api.Pixabay;
import com.outerspace.retrofittutifruti.api.signature.PixabayApi;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MethodRxJava implements DataProducer {
    private static final String INVALID_RESPONSE = "Network request returned an error";
    private String query;
    private Gson gson = null;
    private Retrofit retrofit = null;
    private PixabayApi api = null;

    private CompositeDisposable disposables = new CompositeDisposable();

    DataConsumer consumer;

    public MethodRxJava(DataConsumer consumer) {
        this.consumer = consumer;

        gson = new GsonBuilder()
            .setLenient()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

        RxJava2CallAdapterFactory adapter =
                RxJava2CallAdapterFactory.create();

        retrofit = new Retrofit.Builder()
                .baseUrl(PixabayApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(adapter)
                .build();

        api = retrofit.create(PixabayApi.class);
    }

    @Override
    public void requestData(String query) {

        Single<Pixabay> single =
                api.requestRxPixabay(query, PixabayApi.API_KEY);

        Disposable disposable = single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturnItem(new Pixabay())
                .subscribe(
                            response -> {
                                if(response.hits != null)
                                    consumer.onDataReady(response);
                                else
                                    consumer.onDataError(INVALID_RESPONSE);
                            }
                );

        disposables.add(disposable);
    }

    @Override
    public void setConsumer(DataConsumer consumer) {
        this.consumer = consumer;
    }
}
