package com.group7.dearbaby.home.view.adapter;/**
 * Created by holmes k on 2017.05.17.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.group7.dearbaby.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * auth:holmes k
 * date:2017.05.17
 */
public class HomeRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<String> list;
    private final int VIEW_TYPE0 = 0;
    private final int VIEW_TYPE1 = 1;
    private final int VIEW_TYPE2 = 2;
    private final int VIEW_TYPE3 = 3;
    private final int VIEW_TYPE4 = 4;

    public HomeRecAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {
            case VIEW_TYPE0:
                View view0 = inflater.inflate(R.layout.home_item1, parent, false);
                holder = new HomeViewHolder0(view0);
                break;
            case VIEW_TYPE1:
                View view1 = inflater.inflate(R.layout.home_item2, parent, false);
                holder = new HomeViewHolder1(view1);
                break;
            case VIEW_TYPE2:
                View view2 = inflater.inflate(R.layout.home_item3, parent, false);
                holder = new HomeViewHolder2(view2);
                break;
            case VIEW_TYPE3:
                View view3 = inflater.inflate(R.layout.home_item4, parent, false);
                holder = new HomeViewHolder3(view3);
                break;
            case VIEW_TYPE4:
                View view4 = inflater.inflate(R.layout.home_item5, parent, false);
                holder = new HomeViewHolder4(view4);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case VIEW_TYPE0:
                HomeViewHolder0 holder0 = (HomeViewHolder0) holder;

                holder0.imgCoupon.setImageResource(R.mipmap.ic_launcher);
                break;
            case VIEW_TYPE1:
                HomeViewHolder1 holder1 = (HomeViewHolder1) holder;
                holder1.llHandrodMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showShortToast("加载更多");
                    }
                });
                holder1.titleList.setLayoutManager(new LinearLayoutManager(context,
                        LinearLayoutManager.HORIZONTAL, true));
                holder1.titleList.setAdapter(new MiaoShaAdapter(context));
                break;
            case VIEW_TYPE2:
                HomeViewHolder2 holder2 = (HomeViewHolder2) holder;

                break;
            case VIEW_TYPE3:
                HomeViewHolder3 holder3 = (HomeViewHolder3) holder;

                break;
            case VIEW_TYPE4:
                HomeViewHolder4 holder4 = (HomeViewHolder4) holder;

                break;
        }

    }

    @Override
    public int getItemCount() {
//        return list != null ? list.size() : 0;

        return 5;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {

            return VIEW_TYPE0;
        } else if (position == 1) {
            return VIEW_TYPE1;
        } else if (position == 2) {
            return VIEW_TYPE2;
        } else if (position == 3) {
            return VIEW_TYPE3;
        } else if (position == 4) {
            return VIEW_TYPE4;
        }


        return super.getItemViewType(position);
    }

    class HomeViewHolder0 extends RecyclerView.ViewHolder {

        @BindView(R.id.img_coupon)
        ImageView imgCoupon;

        public HomeViewHolder0(View itemView) {
            super(itemView);
            Unbinder bind = ButterKnife.bind(this, itemView);
        }
    }

    class HomeViewHolder1 extends RecyclerView.ViewHolder {

        @BindView(R.id.ll_handrod_more)
        LinearLayout llHandrodMore;
        @BindView(R.id.title_list)
        RecyclerView titleList;

        public HomeViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class HomeViewHolder2 extends RecyclerView.ViewHolder {

        public HomeViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class HomeViewHolder3 extends RecyclerView.ViewHolder {

        public HomeViewHolder3(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class HomeViewHolder4 extends RecyclerView.ViewHolder {

        public HomeViewHolder4(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
