package com.example.screenshot_detect;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    public static String TAG = "log";

    private FileObserver fileObserver;
    // real device path

    //private String absolutePath = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator;
    private String absolutePath = Environment.getRootDirectory().getPath();

//    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.e(TAG, absolutePath);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,absolutePath);
        fileObserver = new FileObserverImpl(absolutePath,FileObserver.CREATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fileObserver.startWatching();
    }

    @Override
    protected void onPause() {
        super.onPause();
        fileObserver.stopWatching();
    }
}