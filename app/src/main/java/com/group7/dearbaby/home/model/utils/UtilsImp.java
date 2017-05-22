package com.group7.dearbaby.home.model.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：holmes k
 * 时间：2017.05.17 10:47
 */


public class UtilsImp implements Utils {

    @Override
    public List<String> getTitles() {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add("测试" + i);
        }

        return list;
    }
}
