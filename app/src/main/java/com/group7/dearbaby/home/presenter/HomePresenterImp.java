package com.group7.dearbaby.home.presenter;

import com.group7.dearbaby.home.model.utils.GetDataUtils;
import com.group7.dearbaby.home.model.utils.GetDataUtilsImp;

import java.util.List;

/**
 * 作者：holmes k
 * 时间：2017.05.17 10:54
 */


public class HomePresenterImp implements HomePresenter {

    private GetDataUtils utils;

    @Override
    public List<String> setTitle() {
        utils = new GetDataUtilsImp();
        List<String> titles = utils.getTitles("");//放头布局的接口
        return titles;
    }
}
