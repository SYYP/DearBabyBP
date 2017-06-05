package com.group7.dearbaby.shoppingcart.presenter;/**
 * 作者：holmes k
 * 时间：2017.05.25 08:48
 */

import android.content.Context;

import com.group7.dearbaby.shoppingcart.model.bean.GoodsDao;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsDaoImp;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;
import com.group7.dearbaby.shoppingcart.view.views.ViewDao;

import java.util.ArrayList;
import java.util.List;


/**
 * auth:holmes k
 * date:2017.05.25
 */
public class ShopCartPresenterImp implements ShopCartPresenter ,ShopCartUpdataListener{
private List<ViewDao> viewDaoList;

    private GoodsDao dao;
private static ShopCartPresenterImp shopCartPresenterImp;

    private  ShopCartPresenterImp(Context context) {
dao = new GoodsDaoImp(context,this);
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
    public List<GoodsForCart> queryAll() {
        List<GoodsForCart> carts = dao.queryAll();
        for (ViewDao view:viewDaoList){
            view.queryAllGoods(carts);
        }
        return carts;
    }

    @Override
    public void insert(GoodsForCart goods) {

        dao.insert(goods);
    }

    @Override
    public boolean delete(List<GoodsForCart> goods) {

        boolean delete = dao.delete(goods);
        return delete;
    }

    @Override
    public boolean upData(GoodsForCart goods) {
        boolean upData = dao.upData(goods);
        return upData;
    }
public void upData(List<GoodsForCart> carts){
    dao.upData(carts);
}
    @Override
    public void detachView(ViewDao view) {
viewDaoList.remove(view);
    }


    @Override
    public void dataChange(List<GoodsForCart> goods) {
        for (ViewDao view:
              viewDaoList) {
            view.upDataUI(goods);
        }
    }


}
