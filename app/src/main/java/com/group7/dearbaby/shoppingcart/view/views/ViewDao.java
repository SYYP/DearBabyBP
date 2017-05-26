package com.group7.dearbaby.shoppingcart.view.views;/**
 * 作者：holmes k
 * 时间：2017.05.25 08:53
 */


import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;

import java.util.List;

/**
 * auth:holmes k
 * date:2017.05.25
 */
public interface ViewDao {


    //查询
    List<GoodsForCart> queryAllGoods();

    void insertGoods(List<GoodsForCart> goods);

    boolean deleteGoods(int id);

    boolean upDataGoods(GoodsForCart goods);

}
