package com.group7.dearbaby.shoppingcart.model.bean;/**
 * Created by holmes k on 2017.05.24.
 */

/**
 * auth:holmes k
 * date:2017.05.24
 */
public class GoodsForCart {
    private int gid;
    private int isChecked;
    private String picUrl;
    private String title;
    private int price;
    private int count;


    public GoodsForCart(int gid, int isChecked, String picUrl, String title, int price, int count) {
        this.isChecked = isChecked;
        this.picUrl = picUrl;
        this.title = title;
        this.price = price;
        this.count = count;
        this.gid = gid;
    }


    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "GoodsForCart{" +
                "gid=" + gid +
                ", isChecked=" + isChecked +
                ", picUrl='" + picUrl + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
