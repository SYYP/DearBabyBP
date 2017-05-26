package com.group7.dearbaby.me.presenter;

import com.group7.dearbaby.me.model.bean.GuessLike;
import com.group7.dearbaby.me.model.bean.User;

import java.util.List;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public interface Success {
    void succes(User data);
    void getGuessLike(List<GuessLike.SugGoodsBean.SkusBean> skusList);
}
