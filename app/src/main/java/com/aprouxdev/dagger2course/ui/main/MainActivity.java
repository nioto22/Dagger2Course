package com.aprouxdev.dagger2course.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aprouxdev.dagger2course.BaseActivity;
import com.aprouxdev.dagger2course.R;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
