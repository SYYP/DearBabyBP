package com.group7.dearbaby.application;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.zhy.autolayout.config.AutoLayoutConifg;

import cn.smssdk.SMSSDK;


/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-16.
 */

public class MyApplication extends Application {
    {
        PlatformConfig.setSinaWeibo("3383892678","fbf0b15e0e2c4d88f2688255f8a9d69e","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("1106030997","2wNCn7IxE3PIz7xF");
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        UMShareAPI.get(this);
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(getApplicationContext()).setShareConfig(config);
        SMSSDK.initSDK(this, "1cfb207aa3b62", "c4715a08fbaa52917dc830b2254075da");
    }
}
