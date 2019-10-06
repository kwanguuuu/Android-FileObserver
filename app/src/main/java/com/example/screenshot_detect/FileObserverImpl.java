package com.example.screenshot_detect;

import android.os.Build;
import android.os.FileObserver;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.io.File;

public class FileObserverImpl extends FileObserver {

    public String TAG = "tag";

    public FileObserverImpl(String path, int mask) {
        super(path,mask);
        Log.d(TAG,"FileObserverImpl");
    }

    @Override
    public void onEvent(int event, @Nullable String path) {
        Log.d(TAG,"on Event....");

        if(event == FileObserver.CREATE) {
            //Do something...
        }

    }


}
