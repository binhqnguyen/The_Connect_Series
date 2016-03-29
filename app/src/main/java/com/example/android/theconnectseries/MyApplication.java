package com.example.android.theconnectseries;

import android.app.Application;
import android.content.Context;

/**
 * Created by markvandermerwe on 3/29/16.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}
