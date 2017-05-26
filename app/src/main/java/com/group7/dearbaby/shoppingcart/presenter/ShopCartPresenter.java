package com.group7.dearbaby.shoppingcart.presenter;/**
 * Created by holmes k on 2017.05.24.
 */


import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;

import java.util.List;

/**
 * auth:holmes k
 * date:2017.05.24
 */
public interface ShopCartPresenter {

    //查询
    List<GoodsForCart> queryAll();

    void insert(List<GoodsForCart> goods);

    boolean delete(int id);

    boolean upData(GoodsForCart goods);


}
