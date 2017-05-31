package com.group7.dearbaby.home.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.group7.dearbaby.R;
import com.group7.dearbaby.home.model.bean.DictationResult;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechUtility;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-31.
 */

public class VoiceRecActivity extends AppCompatActivity {
    @BindView(R.id.quitIv)
    ImageView quitIv;
    @BindView(R.id.startNoticeTv)
    TextView startNoticeTv;
    @BindView(R.id.voiceBand1)
    ImageView voiceBand1;
    @BindView(R.id.voiceBand2)
    ImageView voiceBand2;
    @BindView(R.id.voiceBand3)
    ImageView voiceBand3;
    @BindView(R.id.voiceBand4)
    ImageView voiceBand4;
    @BindView(R.id.voiceBand5)
    ImageView voiceBand5;
    @BindView(R.id.voiceBand6)
    ImageView voiceBand6;
    @BindView(R.id.voiceBand7)
    ImageView voiceBand7;
    @BindView(R.id.voiceBand8)
    ImageView voiceBand8;
    @BindView(R.id.voiceBand9)
    ImageView voiceBand9;
    @BindView(R.id.voiceBand10)
    ImageView voiceBand10;
    @BindView(R.id.timeTv)
    TextView timeTv;
    @BindView(R.id.voiceBand11)
    ImageView voiceBand11;
    @BindView(R.id.voiceBand12)
    ImageView voiceBand12;
    @BindView(R.id.voiceBand13)
    ImageView voiceBand13;
    @BindView(R.id.voiceBand14)
    ImageView voiceBand14;
    @BindView(R.id.voiceBand15)
    ImageView voiceBand15;
    @BindView(R.id.voiceBand16)
    ImageView voiceBand16;
    @BindView(R.id.voiceBand17)
    ImageView voiceBand17;
    @BindView(R.id.voiceBand18)
    ImageView voiceBand18;
    @BindView(R.id.voiceBand19)
    ImageView voiceBand19;
    @BindView(R.id.voiceBand20)
    ImageView voiceBand20;
    @BindView(R.id.voiceBrandLl)
    LinearLayout voiceBrandLl;
    @BindView(R.id.voiceIv)
    ImageView voiceIv;
    @BindView(R.id.cancelNoticeTv)
    TextView cancelNoticeTv;
    @BindView(R.id.dotLineIv)
    ImageView dotLineIv;
    @BindView(R.id.cancleIv)
    ImageView cancleIv;
    @BindView(R.id.voiceLayout)
    RelativeLayout voiceLayout;
    @BindView(R.id.guideStartNoticeTv)
    TextView guideStartNoticeTv;
    @BindView(R.id.guideShadeIv)
    ImageView guideShadeIv;
    @BindView(R.id.guideBall)
    ImageView guideBall;
    @BindView(R.id.guideLionIv)
    ImageView guideLionIv;
    @BindView(R.id.guideLayout)
    RelativeLayout guideLayout;
    @BindView(R.id.wholeLayout)
    RelativeLayout wholeLayout;
    private SpeechRecognizer mIat;
    private InitListener mInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d("VoiceRecActivity", "SpeechRecognizer init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                Toast.makeText(VoiceRecActivity.this, "初始化失败，错误码：" + code, Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_util);
        ButterKnife.bind(this);
        SpeechUtility.createUtility(this, SpeechConstant.APPID+ "=592d5d9a");//将这里的578f1af7替换成自己申请得到的8位appid
        //1.创建SpeechRecognizer对象，第二个参数：本地听写时传InitListener
        mIat = SpeechRecognizer.createRecognizer(this, mInitListener);
        //2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类
        mIat.setParameter(SpeechConstant.DOMAIN, "iat");
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin");
        //3.开始听写   mIat.startListening(mRecoListener);


    }
    //听写监听器
private RecognizerListener recognizerListener=new RecognizerListener() {
        String resultJson = "[";//放置在外边做类的变量则报错，会造成json格式不对（？）
        //音量值0~30
    @Override
    public void onVolumeChanged(int i, byte[] bytes) {

    }
        //开始录音
    @Override
    public void onBeginOfSpeech() {

    }
        //结束录音
    @Override
    public void onEndOfSpeech() {

    }
        //听写结果回调接口(返回Json格式结果，用户可参见附录12.1)；
//一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加；
        //关于解析Json的代码可参见MscDemo中JsonParser类；
        //isLast等于true时会话结束。
        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
            if (!b) {
                             resultJson += recognizerResult.getResultString() + ",";
                         } else {
                             resultJson += recognizerResult.getResultString() + "]";
                         }

                     if (b) {
                             //解析语音识别后返回的json格式的结果
                             Gson gson = new Gson();
                             List<DictationResult> resultList = gson.fromJson(resultJson,
                                             new TypeToken<List<DictationResult>>() {
               }.getType());
                       String result = "";
                       for (int i = 0; i < resultList.size() - 1; i++) {
                               result += resultList.get(i).toString();
                           }

                         Intent intent=new Intent();
                         Log.e("sdsf",result);
                         intent.putExtra("voiceMsg",result);
                         setResult(100,intent);
                         finish();
                   }


        }
        //会话发生错误回调接口
        @Override
        public void onError(SpeechError speechError) {
            Log.e("VOICERECACTIVITY",speechError.toString());
            ToastUtils.showShortToast(speechError.toString());
        }

        //扩展用接口
    @Override
    public void onEvent(int i, int i1, int i2, Bundle bundle)  {

    }


};
    @OnClick({R.id.quitIv, R.id.voiceIv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quitIv:
                finish();
                break;
            case R.id.voiceIv:
mIat.startListening( recognizerListener);
                break;
        }
    }
}
