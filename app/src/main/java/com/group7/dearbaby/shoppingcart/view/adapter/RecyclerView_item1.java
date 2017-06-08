package com.group7.dearbaby.shoppingcart.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group7.dearbaby.R;
import com.group7.dearbaby.shoppingcart.model.bean.ALingGoodsCart;
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


    private List<ALingGoodsCart> carts;



    public RecyclerView_item1(Context contexts, List<ALingGoodsCart> carts) {
        this.contexts = contexts;

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


if (carts.get(position).isIsGiven()){
    holder.shoppingnameBnt.setVisibility(View.INVISIBLE);
    holder.tvReduce.setVisibility(View.INVISIBLE);
    holder.tvAdd.setVisibility(View.INVISIBLE);
    holder.tvNum.setVisibility(View.INVISIBLE);

}else {
    holder.shoppingnameBnt.setVisibility(View.VISIBLE);
    holder.tvReduce.setVisibility(View.VISIBLE);
    holder.tvAdd.setVisibility(View.VISIBLE);
    holder.tvNum.setVisibility(View.VISIBLE);
}


                holder.shoppingnameBnt.setChecked(carts.get(position).isSelected());

holder.shoppingnameBnt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (holder.shoppingnameBnt.isChecked()){
            carts.get(position).setSelected(true);

        }else {
            carts.get(position).setSelected(false);
        }
        ShopCartPresenterImp.getShopImp().updateItems(carts.get(position).getCount(),carts.get(position).getProductId(),2,carts.get(position).isSelected());
    }
});
            Glide.with(contexts).load("http://service.alinq.cn:2800/AdminServices/Shop"
                    +carts.get(position).getImageUrl()
            +"?application-key=58424776034ff82470d06d3d&storeId=58401d1906c02a2b8877bd13").into(holder.shoppingIv);
            //Log.d("abc", carts.get(position).getPicUrl());
            holder.shoppingInpo.setText(carts.get(position).getName());
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
                    ShopCartPresenterImp.getShopImp().updateItems(carts.get(position).getCount(),carts.get(position).getProductId(),0,carts.get(position).isSelected());

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
                ShopCartPresenterImp.getShopImp().updateItems(carts.get(position).getCount(),carts.get(position).getProductId(),0,carts.get(position).isSelected());

            }
        });


    }

    @Override
    public int getItemCount() {
        return carts != null ? carts.size() : 0;
    }







    @Override
    public void getCarts(List<ALingGoodsCart> carts) {
this.carts=carts;
        notifyDataSetChanged();
    }

    @Override
    public void addItems(List<ALingGoodsCart> carts, String productId) {

        for (ALingGoodsCart cart:carts
                ) {
           if (cart.getProductId().equals(productId)){
              this.carts.add(cart);
               break;
           }
        }
        notifyDataSetChanged();
    }

    @Override
    public void updateItems(List<ALingGoodsCart> carts) {

    }

    @Override
    public void selctAll(List<ALingGoodsCart> carts) {
        for (ALingGoodsCart cart:this.carts
             ) {
           cart.setSelected(true);
        }
        notifyDataSetChanged();
    }

    @Override
    public void unSelectAll(List<ALingGoodsCart> carts) {
        for (ALingGoodsCart cart:this.carts
                ) {
            cart.setSelected(false);
        }
        notifyDataSetChanged();
    }

    @Override
    public void createOrder(List<ALingGoodsCart> carts) {

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
