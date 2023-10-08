package com.neutech.entity;

import javafx.scene.chart.PieChart;

import java.math.BigDecimal;
import java.util.Date;

public class Business {

    private Integer id;
    private String username;
    private  String password;
    private String phone;
    private String email;
    private String storeName;
    private String storeAddress;
    private String storeBrief;
    private String mainImage;
    private Integer orderType;
    private BigDecimal startPrice;
    private BigDecimal deliveryPrice;
    private String storeRemarks;
    private int storeStatus;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreBrief() {
        return storeBrief;
    }

    public void setStoreBrief(String storeBrief) {
        this.storeBrief = storeBrief;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getStoreRemarks() {
        return storeRemarks;
    }

    public void setStoreRemarks(String store_Remarks) {
        this.storeRemarks = store_Remarks;
    }

    public int getStore_Status() {
        return storeStatus;
    }

    public void setStore_Status(int store_Status) {
        this.storeStatus = store_Status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeBrief='" + storeBrief + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", orderType=" + orderType +
                ", startPrice=" + startPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", store_Remarks='" + storeRemarks + '\'' +
                ", store_Status=" + storeStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
