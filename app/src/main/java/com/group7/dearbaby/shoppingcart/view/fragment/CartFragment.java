package com.group7.dearbaby.shoppingcart.view.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.group7.dearbaby.R;
import com.group7.dearbaby.base.BaseFragment;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsBean;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;
import com.group7.dearbaby.shoppingcart.model.utils.GetGoods;
import com.group7.dearbaby.shoppingcart.presenter.ShopCartPresenterImp;
import com.group7.dearbaby.shoppingcart.view.activity.SubmitOrderActivity;
import com.group7.dearbaby.shoppingcart.view.adapter.RecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.group7.dearbaby.R.id.shopping_jiesuantext;
import static com.group7.dearbaby.R.id.shopping_title_edit;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-16.
 */

public class CartFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.shopping_title_tv)
    TextView shoppingTitleTv;
    @BindView(R.id.shopping_title_edit)
    TextView shoppingTitleEdit;
    @BindView(R.id.shopping_recyclerView)
    RecyclerView shoppingRecyclerView;
    @BindView(R.id.shopping_quanxuan)
    CheckBox shoppingQuanxuan;
    @BindView(R.id.shopping_sumprice2)
    TextView shoppingSumprice2;
    @BindView(R.id.shopping_sumprice)
    TextView shoppingSumprice;
    Unbinder unbinder;
    @BindView(R.id.shopping_jiesuantext)
    TextView shoppingJiesuantext;
    @BindView(R.id.shopping_jiesuanbnt)
    TextView shoppingJiesuanbnt;
    @BindView(R.id.jiesuan)
    RelativeLayout jiesuan;
    private RecyclerView recyclerView;
    private TextView textView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                List<GoodsBean.SugGoodsBean> sugGoods =
                        (List<GoodsBean.SugGoodsBean>) msg.obj;
                adapter = new RecyclerViewAdapter(getActivity(), sugGoods);
                recyclerView.setAdapter(adapter);
            }
        }
    };
    private RecyclerViewAdapter adapter;

    @Override
    protected View initSelfView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.activity_shoppingcart, container, false);
        new GetGoods(handler).start();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        initData();

    }

    @Override
    public void initData() {
        textView = (TextView) getView().findViewById(R.id.shopping_jiesuantext);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<GoodsForCart> carts = new ShopCartPresenterImp(getContext()).queryAll();
        if (carts != null && carts.size() > 0) {
            jiesuan.setVisibility(View.VISIBLE);
        } else {
            jiesuan.setVisibility(View.GONE);
        }

        textView.setOnClickListener(this);
        shoppingTitleEdit.setOnClickListener(this);
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.shopping_recyclerView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case shopping_jiesuantext:
                startActivity(new Intent(getActivity(), SubmitOrderActivity.class));
                break;
            case shopping_title_edit:
                shoppingJiesuanbnt.setText("删除");

                break;
        }

    }


}
