package com.group7.dearbaby.home.view.adapter;/**
 * Created by holmes k on 2017.05.18.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.group7.dearbaby.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * auth:holmes k
 * date:2017.05.18
 */
public class MiaoShaAdapter extends RecyclerView.Adapter<MiaoShaAdapter.MiaoShaHolder> {


    public MiaoShaAdapter(Context context) {
        this.context = context;
    }

    private Context context;
    private List<Integer> list;

    @Override
    public MiaoShaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_item2_item, parent, false);
        MiaoShaHolder holder = new MiaoShaHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MiaoShaHolder holder, int position) {

        holder.ivGoodIcon.setImageResource(R.mipmap.ic_launcher);
        holder.tvGoodPrice.setText("$22");
        holder.tvGoodOldPrice.setText("$21");

    }

    @Override
    public int getItemCount() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        return list.size();
    }

    class MiaoShaHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_good_icon)
        ImageView ivGoodIcon;
        @BindView(R.id.tv_goodPrice)
        TextView tvGoodPrice;
        @BindView(R.id.tv_goodOldPrice)
        TextView tvGoodOldPrice;

        public MiaoShaHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
