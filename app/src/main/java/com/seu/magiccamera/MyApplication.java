package com.seu.magiccamera;

import android.app.Application;
import android.content.Context;

/**
 * Created by sunyajie on 2018/12/22.
 */

public class MyApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
