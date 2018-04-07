package com.example.liligang.nba;

import android.app.Application;
import android.content.Context;

/**
 * Created by liligang on 2018/3/24.
 */

public class NbaApplication extends Application {
    private static  Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
