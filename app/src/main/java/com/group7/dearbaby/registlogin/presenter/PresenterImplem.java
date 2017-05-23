package com.group7.dearbaby.registlogin.presenter;

import com.group7.dearbaby.registlogin.model.buttonModel.ButtonModel;
import com.group7.dearbaby.registlogin.model.buttonModel.ButtonImpler;
import com.group7.dearbaby.registlogin.view.ButtonView;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/17 10:12
 */

public class PresenterImplem implements ButtonInterOnClick,Passwordseting {
    private ButtonView buttonView;
    private ButtonModel button;
    public PresenterImplem(ButtonView buttonView){
        this.buttonView=buttonView;
        this.button=new ButtonImpler();
    }

    @Override
    public void onLongin(String username, String password) {
        button.setingpassword(username,password,this);
    }

    @Override
    public void onDestroy() {
    buttonView=null;
    }

    @Override
    public void usernameError() {
        if(buttonView!=null){
            buttonView.usernameError();
        }
    }

    @Override
    public void passwordError() {
        if(buttonView!=null){
            buttonView.passwordError();
        }
    }

    @Override
    public void loginSucceed() {
        if(buttonView!=null){
          buttonView.loginSucceed();
        }
    }
}
