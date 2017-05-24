package com.group7.dearbaby.me.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group7.dearbaby.R;
import com.group7.dearbaby.base.BaseFragment;
import com.group7.dearbaby.me.model.bean.User;
import com.group7.dearbaby.me.presenter.PreImp;
import com.group7.dearbaby.me.view.Shuju;
import com.group7.dearbaby.me.view.adapter.MyRecyclerAdapter;

import java.util.List;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-16.
 */

public class MineFragment extends BaseFragment implements Shuju {

    private RecyclerView recyclerView;


    @Override
    protected View initSelfView(LayoutInflater inflater, ViewGroup container) {
        //填充视图
        View v=inflater.inflate(R.layout.loginsuccess,container,false);
        PreImp imp=new PreImp(this);

        return v;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(View view) {
        //获得资源id
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        //获得模式
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }

    @Override
    public void result(List<User.DataBean> lists) {
        MyRecyclerAdapter adapter=new MyRecyclerAdapter(getActivity(),lists);
          recyclerView.setAdapter(adapter);
    }
}
