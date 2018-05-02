package com.outerspace.retrofittutifruti.view;

import com.outerspace.retrofittutifruti.R;
import com.outerspace.retrofittutifruti.databinding.ActivityMainBinding;
import com.outerspace.retrofittutifruti.viewmodel.MainViewModel;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate, bind and set the ViewModel.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainVM = new MainViewModel(binding);
        binding.setMainVM(mainVM);
    }
}
