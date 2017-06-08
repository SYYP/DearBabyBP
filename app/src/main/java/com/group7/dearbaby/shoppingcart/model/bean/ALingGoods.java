package com.group7.dearbaby.shoppingcart.model.bean;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-06-06.
 */

public class ALingGoods {
    /**
     * Id : 4ca870cb-80e8-4f55-9864-404c087ee7e5
     * Name : 合禾果枇杷蜜
     * Price : 68.0
     * CreateDateTime : 2015-07-26T20:45:04
     * Unit : 300g
     * ProductId : 205338e7-33de-46aa-ad79-4ac56dfdc9ef
     * ImagePath : /Images/Editor/96a34cac654f47e9acb46c4ca0ca169a_360_360.jpeg
     * MemberPrice : 68.0
     * ApplicationId : 7bbfa36c-8115-47ad-8d47-9e52b58e7efd
     * PromotionLabel : Given|Reduce
     */

    private String Id;
    private String Name;
    private double Price;
    private String CreateDateTime;
    private String Unit;
    private String ProductId;
    private String ImagePath;
    private double MemberPrice;
    private String ApplicationId;
    private String PromotionLabel;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(String CreateDateTime) {
        this.CreateDateTime = CreateDateTime;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String ImagePath) {
        this.ImagePath = ImagePath;
    }

    public double getMemberPrice() {
        return MemberPrice;
    }

    public void setMemberPrice(double MemberPrice) {
        this.MemberPrice = MemberPrice;
    }

    public String getApplicationId() {
        return ApplicationId;
    }

    public void setApplicationId(String ApplicationId) {
        this.ApplicationId = ApplicationId;
    }

    public String getPromotionLabel() {
        return PromotionLabel;
    }

    public void setPromotionLabel(String PromotionLabel) {
        this.PromotionLabel = PromotionLabel;
    }
}
