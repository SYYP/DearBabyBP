package com.group7.dearbaby.shoppingcart.presenter;

import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;

import java.util.List;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-06-04.
 */

public interface ShopCartUpdataListener {
    void dataChange(List<GoodsForCart> goods);
}
