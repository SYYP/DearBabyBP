package com.group7.dearbaby.shoppingcart.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.group7.dearbaby.R;
import com.group7.dearbaby.base.BaseFragment;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsBean;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;
import com.group7.dearbaby.shoppingcart.model.utils.GetGoods;
import com.group7.dearbaby.shoppingcart.presenter.ShopCartPresenterImp;
import com.group7.dearbaby.shoppingcart.view.activity.SubmitOrderActivity;
import com.group7.dearbaby.shoppingcart.view.adapter.RecyclerViewAdapter;
import com.group7.dearbaby.shoppingcart.view.views.ViewDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.group7.dearbaby.R.id.shopping_jiesuantext;
import static com.group7.dearbaby.R.id.shopping_quanxuan;
import static com.group7.dearbaby.R.id.shopping_title_edit;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-16.
 */

public class CartFragment extends BaseFragment implements View.OnClickListener ,ViewDao{

    @BindView(R.id.shopping_title_tv)
    TextView shoppingTitleTv;
    @BindView(R.id.shopping_title_edit)
    TextView shoppingTitleEdit;
    @BindView(R.id.shopping_recyclerView)
    RecyclerView shoppingRecyclerView;
    @BindView(shopping_quanxuan)
    CheckBox shoppingQuanxuan;
    @BindView(R.id.shopping_sumprice2)
    TextView shoppingSumprice2;
    @BindView(R.id.shopping_sumprice)
    TextView shoppingSumprice;
    Unbinder unbinder;
    @BindView(R.id.shopping_jiesuantext)
    TextView shoppingJiesuantext;
    @BindView(R.id.shopping_jiesuanbnt)
    TextView shoppingJiesuanbnt;
    @BindView(R.id.jiesuan)
    RelativeLayout jiesuan;
    private RecyclerView recyclerView;
    private TextView textView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                List<GoodsBean.SugGoodsBean> sugGoods =
                        (List<GoodsBean.SugGoodsBean>) msg.obj;
                adapter = new RecyclerViewAdapter(getActivity(), sugGoods);
                recyclerView.setAdapter(adapter);
            }
        }
    };
    private RecyclerViewAdapter adapter;
private List<GoodsForCart> carts;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShopCartPresenterImp.getShopImp().attachView(this);
    }

    @Override
    protected View initSelfView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.activity_shoppingcart, container, false);
        new GetGoods(handler).start();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        initData();

    }

    @Override
    public void initData() {
        textView = (TextView) getView().findViewById(R.id.shopping_jiesuantext);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

     ShopCartPresenterImp.getShopImp().queryAll();

        textView.setOnClickListener(this);
        shoppingTitleEdit.setOnClickListener(this);
        shoppingQuanxuan.setOnClickListener(this);
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.shopping_recyclerView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ShopCartPresenterImp.getShopImp().detachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case shopping_jiesuantext:
                startActivity(new Intent(getActivity(), SubmitOrderActivity.class));
                break;
            case shopping_title_edit:
                shoppingJiesuanbnt.setText("删除");

                break;
            case shopping_quanxuan:
                if (shoppingQuanxuan.isChecked()){
                    for (GoodsForCart goods:carts) {
                        goods.setIsChecked(1);
                    }


                }else {
                    for (GoodsForCart goods:carts) {
                        goods.setIsChecked(0);
                    }

                }
                ShopCartPresenterImp.getShopImp().upData(carts);
                break;
        }

    }


    @Override
    public void queryAllGoods(List<GoodsForCart> carts) {
this.carts=carts;
      updateCbAndTV(carts);
    }


    @Override
    public void upDataUI(List<GoodsForCart> goods) {
this.carts=goods;
        updateCbAndTV(goods);
    }

    /**
     * 返回选中商品的总价
     * @return
     */
    private String allPrice(List<GoodsForCart> carts){
        float sum=0f;
        for (GoodsForCart goods:carts) {
            if (!(goods.getIsChecked()==0)){
             sum+=goods.getPrice()*goods.getCount();
            }
        }
        return "￥"+sum;
    }

    /**
     * 返回选中商品的总价
     * @return
     */
    private String allOkCount(List<GoodsForCart> carts){
        int  sum=0;
        for (GoodsForCart goods:carts) {
            if (!(goods.getIsChecked()==0)){
                sum+=goods.getCount();
            }
        }
        return "去结算("+sum+")";
    }
    /**
     * 根据选择状态 删除数据 更新UI
     */
    private void  delete(){
        if (shoppingQuanxuan.isChecked()){
           ShopCartPresenterImp.getShopImp().delete(carts);

        }else {
            List<GoodsForCart> good=new ArrayList<>();
            for (GoodsForCart goods:carts) {
                if (!(goods.getIsChecked()==0)){
                    good.add(goods);
                }
            }
            ShopCartPresenterImp.getShopImp().delete(carts);
         good=null;
        }

    }


    /**
     * 每次选择 接口调用时  判断自条目是否全选 更新全选按钮状态
     * @return
     */
    public boolean isAllChose(List<GoodsForCart> carts) {
        boolean allChose=false;
        for (GoodsForCart goods:carts) {
            if (goods.getIsChecked()==0){
                allChose=true;
            }
        }
        if (allChose){
            allChose=false;
        }else {
            allChose=true;
        }
        return allChose;
    }


    private void updateCbAndTV(List<GoodsForCart> carts){
        if (carts != null && carts.size() > 0) {
            jiesuan.setVisibility(View.VISIBLE);
            shoppingSumprice2.setText(allPrice(carts));
            shoppingJiesuanbnt.setText(allOkCount(carts));
            shoppingQuanxuan.setChecked(isAllChose(carts));
        } else {
            jiesuan.setVisibility(View.GONE);
        }


    }
}
