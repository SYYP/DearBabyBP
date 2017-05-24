package com.group7.dearbaby.me.model;

import android.os.Handler;

import com.google.gson.Gson;
import com.group7.dearbaby.me.model.bean.User;
import com.group7.dearbaby.me.model.url.Url;
import com.group7.dearbaby.me.model.utils.OkHttpUtils;
import com.group7.dearbaby.me.presenter.Success;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class SuccessImp implements SuccessJson {
    private List<User.DataBean> data;
    private Success success;
    public void getjson(){
        OkHttpUtils.get(Url.uri, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String  jsons = response.body().string();

                        Gson gson=new Gson();
                        User user = gson.fromJson(jsons, User.class);
                        data = user.getData();
                        success.succes(data);



            }
        });



}


    @Override
    public void getJSon( final Success success) {
       this.success=success;
        getjson();
    }
    
       
  
}
