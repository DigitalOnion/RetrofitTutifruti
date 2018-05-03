package com.outerspace.retrofittutifruti.viewmodel;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.outerspace.retrofittutifruti.api.Hit;
import com.outerspace.retrofittutifruti.api.Pixabay;
import com.outerspace.retrofittutifruti.databinding.ActivityMainBinding;
import com.outerspace.retrofittutifruti.model.MethodCallback;
import com.outerspace.retrofittutifruti.model.DataConsumer;
import com.outerspace.retrofittutifruti.model.MethodRxJava;
import com.outerspace.retrofittutifruti.model.MyHit;

public class MainViewModel implements DataConsumer {
    private Context context;
    private ActivityMainBinding binding;

    ArrayList<MyHit> myHits;

    // model
    private MethodCallback methodCallback;
    private MethodRxJava   methodRxJava;

    public MainViewModel(ActivityMainBinding binding) {
        this.binding = binding;
        context = binding.getRoot().getContext();
        methodCallback = new MethodCallback(this);
        methodRxJava = new MethodRxJava(this);
    }

    public void onClickBtnCallback(View view) {
        binding.txtResponse.setText("");
        methodCallback.requestData("Husky dog");
    }

    public void onClickBtnRxJava(View view) {
        binding.txtResponse.setText("");
        methodRxJava.requestData("Husky dog");
    }

    @Override
    public void onDataReady(Pixabay response) {
        myHits = new ArrayList<>();
        if(response.hits != null)
            for(Hit hit: response.hits) {
                MyHit myHit = new MyHit();
                myHit.previewHeight = hit.previewHeight;
                myHit.previewWidth = hit.previewWidth;
                myHit.previewURL = hit.previewURL;

                myHits.add(myHit);
            }

        StringBuilder sb = new StringBuilder();
        for(MyHit myHit: myHits) {
            sb.append(myHit.previewURL).append('\n');
        }
        binding.txtResponse.setText(sb.toString());
    }

    @Override
    public void onDataError(String errorMessage) {
        String message = "ERROR:" + errorMessage;
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
