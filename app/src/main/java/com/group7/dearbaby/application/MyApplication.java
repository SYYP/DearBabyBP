package com.group7.dearbaby.application;

import com.blankj.utilcode.util.Utils;
import com.group7.dearbaby.base.LoginListener;
import com.igexin.sdk.PushManager;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.zhy.autolayout.config.AutoLayoutConifg;

import org.litepal.LitePalApplication;

import java.util.ArrayList;
import java.util.List;

import cn.smssdk.SMSSDK;

/**
 * @author holmes k
 * @date 2017.05.17
 */

public class MyApplication extends LitePalApplication {
private List<LoginListener> loginListeners=new ArrayList<>();
    {
        PlatformConfig.setSinaWeibo("3383892678", "fbf0b15e0e2c4d88f2688255f8a9d69e", "http://sns.whalecloud.com");
        PlatformConfig.setQQZone("1106030997", "2wNCn7IxE3PIz7xF");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
        UMShareAPI.get(this);
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(getApplicationContext()).setShareConfig(config);
        SMSSDK.initSDK(this, "1cfb207aa3b62", "c4715a08fbaa52917dc830b2254075da");
        Utils.init(this);
        ZXingLibrary.initDisplayOpinion(this);
        PushManager.getInstance().initialize(this.getApplicationContext(),com.group7.dearbaby.utils.DemoPushService.class);
        // com.getui.demo.DemoIntentService 为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(),com.group7.dearbaby.utils.DemoIntentService.class);


    }
    public  void addListnerToList(LoginListener listener){
        loginListeners.add(listener);
    }

    public  void removeLiser(LoginListener listener){
        loginListeners.add(listener);
    }
    public  void hasLogin(){
        for (LoginListener lsn: loginListeners) {
            lsn.authLogin();
        }
    }
    public  void hasExit(){
        for (LoginListener lsn: loginListeners) {
            lsn.authExit();
        }
    }
}
