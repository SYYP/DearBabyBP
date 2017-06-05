package com.group7.dearbaby.shoppingcart.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group7.dearbaby.R;
import com.group7.dearbaby.home.model.bean.Urls;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsBean;
import com.group7.dearbaby.shoppingcart.model.bean.GoodsForCart;
import com.group7.dearbaby.shoppingcart.presenter.ShopCartPresenterImp;
import com.group7.dearbaby.shoppingcart.view.views.ViewDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：DearBabyBP
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/25 13:52
 */

public class RecyclerView_item2 extends RecyclerView.Adapter<RecyclerView_item2.MyViewholder> implements ViewDao{


    private List<GoodsBean.SugGoodsBean> sugGoods;
    private Context context;


    public RecyclerView_item2(Context context, List<GoodsBean.SugGoodsBean> sugGoods) {
        this.context = context;
        this.sugGoods = sugGoods;
      ShopCartPresenterImp.getShopImp().attachView(this);
    }


    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_shopping_tiem2, parent, false);
        MyViewholder viewholder = new MyViewholder(view);
        return viewholder;
    }



    @Override
    public void onBindViewHolder(MyViewholder holder, final int position) {
        String picPath = null;
        String code = sugGoods.get(0).getSkus().get(position).getSugGoodsCode();
        if (!TextUtils.isEmpty(code)) {
            picPath = Urls.GOODSCAR_PIC_TITLE + code + Urls.GOODSCAR_PIC_FOOT;
            Glide.with(context).load(picPath).into(holder.imageView2);
        }
        holder.jiage.setText(sugGoods.get(0).getSkus().get(position).getPrice());
        holder.textView.setText(sugGoods.get(0).getSkus().get(position).getSugGoodsName());
        holder.textView2.setText(sugGoods.get(0).getSkus().get(position).getSalesVolume() + "人已购买");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(context,);
//                context.startActivity(intent);
            }
        });

        final String finalPicPath = picPath;
        holder.addToCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsForCart cart = new GoodsForCart();

                cart.setPrice(Double.parseDouble(sugGoods.get(0).getSkus().get(position).getPrice()));
                cart.setCount(1);
                cart.setIsChecked(1);
                cart.setPicUrl(finalPicPath);
                cart.setTitle(sugGoods.get(0).getSkus().get(position).getSugGoodsName());
                ShopCartPresenterImp.getShopImp().insert(cart);



            }
        });
    }


    @Override
    public int getItemCount() {
        return sugGoods != null ? sugGoods.get(0).getSkus().size() : 0;
    }

    @Override
    public void queryAllGoods(List<GoodsForCart> carts) {

    }



    @Override
    public void upDataUI(List<GoodsForCart> goods) {

    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView2)
        ImageView imageView2;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.jiage)
        TextView jiage;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.iv_add)
        ImageView addToCar;

        public MyViewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
