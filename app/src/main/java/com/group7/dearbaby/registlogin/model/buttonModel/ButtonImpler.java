package com.group7.dearbaby.registlogin.model.buttonModel;

import android.os.Handler;
import android.text.TextUtils;

import com.group7.dearbaby.registlogin.presenter.ButtonInterOnClick;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/17 10:07
 */

public class ButtonImpler implements ButtonModel {

    private  boolean bo;
    @Override
    public void setingpassword(final String username, final String password, final ButtonInterOnClick buttonInterOnClick) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               if(TextUtils.isEmpty(username)){
                   buttonInterOnClick.usernameError();
                   bo=true;
               }
                if(TextUtils.isEmpty(password)){
                    buttonInterOnClick.passwordError();
                    bo=false;
                }
                if(!bo){
                    buttonInterOnClick.loginSucceed();
                }
            }
        },1000);
    }
}
