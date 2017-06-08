package com.group7.dearbaby.shoppingcart.model.bean;

import java.util.List;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-06-07.
 */

public class CreateOrder {

    /**
     * Id : 38b2b78a-ad22-4b66-b4d9-d787aac840a9
     * BalanceAmount : 0
     * Consignee : null
     * CreateDateTime : 2017-06-07T10:08:46.2284623+08:00
     * CustomerId : 5e69475d-5135-4eb0-9215-068c2c10c747
     * Discount : 200
     * CouponDiscount : 0
     * CouponTitle :
     * Freight : 0
     * OrderDate : null
     * Serial : null
     * Invoice : null
     * OrderDetails : [{"Price":34,"ProductId":"205338e7-33de-46aa-ad79-4ac56dfdc9ef","ProductName":"合禾果枇杷蜜","Unit":"300g","Score":null,"ImageUrl":"/Images/Editor/96a34cac654f47e9acb46c4ca0ca169a_360_360.jpeg","Quantity":22},{"Price":68,"ProductId":"1bbf27c4-a94b-497d-9937-a4bb0fa87a53","ProductName":"合禾果西西果蜜","Unit":"300g","Score":null,"ImageUrl":"/Images/Editor/256d65e8019a463b84d9e39510a56e82_360_360.jpeg","Quantity":5},{"Price":96,"ProductId":"f520c6ca-ced6-4e25-83ac-dd350ce3ae0e","ProductName":"8848新款韩版双肩包DYBN0014-C062-1","Unit":"桔色","Score":null,"ImageUrl":"/Images/Editor/7e18b4514314447387613d6b5fdd37d3_640_640.jpeg","Quantity":1},{"Price":312,"ProductId":"48f5e9d9-13e8-4061-96de-e3bb8217b4e3","ProductName":"爱他美深度水解蛋白配方奶粉Pepti","Unit":"400g/罐","Score":null,"ImageUrl":"/Images/Editor/2910dde0fd4e479a803e89f055c891e4_360_360.jpeg","Quantity":1},{"Price":96,"ProductId":"e93da615-a92a-44c4-b617-4615d300d0b5","ProductName":"8848新款迷彩双肩包 DYBN0013-D002-8","Unit":"迷彩","Score":null,"ImageUrl":"/Images/Editor/35b0cda701944a09843164bcd4892842_640_640.jpeg","Quantity":1}]
     * ReceiptAddress : null
     * ReceiptRegionId : null
     * Remark : null
     * Sum : 0
     * StatusText : 已创建
     * Status : Created
     * Amount : 0
     */

    private String Id;
    private int BalanceAmount;
    private Object Consignee;
    private String CreateDateTime;
    private String CustomerId;
    private int Discount;
    private int CouponDiscount;
    private String CouponTitle;
    private int Freight;
    private Object OrderDate;
    private Object Serial;
    private Object Invoice;
    private Object ReceiptAddress;
    private Object ReceiptRegionId;
    private Object Remark;
    private int Sum;
    private String StatusText;
    private String Status;
    private int Amount;
    private List<OrderDetailsBean> OrderDetails;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getBalanceAmount() {
        return BalanceAmount;
    }

    public void setBalanceAmount(int BalanceAmount) {
        this.BalanceAmount = BalanceAmount;
    }

    public Object getConsignee() {
        return Consignee;
    }

    public void setConsignee(Object Consignee) {
        this.Consignee = Consignee;
    }

    public String getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(String CreateDateTime) {
        this.CreateDateTime = CreateDateTime;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    public int getCouponDiscount() {
        return CouponDiscount;
    }

    public void setCouponDiscount(int CouponDiscount) {
        this.CouponDiscount = CouponDiscount;
    }

    public String getCouponTitle() {
        return CouponTitle;
    }

    public void setCouponTitle(String CouponTitle) {
        this.CouponTitle = CouponTitle;
    }

    public int getFreight() {
        return Freight;
    }

    public void setFreight(int Freight) {
        this.Freight = Freight;
    }

    public Object getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Object OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Object getSerial() {
        return Serial;
    }

    public void setSerial(Object Serial) {
        this.Serial = Serial;
    }

    public Object getInvoice() {
        return Invoice;
    }

    public void setInvoice(Object Invoice) {
        this.Invoice = Invoice;
    }

    public Object getReceiptAddress() {
        return ReceiptAddress;
    }

    public void setReceiptAddress(Object ReceiptAddress) {
        this.ReceiptAddress = ReceiptAddress;
    }

    public Object getReceiptRegionId() {
        return ReceiptRegionId;
    }

    public void setReceiptRegionId(Object ReceiptRegionId) {
        this.ReceiptRegionId = ReceiptRegionId;
    }

    public Object getRemark() {
        return Remark;
    }

    public void setRemark(Object Remark) {
        this.Remark = Remark;
    }

    public int getSum() {
        return Sum;
    }

    public void setSum(int Sum) {
        this.Sum = Sum;
    }

    public String getStatusText() {
        return StatusText;
    }

    public void setStatusText(String StatusText) {
        this.StatusText = StatusText;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public List<OrderDetailsBean> getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetails(List<OrderDetailsBean> OrderDetails) {
        this.OrderDetails = OrderDetails;
    }

    public static class OrderDetailsBean {
        /**
         * Price : 34
         * ProductId : 205338e7-33de-46aa-ad79-4ac56dfdc9ef
         * ProductName : 合禾果枇杷蜜
         * Unit : 300g
         * Score : null
         * ImageUrl : /Images/Editor/96a34cac654f47e9acb46c4ca0ca169a_360_360.jpeg
         * Quantity : 22
         */

        private int Price;
        private String ProductId;
        private String ProductName;
        private String Unit;
        private Object Score;
        private String ImageUrl;
        private int Quantity;

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public String getProductId() {
            return ProductId;
        }

        public void setProductId(String ProductId) {
            this.ProductId = ProductId;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public Object getScore() {
            return Score;
        }

        public void setScore(Object Score) {
            this.Score = Score;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void setQuantity(int Quantity) {
            this.Quantity = Quantity;
        }
    }
}
