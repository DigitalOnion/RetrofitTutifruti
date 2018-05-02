package com.outerspace.retrofittutifruti.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.outerspace.retrofittutifruti.api.Pixabay;
import com.outerspace.retrofittutifruti.databinding.ActivityMainBinding;
import com.outerspace.retrofittutifruti.model.CallbackMethod;
import com.outerspace.retrofittutifruti.model.DataConsumer;

public class MainViewModel implements DataConsumer {
    private Context context;
    private ActivityMainBinding binding;

    // model
    private CallbackMethod callbackMethod;

    public MainViewModel(ActivityMainBinding binding) {
        this.binding = binding;
        context = binding.getRoot().getContext();
        callbackMethod = new CallbackMethod(this);
    }

    public void onClickBtnCallback(View view) {
        callbackMethod.requestData("Husky dog");
    }

    public void onClickBtnAsyncTask(View view) {
        Toast.makeText(context, "Hello AsyncTask", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnRxJava(View view) {
        Toast.makeText(context, "Hello RxJava, react, come on react!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataReady(Pixabay response) {
        Toast.makeText(context, "GOOD RESPONSE!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataError(String errorMessage) {
        Toast.makeText(context, "ERROR:", Toast.LENGTH_SHORT).show();
    }

}
