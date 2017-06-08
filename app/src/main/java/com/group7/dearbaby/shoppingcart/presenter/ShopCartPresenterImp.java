package com.group7.dearbaby.shoppingcart.presenter;/**
 * 作者：holmes k
 * 时间：2017.05.25 08:48
 */

import android.content.Context;

import com.group7.dearbaby.shoppingcart.model.bean.ALingCart;
import com.group7.dearbaby.shoppingcart.model.bean.ALingCartImp;
import com.group7.dearbaby.shoppingcart.model.bean.ALingGoodsCart;
import com.group7.dearbaby.shoppingcart.view.views.ViewDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * auth:holmes k
 * date:2017.05.25
 */
public class ShopCartPresenterImp implements ShopCartPresenter ,ShopCartUpdataListener{
private List<ViewDao> viewDaoList;
private ALingCart aLingCart;
   // private GoodsDao dao;
private static ShopCartPresenterImp shopCartPresenterImp;

    private  ShopCartPresenterImp(Context context) {
//dao = new GoodsDaoImp(context,this);
       aLingCart=new ALingCartImp(this);
viewDaoList=new ArrayList<>();
    }


    public static void init(Context context) {
        if (shopCartPresenterImp==null)synchronized (ShopCartPresenterImp.class){
            shopCartPresenterImp
                    =new ShopCartPresenterImp(context);
        }
    }
public static ShopCartPresenterImp getShopImp(){
    if (shopCartPresenterImp==null){
        try {
            throw new Exception("YOU MUST INIT ShopCartPresenterImp　IN　YOUR　ＡＰＰＬＩＣＡＴＩＯＮ");
        } catch (Exception e) {
            e.printStackTrace();
        }}
      return   shopCartPresenterImp;
}
    @Override
    public void attachView(ViewDao view) {

if (viewDaoList==null){
    try {
        throw new Exception("YOU MUST INIT ShopCartPresenterImp　IN　YOUR　ＡＰＰＬＩＣＡＴＩＯＮ");
    } catch (Exception e) {
        e.printStackTrace();
    }

}
viewDaoList.add(view);
    }

    @Override
    public void getCarts() {
aLingCart.getCarts();
    }

    @Override
    public void addItems(String productId) {
        try {
            aLingCart.addItems(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItems(int count,String productId,int type ,boolean isSelected) {
        try {
            aLingCart.updateItems(count,productId,type,isSelected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selctAll() {
        try {
            aLingCart.selctAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unSelectAll() {
        try {
            aLingCart.unSelectAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createOrder() {

    }


    @Override
    public void detachView(ViewDao view) {
viewDaoList.remove(view);
    }


    @Override
    public void hadGetCarts(List<ALingGoodsCart> carts) {
        if(carts!=null)
for (ViewDao dao:viewDaoList){
    dao.getCarts(carts);
}
    }

    @Override
    public void hadAddItems(List<ALingGoodsCart> carts, String productId) {
        if(carts!=null)
        for (ViewDao dao:viewDaoList){
            dao.addItems(carts,productId);
        }
    }

    @Override
    public void hadUpdateItems(List<ALingGoodsCart> carts) {
        if(carts!=null)
        for (ViewDao dao:viewDaoList){
            dao.updateItems(carts);
        }
    }

    @Override
    public void hadSelectAll(List<ALingGoodsCart> carts) {
        if(carts!=null)
        for (ViewDao dao:viewDaoList){
            dao.selctAll(carts);
        }
    }

    @Override
    public void hadUnSelectAll(List<ALingGoodsCart> carts) {
        if(carts!=null)
        for (ViewDao dao:viewDaoList){
            dao.unSelectAll(carts);
        }
    }

    @Override
    public void hadCreateOrder(List<ALingGoodsCart> carts) {

    }
}
