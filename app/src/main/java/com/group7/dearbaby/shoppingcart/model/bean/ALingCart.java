package com.group7.dearbaby.shoppingcart.model.bean;

import java.io.IOException;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-06-06.
 */

public interface ALingCart {
    void getCarts();
    void addItems(String productId) throws IOException;
    void updateItems(int count,String productId,int type ,boolean isSelected) throws IOException;
    void selctAll() throws IOException;
    void unSelectAll() throws IOException;
    void createOrder();


}
