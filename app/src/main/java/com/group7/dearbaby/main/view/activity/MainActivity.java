package com.group7.dearbaby.main.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.group7.dearbaby.R;
import com.group7.dearbaby.application.MyApplication;
import com.group7.dearbaby.base.BaseFragmentActivity;
import com.group7.dearbaby.category.view.fragment.CategoryFragment;
import com.group7.dearbaby.home.view.fragment.HomeFragment;
import com.group7.dearbaby.lepingou.view.fragment.LepingouFragment;
import com.group7.dearbaby.me.view.fragment.MineFragment;
import com.group7.dearbaby.shoppingcart.model.bean.ALingGoodsCart;
import com.group7.dearbaby.shoppingcart.presenter.ShopCartPresenterImp;
import com.group7.dearbaby.shoppingcart.view.fragment.CartFragment;
import com.group7.dearbaby.shoppingcart.view.views.ViewDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面
 */
public class MainActivity extends BaseFragmentActivity implements ViewDao{


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
    @BindView(R.id.main_layout)
    RelativeLayout mainLayout;
    private List<Fragment> contentlist;
    private Handler handler = new Handler();
    private boolean canExist;
    private TextView shoppingNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ShopCartPresenterImp.getShopImp().attachView(this);
        addShoppingNum();
        ShopCartPresenterImp.getShopImp().getCarts();
        ((MyApplication)getApplicationContext()).addListnerToList(this);

        initData();
        initView(R.id.realContent, tabBottom, contentlist);
    }

    private void addShoppingNum() {
        shoppingNum = new TextView(this);
        RelativeLayout.LayoutParams shoppingParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        shoppingParams.addRule(RelativeLayout.ALIGN_RIGHT, R.id.tab);
        shoppingParams.addRule(RelativeLayout.ALIGN_TOP, R.id.tab);

        shoppingParams.rightMargin = (int) (((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getWidth() * 1.5 / 5 - 20);
        shoppingParams.topMargin = 5;
        shoppingNum.setTextSize(10);
        shoppingNum.setLayoutParams(shoppingParams);
        shoppingNum.setBackgroundResource(R.drawable.shoppingcart_tab_num_bg);

        shoppingNum.setTextColor(Color.WHITE);
        shoppingNum.setGravity(Gravity.CENTER);
        shoppingNum.setVisibility(View.INVISIBLE);
        mainLayout.addView(shoppingNum);

    }

    private void initData() {
        contentlist = new ArrayList<>();
        contentlist.add(new HomeFragment());
        contentlist.add(new CategoryFragment());
        contentlist.add(new LepingouFragment());
        contentlist.add(new CartFragment());
        contentlist.add(new MineFragment());
    }

    public static void startMainActiviy(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    /**
     * 退出程序
     */
    @Override
    public void onBackPressed() {
        if (tabHome.isChecked()) {
            if (canExist) {
                removeAll();
                finish();
            } else {

                if (!canExist) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            canExist = false;
                        }
                    }, 2000);

                }
                canExist = true;
                Toast.makeText(this, R.string.click_twice_to_exit_app, Toast.LENGTH_SHORT).show();
            }
        } else {
            tabHome.setChecked(true);
        }
    }



    private void changeShopnum(List<ALingGoodsCart> goods) {
        int count=getAllGoosCount(goods);
        if (shoppingNum!=null)
        if (count==0){
            shoppingNum.setVisibility(View.INVISIBLE);
        }
        else {
            shoppingNum.setVisibility(View.VISIBLE);
            shoppingNum.setText(count+"");
        }
    }

    private int getAllGoosCount(List<ALingGoodsCart> carts){
        int count =0;
        if (carts==null ||carts.size()==0){
            return count;
        }

        for (ALingGoodsCart cart:carts){
            if (!cart.isIsGiven())
            count+=cart.getCount();
        }
        return count;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShopCartPresenterImp.getShopImp().detachView(this);
    }

    @Override
    public void getCarts(List<ALingGoodsCart> carts) {
        changeShopnum(carts);
    }

    @Override
    public void addItems(List<ALingGoodsCart> carts, String productId) {
        changeShopnum(carts);
    }

    @Override
    public void updateItems(List<ALingGoodsCart> carts) {
        changeShopnum(carts);
    }

    @Override
    public void selctAll(List<ALingGoodsCart> carts) {
        changeShopnum(carts);
    }

    @Override
    public void unSelectAll(List<ALingGoodsCart> carts) {
        changeShopnum(carts);
    }

    @Override
    public void createOrder(List<ALingGoodsCart> carts) {
        changeShopnum(carts);
    }
}
