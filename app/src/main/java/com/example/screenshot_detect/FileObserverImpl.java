package com.example.screenshot_detect;

import android.os.Build;
import android.os.FileObserver;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.io.File;

public class FileObserverImpl extends FileObserver {

    public String TAG = "log";

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public FileObserverImpl(@NonNull File file, int mask) {
        super(file, mask);
    }

    @Override
    public void onEvent(int event, @Nullable String path) {
        if(event == FileObserver.CREATE) {
            Log.d(TAG, "call");
        }

    }


}
