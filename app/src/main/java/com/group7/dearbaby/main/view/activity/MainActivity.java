package com.group7.dearbaby.main.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.group7.dearbaby.R;
import com.group7.dearbaby.base.BaseFragmentActivity;
import com.group7.dearbaby.category.view.fragment.CategoryFragment;
import com.group7.dearbaby.home.view.fragment.HomeFragment;
import com.group7.dearbaby.lepingou.view.fragment.LepingouFragment;
import com.group7.dearbaby.me.view.fragment.MineFragment;
import com.group7.dearbaby.shoppingcart.view.fragment.CartFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面
 */
public class MainActivity extends BaseFragmentActivity {


    @BindView(R.id.tabHome)
    RadioButton tabHome;
    @BindView(R.id.tabCategory)
    RadioButton tabCategory;
    @BindView(R.id.tabLepin)
    RadioButton tabLepin;
    @BindView(R.id.tabShopping)
    RadioButton tabShopping;
    @BindView(R.id.tabMyBuy)
    RadioButton tabMyBuy;
    @BindView(R.id.tabBottom)
    RadioGroup tabBottom;
    @BindView(R.id.realContent)
    FrameLayout realContent;
    @BindView(R.id.Iv_home_bg)
    ImageView IvHomeBg;
private List<Fragment> contentlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initData();
        initView(R.id.realContent,tabBottom,contentlist);
    }

    private void initData() {
contentlist=new ArrayList<>();
        contentlist.add(new HomeFragment());
        contentlist.add(new CategoryFragment());
        contentlist.add(new LepingouFragment());
        contentlist.add(new CartFragment());
        contentlist.add(new MineFragment());
    }

}
