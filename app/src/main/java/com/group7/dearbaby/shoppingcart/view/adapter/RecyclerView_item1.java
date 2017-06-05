package com.group7.dearbaby.shoppingcart.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group7.dearbaby.R;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;
import com.group7.dearbaby.shoppingcart.presenter.ShopCartPresenterImp;
import com.group7.dearbaby.shoppingcart.view.views.ViewDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/25 13:48
 */

public class RecyclerView_item1 extends RecyclerView.Adapter<RecyclerView_item1.MyViewHolder> implements ViewDao {


    private List<GoodsForCart> carts;



    public RecyclerView_item1(Context contexts, List<GoodsForCart> carts) {
        this.contexts = contexts;
        this.carts = carts;
    ShopCartPresenterImp.getShopImp().attachView(this);
    }

    private Context contexts;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexts).inflate(R.layout.activity_shopping_item, parent, false);
        MyViewHolder viewholder = new MyViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {





                holder.shoppingnameBnt.setChecked(carts.get(position).getIsChecked()!=0);

holder.shoppingnameBnt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (holder.shoppingnameBnt.isChecked()){
            carts.get(position).setIsChecked(1);

        }else {
            carts.get(position).setIsChecked(0);
        }
        ShopCartPresenterImp.getShopImp().upData(carts.get(position));
    }
});
            Glide.with(contexts).load(carts.get(position).getPicUrl()).into(holder.shoppingIv);
            Log.d("abc", carts.get(position).getPicUrl());
            holder.shoppingInpo.setText(carts.get(position).getTitle());
            holder.shoppingPrice.setText(carts.get(position).getPrice() + "");
           int count = carts.get(position).getCount();
            holder.tvNum.setText(count + "");
            if (count == 1) {
                holder.tvReduce.setTextColor(contexts.getResources().getColor(R.color.grgray));
            } else {
                holder.tvReduce.setTextColor(contexts.getResources().getColor(R.color.grey_color1));
            }

        holder.tvReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int  count = carts.get(position).getCount();
                if (count <= 1) {
                    holder.tvReduce.setEnabled(false);
                } else {
                    holder.tvReduce.setEnabled(true);
                    count--;
                    holder.tvNum.setText(count + "");

                    carts.get(position).setCount(count);
                    ShopCartPresenterImp.getShopImp().upData(carts.get(position));
                }
            }
        });
        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int count = carts.get(position).getCount();
                count++;
                holder.tvNum.setText(count + "");

                carts.get(position).setCount(count);
                ShopCartPresenterImp.getShopImp().upData(carts.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return carts != null ? carts.size() : 0;
    }

    @Override
    public void queryAllGoods(List<GoodsForCart> carts) {

    }



    @Override
    public void upDataUI(List<GoodsForCart> goods) {
this.carts.clear();
        notifyDataSetChanged();
        carts.addAll(goods);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.shoppingname_bnt)
        CheckBox shoppingnameBnt;
        @BindView(R.id.shopping_iv)
        ImageView shoppingIv;
        @BindView(R.id.shopping_inpo)
        TextView shoppingInpo;
        @BindView(R.id.shopping_price)
        TextView shoppingPrice;
        @BindView(R.id.tv_reduce)
        TextView tvReduce;
        @BindView(R.id.tv_num)
        EditText tvNum;
        @BindView(R.id.tv_add)
        TextView tvAdd;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
