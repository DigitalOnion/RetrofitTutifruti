package com.outerspace.retrofittutifruti.viewmodel;

import android.view.View;
import android.widget.Toast;
import com.outerspace.retrofittutifruti.databinding.ActivityMainBinding;

public class MainViewModel {
    private ActivityMainBinding binding;

    public MainViewModel(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public void onClickBtnCallback(View view) {
        Toast.makeText(binding.getRoot().getContext(), "Hello Callback", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnAsyncTask(View view) {
        Toast.makeText(binding.getRoot().getContext(), "Hello AsyncTask", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnRxJava(View view) {
        Toast.makeText(binding.getRoot().getContext(), "Hello RxJava, react, come on react!!", Toast.LENGTH_SHORT).show();
    }

}
