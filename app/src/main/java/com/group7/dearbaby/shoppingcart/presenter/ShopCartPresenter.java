package com.group7.dearbaby.shoppingcart.presenter;/**
 * Created by holmes k on 2017.05.24.
 */


import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;
import com.group7.dearbaby.shoppingcart.view.views.ViewDao;

import java.util.List;

/**
 * auth:holmes k
 * date:2017.05.24
 */
public interface ShopCartPresenter {

void attachView(ViewDao view);
    //查询
    List<GoodsForCart> queryAll();

    void insert(GoodsForCart goods);
    void upData(List<GoodsForCart> carts);
    boolean delete(List<GoodsForCart> goods);

    boolean upData(GoodsForCart goods);
void detachView(ViewDao view);

}
