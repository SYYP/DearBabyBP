package com.group7.dearbaby.home.view.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group7.dearbaby.R;
import com.group7.dearbaby.base.BaseFragment;
import com.group7.dearbaby.home.view.adapter.HomeRecAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：holmes k
 * 时间：2017.05.17 11:15
 */


public class HomeShowDataFragment extends BaseFragment {
    @BindView(R.id.home_recVi_showData)
    RecyclerView homeRecViShowData;
    @BindView(R.id.swipe_refresh_widget)
    SwipeRefreshLayout swipeRefreshWidget;
    Unbinder unbinder;
    private List<String> itemList;
    private HomeRecAdapter adapter;
    private int lastVisibleItem;
    private Handler handler;

    @Override
    protected View initSelfView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home_showdata, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        return view;

    }


    @Override
    public void initData() {

        itemList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            itemList.add("item" + i);
        }

    }

    @Override
    public void initView(View view) {

        initData();

        handler = new Handler();

        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        homeRecViShowData.setLayoutManager(manager);
        homeRecViShowData.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        adapter = new HomeRecAdapter(getContext(), itemList);
        homeRecViShowData.setAdapter(adapter);
        swipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        swipeRefreshWidget.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        homeRecViShowData.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == adapter.getItemCount()) {
                    swipeRefreshWidget.setRefreshing(true);
                    // 此处在现实项目中，请换成网络请求数据代码，sendRequest .....
                    handler.sendEmptyMessageDelayed(0, 3000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = manager.findLastVisibleItemPosition();
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
