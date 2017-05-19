package com.group7.dearbaby.application;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * @author holmes k
 * @date 2017.05.17
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
