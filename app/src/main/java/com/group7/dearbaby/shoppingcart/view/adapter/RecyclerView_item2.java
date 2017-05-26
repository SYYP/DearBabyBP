package com.group7.dearbaby.shoppingcart.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group7.dearbaby.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/25 13:52
 */

public class RecyclerView_item2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<?> list = new ArrayList<>();

    public RecyclerView_item2(Context context) {
        this.context = context;
    }

    private Context context;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_shopping_tiem2, parent, false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
    public class Viewholder extends RecyclerView.ViewHolder{

        public Viewholder(View itemView) {
            super(itemView);
        }
    }
}
