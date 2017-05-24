package com.group7.dearbaby.me.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group7.dearbaby.R;
import com.group7.dearbaby.me.model.bean.User;
import com.group7.dearbaby.me.model.url.Url;

import java.util.List;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<User.DataBean>list;

    public MyRecyclerAdapter(Context context, List<User.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    private int Kind=0;
    private int Kind1=1;
    private int Kind2=2;
    private int Kind3=3;
    private int Kind4=4;
    private int Kind5=5;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //判断条目添加布局
       if(viewType==Kind){
           View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recylogin_item,parent,false);
           ViewHolder viewHolder=new ViewHolder(view);
           return viewHolder;
       }
        else if(viewType==Kind1){
           View view1= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelogin_neck,parent,false);
           ViewHolder1 viewHolder1=new ViewHolder1(view1);
           return viewHolder1;
       }
        else if(viewType==Kind2){
           View view2= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelogin_color,parent,false);
           ViewHolder2 viewHolder2=new ViewHolder2(view2);
           return viewHolder2;
       }
        else if(viewType==Kind3){
           View view3= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelogin_gride,parent,false);
           ViewHolder3 viewHolder3=new ViewHolder3(view3);
           return viewHolder3;

       }
        else if(viewType==Kind4){
           View view4= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlogin_like,parent,false);
           ViewHolder4 viewHolder4=new ViewHolder4(view4);
           return  viewHolder4;
       }
        else if(viewType==Kind5){
           View view5= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelogin_gride,parent,false);
           ViewHolder5 viewHolder5=new ViewHolder5(view5);
           return viewHolder5;
       }
           return  null;
    }
//绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //通过判断holder属于哪个布局，绑定不同的数据
        //绑定第一个布局
          if(holder instanceof ViewHolder){
                 ViewHolder ho= (ViewHolder) holder;
              ho.litem_img.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                  }
              });
              ho.litem_address.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                  }
              });
          }
        else if(holder instanceof ViewHolder3){
              ViewHolder3 ho3= (ViewHolder3) holder;
              List<User.DataBean.TagBean> tag = list.get(0).getTag();

             ho3.litem_text1.setText(tag.get(0).getElementName());
              Glide
                      .with(context)
                      .load(Url.PIC_TITLE+list.get(0).getTag().get(0).getPicUrl())
                      .into(ho3.litem_imag1);
              ho3.litem_text2.setText(list.get(1).getTag().get(0).getElementName());
              Glide
                      .with(context)
                      .load(Url.PIC_TITLE+list.get(1).getTag().get(0).getPicUrl())
                      .into(ho3.litem_imag2);
              ho3.litem_text3.setText(list.get(2).getTag().get(0).getElementName());
              Glide
                      .with(context)
                      .load(Url.PIC_TITLE+list.get(2).getTag().get(0).getPicUrl())
                      .into(ho3.litem_imag3);
              ho3.litem_text4.setText(list.get(3).getTag().get(0).getElementName());
              Glide
                      .with(context)
                      .load(Url.PIC_TITLE+list.get(3).getTag().get(0).getPicUrl())
                      .into(ho3.litem_imag4);
              ho3.litem_text1.setText(list.get(4).getTag().get(0).getElementName());
              Glide
                      .with(context)
                      .load(Url.PIC_TITLE+list.get(4).getTag().get(0).getPicUrl())
                      .into(ho3.litem_imag1);
              ho3.litem_text5.setText(Url.PIC_TITLE+list.get(5).getTag().get(0).getElementName());
              Glide
                      .with(context)
                      .load(Url.PIC_TITLE+list.get(5).getTag().get(0).getPicUrl())
                      .into(ho3.litem_imag5);
              ho3.litem_text6.setText(list.get(6).getTag().get(0).getElementName());
              Glide
                      .with(context)
                      .load(Url.PIC_TITLE+list.get(6).getTag().get(0).getPicUrl())
                      .into(ho3.litem_imag6);

          }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

      public static  class ViewHolder extends RecyclerView.ViewHolder {
          private ImageView  litem_img,litem_vip;
          private TextView litem_address,litem_num;
          public ViewHolder(View itemView) {
              super(itemView);
              litem_img= (ImageView) itemView.findViewById(R.id.litem_img);
              litem_vip= (ImageView) itemView.findViewById(R.id. litem_vips);
              litem_address= (TextView) itemView.findViewById(R.id.litem_address);
              litem_num= (TextView) itemView.findViewById(R.id.litem_num);

          }
      }
    //第二个布局
    public static  class ViewHolder1 extends RecyclerView.ViewHolder {
        public ViewHolder1(View itemView) {
            super(itemView);
        }
    }
    //第三个布局
    public static  class ViewHolder2 extends RecyclerView.ViewHolder {

        public ViewHolder2(View itemView) {
            super(itemView);
        }
    }
    //第四个布局
    public static  class ViewHolder3 extends RecyclerView.ViewHolder {
        private ImageView litem_imag1,litem_imag2,
                litem_imag3,litem_imag4,litem_imag5,litem_imag6;
        private TextView litem_text1,litem_text2,litem_text3,litem_text4,litem_text5,
                litem_text6;
        public ViewHolder3(View itemView) {
            super(itemView);
            litem_imag1= (ImageView) itemView.findViewById(R.id.litem_img1);
            litem_imag2= (ImageView) itemView.findViewById(R.id.litem_img2);
            litem_imag3= (ImageView) itemView.findViewById(R.id.litem_img3);
            litem_imag4= (ImageView) itemView.findViewById(R.id.litem_img5);
            litem_imag5= (ImageView) itemView.findViewById(R.id.litem_img5);
            litem_imag6= (ImageView) itemView.findViewById(R.id.litem_img6);
            litem_text1= (TextView) itemView.findViewById(R.id.litem_text1);
            litem_text2= (TextView) itemView.findViewById(R.id.litem_text2);
            litem_text3= (TextView) itemView.findViewById(R.id.litem_text3);
            litem_text4= (TextView) itemView.findViewById(R.id.litem_text4);
            litem_text5= (TextView) itemView.findViewById(R.id.litem_text5);
            litem_text6= (TextView) itemView.findViewById(R.id.litem_text6);
        }
    }
    //第wu个布局
    public static  class ViewHolder4 extends RecyclerView.ViewHolder {
        private GridView litem_grade;
        public ViewHolder4(View itemView) {
            super(itemView);

        }
    }
    //第wu个布局
    public static  class ViewHolder5 extends RecyclerView.ViewHolder {
        private GridView litem_grade;
        public ViewHolder5(View itemView) {
            super(itemView);
            litem_grade= (GridView) itemView.findViewById(R.id.recycler_grades);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int i=position%6;
        if(i==0){
            return Kind;
        }
        else if(i==1){
            return Kind1;
        }
        else if(i==2){
            return Kind2;
        }
        else if(i==3){
            return Kind3;
        }
        else if(i==4){
            return Kind4;
        }
        else if(i==5){
            return Kind5;
        }

        return 0;
    }

}
