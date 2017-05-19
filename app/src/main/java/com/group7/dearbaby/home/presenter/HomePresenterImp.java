package com.group7.dearbaby.home.presenter;

import com.group7.dearbaby.home.model.utils.Utils;
import com.group7.dearbaby.home.model.utils.UtilsImp;

import java.util.List;

/**
 * 作者：holmes k
 * 时间：2017.05.17 10:54
 */


public class HomePresenterImp implements HomePresenter {

    private Utils utils;

    @Override
    public List<String> setTitle() {
        utils = new UtilsImp();
        List<String> titles = utils.getTitles();
        return titles;
    }
}
