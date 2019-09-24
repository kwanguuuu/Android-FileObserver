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
//    private String absolutePath = Environment.getExternalStorageState()
    private String absolutePath = Intent.ACTION_OPEN_DOCUMENT;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, absolutePath);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileObserver = new FileObserverImpl(new File(absolutePath), FileObserver.ACCESS );
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