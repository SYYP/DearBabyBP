package com.group7.dearbaby.registlogin.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.group7.dearbaby.R;
import com.group7.dearbaby.registlogin.view.views.DivEtidActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.group7.dearbaby.R.id.code_sent_notice_tv;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/23 14:16
 */

public class PhoneRegisterActivityTwo extends Activity {
    @BindView(R.id.login_title_iv)
    ImageView loginTitleIv;
    @BindView(R.id.title_inpo)
    TextView titleInpo;
    @BindView(R.id.title_relayout)
    RelativeLayout titleRelayout;
    @BindView(code_sent_notice_tv)
    TextView codeSentNoticeTv;
    @BindView(R.id.check_code_input)
    DivEtidActivity checkCodeInput;
    @BindView(R.id.img_delete2)
    ImageView imgDelete2;
    @BindView(R.id.get_phone_check_code_again_register)
    Button getPhoneCheckCodeAgainRegister;
    @BindView(R.id.tv_get_voice_code)
    TextView tvGetVoiceCode;
    @BindView(R.id.get_voice_verifycode_view)
    LinearLayout getVoiceVerifycodeView;
    @BindView(R.id.password)
    DivEtidActivity password;
    @BindView(R.id.img_delete)
    ImageView imgDelete;
    @BindView(R.id.ll_login_password_show)
    Button llLoginPasswordShow;
    @BindView(R.id.btn_ok)
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        ButterKnife.bind(this);
        titleInpo.setText("设置密码");
        String phone = getIntent().getStringExtra("phone");
        codeSentNoticeTv.setText("短信验证码以发送至"+phone);
    }
}
