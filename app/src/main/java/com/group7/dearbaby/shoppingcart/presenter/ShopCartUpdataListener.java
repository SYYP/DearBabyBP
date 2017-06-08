package com.group7.dearbaby.shoppingcart.presenter;

import com.group7.dearbaby.shoppingcart.model.bean.ALingGoodsCart;

import java.util.List;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-06-04.
 */

public interface ShopCartUpdataListener {
    void hadGetCarts(List<ALingGoodsCart> carts);
    void hadAddItems(List<ALingGoodsCart> carts, String productId);
    void hadUpdateItems(List<ALingGoodsCart> carts);
    void hadSelectAll(List<ALingGoodsCart> carts);
    void hadUnSelectAll(List<ALingGoodsCart> carts);
    void hadCreateOrder(List<ALingGoodsCart> carts);
}
