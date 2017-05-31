package com.group7.dearbaby.me.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.group7.dearbaby.R;
import com.group7.dearbaby.me.model.bean.UserAddressInfo;
import com.group7.dearbaby.utils.GsonUtils;
import com.group7.dearbaby.utils.SharedPreferenceUtils2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Recycleradactivity extends Activity {
    @BindView(R.id.et_cart2_ea_receiver_name)
    EditText etCart2EaReceiverName;
    @BindView(R.id.di_cart2_ea_receiver_name)
    ImageView diCart2EaReceiverName;
    @BindView(R.id.et_cart2_ea_receiver_phone)
    EditText etCart2EaReceiverPhone;
    @BindView(R.id.iv_cart2_ea_select_receiver_name)
    ImageView ivCart2EaSelectReceiverName;
    @BindView(R.id.iv_cart2_select_area)
    ImageView ivCart2SelectArea;
    @BindView(R.id.et_cart2_ea_address_content)
    EditText etCart2EaAddressContent;
    @BindView(R.id.cb_cart2_ea_set_default)
    CheckBox cbCart2EaSetDefault;
    @BindView(R.id.btn_cart2_ea_save_and_use)
    Button btnCart2EaSaveAndUse;
    @BindView(R.id.tv_cart2_ea_receiver_name)
    TextView tvCart2EaReceiverName;
    @BindView(R.id.divider_cart2_ea_receiver_name)
    View dividerCart2EaReceiverName;
    @BindView(R.id.tv_cart2_ea_address)
    TextView tvCart2EaAddress;
    @BindView(R.id.tv_cart2_ea_pick_address_content)
    TextView tvCart2EaPickAddressContent;
    @BindView(R.id.ll_cart2_ea_address_content)
    LinearLayout llCart2EaAddressContent;
    @BindView(R.id.ll_set_default)
    LinearLayout llSetDefault;


    public Recycleradactivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerlogin_cartaddress);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {


        tvCart2EaAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recycleradactivity.this, BaiDuactivity.class);
                startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 100) {
            if (data != null) {
                String address = data.getStringExtra("address");
                tvCart2EaAddress.setText(address);
                tvCart2EaPickAddressContent.setText(address);
                etCart2EaAddressContent.setText(address);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.btn_cart2_ea_save_and_use)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cart2_ea_save_and_use:
               String receiveName= etCart2EaReceiverName.getText().toString();
                String receivePhone= etCart2EaReceiverPhone.getText().toString();
                String receiveAddress= tvCart2EaAddress.getText().toString();
                String pickAddress= tvCart2EaPickAddressContent.getText().toString();
                String addressInfo= etCart2EaAddressContent.getText().toString();
                if (TextUtils.isEmpty(receiveName)||TextUtils.isEmpty(receivePhone)||TextUtils.isEmpty(addressInfo)){

                }else {
                    GsonUtils.objectToJson(new UserAddressInfo(receiveName,receivePhone,receiveAddress,pickAddress,addressInfo));
                SharedPreferenceUtils2.
                        put(this,"receiveInfo",
                                GsonUtils.objectToJson(new UserAddressInfo(receiveName,receivePhone,receiveAddress,pickAddress,addressInfo)));

                    finish();


                }
                break;

        }
    }
}
