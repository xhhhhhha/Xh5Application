package com.example.xh5application;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;

public class Main2Activity extends AppCompatActivity {
    private String Imagepath ="/sdcard";
    private ImageView imageview1;
    private String Filepath;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageview1=findViewById(R.id.imageview1);
        boolean isSdCardExist= Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if(isSdCardExist)
        {
            String sdpath=Environment.getExternalStorageDirectory().getAbsolutePath();
            Filepath=sdpath+ File.separator+"image1";
            imageview1=findViewById(R.id.imageview1);

            InputStream inputStream=null;
            AssetManager assetManager=getAssets();
            try
            {
                inputStream  =  assetManager.open("image1.jpg");
            }catch (IOException e) {
                    e.printStackTrace();
            }
            Bitmap bm= BitmapFactory.decodeStream(inputStream);//以流的方式读取文件
            Bitmap bm1=BitmapFactory.decodeFile(Filepath);//以文件路径方式读取文件

            imageview1.setImageBitmap(bm);
        }
    }
}
