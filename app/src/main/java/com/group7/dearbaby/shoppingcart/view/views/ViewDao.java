package com.group7.dearbaby.shoppingcart.view.views;/**
 * 作者：holmes k
 * 时间：2017.05.25 08:53
 */


import com.group7.dearbaby.shoppingcart.model.bean.ALingGoodsCart;

import java.util.List;

/**
 * auth:holmes k
 * date:2017.05.25
 */
public interface ViewDao {


    void getCarts(List<ALingGoodsCart> carts);
    void addItems(List<ALingGoodsCart> carts,String productId);
    void updateItems(List<ALingGoodsCart> carts);
    void selctAll(List<ALingGoodsCart> carts);
    void unSelectAll(List<ALingGoodsCart> carts);
    void createOrder(List<ALingGoodsCart> carts);
}
