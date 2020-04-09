package com.example.xh5application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageview);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);//不按比例缩放图片,目标是把图片塞满整个View
    }
}
