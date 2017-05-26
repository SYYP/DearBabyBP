package com.group7.dearbaby.home.view.activity;/**
 * Created by holmes k on 2017.05.22.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.group7.dearbaby.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * auth:holmes k
 * date:2017.05.22
 */
public class HomeWebActivity extends AppCompatActivity {

    @BindView(R.id.home_busy_web_view)
    WebView homeBusyWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_web_view);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String webUrl = intent.getStringExtra("web");
        homeBusyWebView.loadUrl(webUrl);
        homeBusyWebView.getSettings().setJavaScriptEnabled(true);
        homeBusyWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

    }

}
