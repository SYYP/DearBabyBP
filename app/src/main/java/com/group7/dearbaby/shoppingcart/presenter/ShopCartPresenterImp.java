package com.group7.dearbaby.shoppingcart.presenter;/**
 * 作者：holmes k
 * 时间：2017.05.25 08:48
 */

import android.content.Context;

import com.group7.dearbaby.shoppingcart.model.bean.GoodsDao;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsDaoImp;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;

import java.util.List;


/**
 * auth:holmes k
 * date:2017.05.25
 */
public class ShopCartPresenterImp implements ShopCartPresenter {

    private GoodsDao dao;
    private Context context;

    public ShopCartPresenterImp(Context context) {
        this.context = context;
        dao = new GoodsDaoImp(context);
    }

    @Override
    public List<GoodsForCart> queryAll() {
        List<GoodsForCart> carts = dao.queryAll();
        return carts;
    }

    @Override
    public void insert(List<GoodsForCart> goods) {

        dao.insert(goods);
    }

    @Override
    public boolean delete(int id) {

        boolean delete = dao.delete(id);
        return delete;
    }

    @Override
    public boolean upData(GoodsForCart goods) {
        boolean upData = dao.upData(goods);
        return upData;
    }
}
