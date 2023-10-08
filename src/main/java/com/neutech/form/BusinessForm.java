package com.neutech.form;

import com.neutech.enumeration.BusinessStoreStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

public class BusinessForm {

    private Integer id;
    private String username;
    private String password;
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
    private BusinessStoreStatusEnum storeStatus;

    public BusinessForm() {
    }

    @Override
    public String toString() {
        return "BusinessForm{" +
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
                ", storeRemarks='" + storeRemarks + '\'' +
                ", storeStatus=" + storeStatus +
                '}';
    }

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

    public void setStoreRemarks(String storeRemarks) {
        this.storeRemarks = storeRemarks;
    }

    public BusinessStoreStatusEnum getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(BusinessStoreStatusEnum storeStatus) {
        this.storeStatus = storeStatus;
    }
}
