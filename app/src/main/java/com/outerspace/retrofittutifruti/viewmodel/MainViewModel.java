package com.outerspace.retrofittutifruti.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.outerspace.retrofittutifruti.api.WeatherResponse;
import com.outerspace.retrofittutifruti.databinding.ActivityMainBinding;
import com.outerspace.retrofittutifruti.model.DataConsumer;

public class MainViewModel implements DataConsumer {
    private ActivityMainBinding binding;
    private Context context;

    public MainViewModel(ActivityMainBinding binding) {
        this.binding = binding;
        context = binding.getRoot().getContext();
    }

    public void onClickBtnCallback(View view) {
        Toast.makeText(context, "Hello Callback", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnAsyncTask(View view) {
        Toast.makeText(context, "Hello AsyncTask", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnRxJava(View view) {
        Toast.makeText(context, "Hello RxJava, react, come on react!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataReady(WeatherResponse response) {

    }
}
