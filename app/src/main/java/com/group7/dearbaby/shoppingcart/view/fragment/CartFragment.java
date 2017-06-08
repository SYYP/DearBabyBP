package com.group7.dearbaby.shoppingcart.view.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.group7.dearbaby.R;
import com.group7.dearbaby.base.BaseFragment;
import com.group7.dearbaby.shoppingcart.model.bean.ALingGoods;
import com.group7.dearbaby.shoppingcart.model.bean.ALingGoodsCart;
import com.group7.dearbaby.shoppingcart.model.utils.ALingUrls;
import com.group7.dearbaby.shoppingcart.model.utils.OkHttp3Utils;
import com.group7.dearbaby.shoppingcart.presenter.ShopCartPresenterImp;
import com.group7.dearbaby.shoppingcart.view.activity.SubmitOrderActivity;
import com.group7.dearbaby.shoppingcart.view.adapter.RecyclerViewAdapter;
import com.group7.dearbaby.shoppingcart.view.views.ViewDao;
import com.group7.dearbaby.utils.GsonUtils;

import java.io.IOException;
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

    private RecyclerViewAdapter adapter;
private List<ALingGoodsCart> carts;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShopCartPresenterImp.getShopImp().attachView(this);
    }

    @Override
    protected View initSelfView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.activity_shoppingcart, container, false);

        ButterKnife.bind(this, view);
        OkHttp3Utils.getmInstance(getContext()).doGet(ALingUrls.ALING_PAGE_INFO, null, null, new OkHttp3Utils.NetCallback() {
            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(int code, String content) {
                LogUtils.e("CARTFRAGMENT",content);
                adapter = new RecyclerViewAdapter(getActivity(),(List<ALingGoods>) GsonUtils.jsonToBeanList(content, ALingGoods.class));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void loadImage(Bitmap bitmap) {

            }
        });
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

     ShopCartPresenterImp.getShopImp().getCarts();

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
                try {
                    OkHttp3Utils.getmInstance(null).doPost(ALingUrls.CREATE_ORDER, null, null, "", 1, 0, false, new OkHttp3Utils.NetCallback() {
                        @Override
                        public void onFailure(int code, String msg) {

                        }

                        @Override
                        public void onSuccess(int code, String content) {
                           Intent intent= new Intent(getActivity(), SubmitOrderActivity.class);
                            intent.putExtra("order",content);
                            startActivity(intent);
                        }

                        @Override
                        public void loadImage(Bitmap bitmap) {

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;
            case shopping_title_edit:
                shoppingJiesuanbnt.setText("删除");

                break;
            case shopping_quanxuan:
                if (shoppingQuanxuan.isChecked()){
                    ShopCartPresenterImp.getShopImp().selctAll();


                }else {
                    ShopCartPresenterImp.getShopImp().unSelectAll();

                }

                break;
        }

    }




    /**
     * 返回选中商品的总价
     * @return
     */
    private String allPrice(List<ALingGoodsCart> carts){
        float sum=0f;
        for (ALingGoodsCart goods:carts) {
            if (goods.isSelected()){
             sum+=goods.getPrice()*goods.getCount();
            }
        }
        return "￥"+sum;
    }

    /**
     * 返回选中商品的总价
     * @return
     */
    private String allOkCount(List<ALingGoodsCart> carts){
        int  sum=0;
        for (ALingGoodsCart goods:carts) {
            if (goods.isSelected()&&!goods.isIsGiven()){
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
//           ShopCartPresenterImp.getShopImp().delete(carts);

        }else {
            List<ALingGoodsCart> good=new ArrayList<>();
            for (ALingGoodsCart goods:carts) {
                if (goods.isSelected()){
                    good.add(goods);
                }
            }
         //   ShopCartPresenterImp.getShopImp().delete(carts);
         good=null;
        }

    }


    /**
     * 每次选择 接口调用时  判断自条目是否全选 更新全选按钮状态
     * @return
     */
    public boolean isAllChose(List<ALingGoodsCart> carts) {
        boolean allChose=false;
        for (ALingGoodsCart goods:carts) {
            if (!goods.isSelected()){
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


    private void updateCbAndTV(List<ALingGoodsCart> carts){
        if (carts != null && carts.size() > 0) {
            jiesuan.setVisibility(View.VISIBLE);
            shoppingSumprice2.setText(allPrice(carts));
            shoppingJiesuanbnt.setText(allOkCount(carts));
            shoppingQuanxuan.setChecked(isAllChose(carts));
        } else {
            jiesuan.setVisibility(View.GONE);
        }


    }

    @Override
    public void getCarts(List<ALingGoodsCart> carts) {
        this.carts=carts;
        updateCbAndTV(carts);
    }

    @Override
    public void addItems(List<ALingGoodsCart> carts, String productId) {
        this.carts=carts;
        updateCbAndTV(carts);
    }

    @Override
    public void updateItems(List<ALingGoodsCart> carts) {
        this.carts=carts;
        updateCbAndTV(carts);
    }

    @Override
    public void selctAll(List<ALingGoodsCart> carts) {
        this.carts=carts;
        updateCbAndTV(carts);
    }

    @Override
    public void unSelectAll(List<ALingGoodsCart> carts) {
        this.carts=carts;
        updateCbAndTV(carts);
    }

    @Override
    public void createOrder(List<ALingGoodsCart> carts) {
        this.carts=carts;
        updateCbAndTV(carts);
    }
}
