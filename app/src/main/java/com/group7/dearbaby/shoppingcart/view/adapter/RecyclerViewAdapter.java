package com.group7.dearbaby.shoppingcart.view.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group7.dearbaby.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/25 9:35
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPEONE = 1;
    private static final int TYPETWO = 2;



    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    @Override
    public int getItemViewType(int position) {
        int i = position % 2;
        if (i == 0) {
            return TYPEONE;
        } else if (i == 1) {
            return TYPETWO;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPEONE) {
            View view = LayoutInflater.from(context).inflate(R.layout.shopping_item, parent, false);

            Viewholder1 viewholder1 = new Viewholder1(view);
            return viewholder1;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.shopping_item2_recyclerview, parent, false);
            Viewholder2 viewholder2 = new Viewholder2(view);
            return viewholder2;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.shopping_item_recyclerview)
        RecyclerView shoppingItemRecyclerview;

        public Viewholder1(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
            shoppingItemRecyclerview = (RecyclerView) itemView.findViewById(R.id.shopping_item_recyclerview);
            shoppingItemRecyclerview.setLayoutManager(new LinearLayoutManager(context));
            shoppingItemRecyclerview.setAdapter(new RecyclerView_item1(context));
        }
    }

    public class Viewholder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.item2_recyclerview)
        RecyclerView item2Recyclerview;

        public Viewholder2(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
            item2Recyclerview = (RecyclerView) itemView.findViewById(R.id.item2_recyclerview);
            item2Recyclerview.setLayoutManager(new GridLayoutManager(context,2));
            item2Recyclerview.setAdapter(new RecyclerView_item2(context));
            item2Recyclerview.addItemDecoration(new RecyclerViewDividerItemDecoration(context));
        }
    }
}
