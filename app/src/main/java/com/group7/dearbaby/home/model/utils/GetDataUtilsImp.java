package com.group7.dearbaby.home.model.utils;

import com.google.gson.Gson;
import com.group7.dearbaby.home.model.bean.MainDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：holmes k
 * 时间：2017.05.17 10:47
 */


public class GetDataUtilsImp implements GetDataUtils {


    @Override
    public List<String> getTitles(String path) {
        List<String> list = new ArrayList<>();

        list.add("上新");
        list.add("纸尿裤");
        list.add("奶粉");
        list.add("洗护喂养");
        list.add("玩具");
        list.add("服饰");
        list.add("图书");
        list.add("车床座椅");


        return list;
    }

    @Override
    public MainDataBean getData(String path) {

        String data = OkHttpManager.getSyncString(path);

        Gson gson = new Gson();
        MainDataBean dataBean = gson.fromJson(data, MainDataBean.class);

        return dataBean;
    }
}
