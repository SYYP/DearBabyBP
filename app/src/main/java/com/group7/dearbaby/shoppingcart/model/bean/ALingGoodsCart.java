package com.group7.dearbaby.shoppingcart.model.bean;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-06-06.
 */

public class ALingGoodsCart {

    /**
     * Id : 441d5430-8a58-4c63-87b0-fe2702791cbf
     * ProductId : f520c6ca-ced6-4e25-83ac-dd350ce3ae0e
     * Count : 1
     * ImageUrl : /Images/Editor/7e18b4514314447387613d6b5fdd37d3_640_640.jpeg
     * Name : 8848新款韩版双肩包DYBN0014-C062-1
     * Price : 96
     * Unit : 桔色
     * Amount : 96
     * Selected : true
     * IsGiven : false
     * Remark : null
     * Score : null
     */

    private String Id;
    private String ProductId;
    private int Count;
    private String ImageUrl;
    private String Name;
    private float Price;
    private String Unit;
    private double Amount;
    private boolean Selected;
    private boolean IsGiven;
    private Object Remark;
    private Object Score;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean Selected) {
        this.Selected = Selected;
    }

    public boolean isIsGiven() {
        return IsGiven;
    }

    public void setIsGiven(boolean IsGiven) {
        this.IsGiven = IsGiven;
    }

    public Object getRemark() {
        return Remark;
    }

    public void setRemark(Object Remark) {
        this.Remark = Remark;
    }

    public Object getScore() {
        return Score;
    }

    public void setScore(Object Score) {
        this.Score = Score;
    }

}
