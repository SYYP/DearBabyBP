package com.group7.dearbaby.registlogin.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.group7.dearbaby.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/24 8:23
 */

public class RegistrationSuccessful extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_logon);
        showDialog();
    }

    private void showDialog() {
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog ad = new AlertDialog.Builder(RegistrationSuccessful.this)
                                .setView(R.layout.activity_register_success)
                                .create();
                                ad.show();
                    }
                });
            }
        },3000);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_title_iv:
                finish();
                break;
        }

    }
}
