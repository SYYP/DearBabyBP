package com.group7.dearbaby.me.view;

import com.group7.dearbaby.me.model.bean.GuessLike;
import com.group7.dearbaby.me.model.bean.User;

import java.util.List;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public interface Shuju {
    void result(User data);
    void getGuessLike(List<GuessLike.SugGoodsBean.SkusBean> list);
}
