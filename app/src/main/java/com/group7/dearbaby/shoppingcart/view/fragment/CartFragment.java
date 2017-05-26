package com.group7.dearbaby.shoppingcart.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.group7.dearbaby.R;
import com.group7.dearbaby.base.BaseFragment;
import com.group7.dearbaby.shoppingcart.view.activity.SubmitOrderActivity;
import com.group7.dearbaby.shoppingcart.view.adapter.RecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.group7.dearbaby.R.id.shopping_jiesuanbnt;
import static com.group7.dearbaby.R.id.shopping_jiesuantext;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-16.
 */

public class CartFragment extends BaseFragment implements View.OnClickListener{

    @BindView(R.id.shopping_title_tv)
    TextView shoppingTitleTv;
    @BindView(R.id.shopping_title_edit)
    TextView shoppingTitleEdit;
    @BindView(R.id.shopping_recyclerView)
    RecyclerView shoppingRecyclerView;
    @BindView(R.id.shopping_quanxuan)
    CheckBox shoppingQuanxuan;
    @BindView(shopping_jiesuanbnt)
    TextView shoppingJiesuanbnt;
    @BindView(R.id.shopping_sumprice2)
    TextView shoppingSumprice2;
    @BindView(R.id.shopping_sumprice)
    TextView shoppingSumprice;
    Unbinder unbinder;
    private RecyclerView recyclerView;
    private TextView textView;

    @Override
    protected View initSelfView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.activity_shoppingcart, container, false);

        return view;
    }

    @Override
    public void initData() {
        textView = (TextView) getView().findViewById(R.id.shopping_jiesuantext);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(getActivity()));
        textView.setOnClickListener(this);
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.shopping_recyclerView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case shopping_jiesuantext:
                startActivity(new Intent(getActivity(), SubmitOrderActivity.class));
                break;
        }

    }
}
