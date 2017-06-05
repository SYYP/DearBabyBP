package com.group7.dearbaby.shoppingcart.model.bean;/**
 * Created by holmes k on 2017.05.24.
 */

import java.util.List;

/**
 * auth:holmes k
 * date:2017.05.24
 */
public interface GoodsDao {


    //查询
    List<GoodsForCart> queryAll();

    void insert(GoodsForCart goods);

    boolean delete(List<GoodsForCart> goods);
    void upData(List<GoodsForCart> carts);
    boolean upData(GoodsForCart goods);
}
