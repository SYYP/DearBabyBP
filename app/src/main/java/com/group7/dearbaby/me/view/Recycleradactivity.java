package com.group7.dearbaby.me.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.group7.dearbaby.R;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Recycleradactivity extends Activity {
    private EditText et_cart2_ea_receiver_name;
    private EditText et_cart2_ea_receiver_phone;
    private TextView tv_adcurrent;
    private EditText edaddcontent;

    public Recycleradactivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerlogin_cartaddress);
        initView();
    }

    private void initView() {
        et_cart2_ea_receiver_name = (EditText) findViewById(R.id.et_cart2_ea_receiver_name);
        et_cart2_ea_receiver_phone = (EditText) findViewById(R.id.et_cart2_ea_receiver_phone);
        edaddcontent = (EditText) findViewById(R.id.et_cart2_ea_address_content);
        tv_adcurrent = (TextView) findViewById(R.id.tv_adcurrent);
        tv_adcurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Recycleradactivity.this,BaiDuactivity.class);
                startActivityForResult(intent,RESULT_OK);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==100){
            if(data!=null){
                String address = data.getStringExtra("address");
                edaddcontent.setText(address);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
