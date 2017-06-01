package com.group7.dearbaby.me.view.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.group7.dearbaby.R;
import com.group7.dearbaby.application.MyApplication;
import com.group7.dearbaby.utils.SharedPreferenceUtils2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyBuyMoreActivity extends AppCompatActivity {

    @BindView(R.id.epp_pay_title_back_img)
    ImageView eppPayTitleBackImg;
    @BindView(R.id.setting_zhuxiao)
    Button settingZhuxiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.epp_pay_title_back_img, R.id.setting_zhuxiao})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.epp_pay_title_back_img:
                finish();
                break;
            case R.id.setting_zhuxiao:
                SharedPreferenceUtils2.clear(this);
                ((MyApplication)getApplicationContext()).hasExit();
                finish();
                break;
        }
    }
}
