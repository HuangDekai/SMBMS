package com.huangdekai.JavaWeb.SMBMS.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/7 1:14
 * @Version: 1.0
 * @since: jdk11
 */
public class Bill {
    private Integer id;         // ID
    private String billCode;    // 账单编码
    private String productName; // 商品名称
    private String productDesc; // 商品简介
    private String productUnit; // 商品单位
    private BigDecimal productCount;    // 商品数量
    private BigDecimal totalPrice;      // 总金额
    private Integer isPayment;  // 是否支付
    private Integer createdBy;  // 创建者Id
    private Date creationDate;       // 创建日期
    private Integer modifyBy;   // 修改者Id
    private Date modifyDate;    // 修改日期

    private String providerName;    //供应商名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public BigDecimal getProductCount() {
        return productCount;
    }

    public void setProductCount(BigDecimal productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Integer isPayment) {
        this.isPayment = isPayment;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
