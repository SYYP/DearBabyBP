package com.group7.dearbaby.shoppingcart.model.bean;

import android.graphics.Bitmap;

import com.blankj.utilcode.util.LogUtils;
import com.group7.dearbaby.shoppingcart.model.utils.ALingUrls;
import com.group7.dearbaby.shoppingcart.model.utils.OkHttp3Utils;
import com.group7.dearbaby.shoppingcart.presenter.ShopCartUpdataListener;
import com.group7.dearbaby.utils.GsonUtils;

import java.io.IOException;
import java.util.List;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-06-06.
 */

public class ALingCartImp implements ALingCart {
    private ShopCartUpdataListener listener;

    public ALingCartImp(ShopCartUpdataListener listener) {
        this.listener = listener;
    }

    @Override
    public void getCarts() {
        OkHttp3Utils.getmInstance(null).doGet(ALingUrls.ALING_ITEMS_GET, null, null, new OkHttp3Utils.NetCallback() {
            @Override
            public void onFailure(int code, String msg) {

            }
            @Override
            public void onSuccess(int code, String content) {

            listener.hadGetCarts((List<ALingGoodsCart>) GsonUtils.jsonToBeanList(content, ALingGoodsCart.class));

            }

            @Override
            public void loadImage(Bitmap bitmap) {

            }
        });
    }

    @Override
    public void addItems(final String productId) throws IOException {
        OkHttp3Utils.getmInstance(null).doPost(ALingUrls.ADD_CART_POST,null, null,productId,1,1,false,new OkHttp3Utils.NetCallback() {
            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(int code, String content) {
listener.hadAddItems((List<ALingGoodsCart>) GsonUtils.jsonToBeanList(content, ALingGoodsCart.class),productId);
            }

            @Override
            public void loadImage(Bitmap bitmap) {

            }
        });
    }

    @Override
    public void updateItems(int count,String productId,int type ,boolean isSelected) throws IOException {
     String url=ALingUrls.UPDATEITEMS;
        if (type!=0){
            url=ALingUrls.UPDATEITEM;
        }
        OkHttp3Utils.getmInstance(null).doPost(url,null, null,productId,count,type,isSelected,new OkHttp3Utils.NetCallback() {
            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(int code, String content) {

                listener.hadUpdateItems((List<ALingGoodsCart>) GsonUtils.jsonToBeanList(content, ALingGoodsCart.class));
            }

            @Override
            public void loadImage(Bitmap bitmap) {

            }
        });
    }

    @Override
    public void selctAll() throws IOException {
        OkHttp3Utils.getmInstance(null).doPost(ALingUrls.SELLECTAL,null, null,new OkHttp3Utils.NetCallback() {
            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(int code, String content) {
                LogUtils.e("selctAll",content);
                listener.hadSelectAll((List<ALingGoodsCart>) GsonUtils.jsonToBeanList(content, ALingGoodsCart.class));
            }

            @Override
            public void loadImage(Bitmap bitmap) {

            }
        });
    }

    @Override
    public void unSelectAll() throws IOException {
        OkHttp3Utils.getmInstance(null).doPost(ALingUrls.UNSELLECTALL,null, null,new OkHttp3Utils.NetCallback() {
            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(int code, String content) {
                LogUtils.e("unSelectAll",content);
                listener.hadUnSelectAll((List<ALingGoodsCart>) GsonUtils.jsonToBeanList(content, ALingGoodsCart.class));
            }

            @Override
            public void loadImage(Bitmap bitmap) {

            }
        });
    }

    @Override
    public void createOrder() {

    }
}
