package com.group7.dearbaby.home.model.utils;

import com.group7.dearbaby.home.model.bean.MainDataBean;

import java.util.List;

/**
 * 作者：holmes k
 * 时间：2017.05.17 10:43
 */


public interface GetDataUtils {

    List<String> getTitles(String path);

    MainDataBean getData(String path);

}
