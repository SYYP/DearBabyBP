package com.group7.dearbaby.shoppingcart.presenter;/**
 * Created by holmes k on 2017.05.24.
 */


import com.group7.dearbaby.shoppingcart.view.views.ViewDao;

/**
 * auth:holmes k
 * date:2017.05.24
 */
public interface ShopCartPresenter {

void attachView(ViewDao view);
    void getCarts();
    void addItems(String productId);
    void updateItems(int count,String productId,int type ,boolean isSelected);
    void selctAll();
    void unSelectAll();
    void createOrder();
    void detachView(ViewDao view);

}
