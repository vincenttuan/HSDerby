package com.web.mvc.entity;

public class ProductCode {
    
    private String prodCode;
    private String discountCode;
    private String description;

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    // 給下拉選單使用
    public String getLabel() {
        return prodCode + " : " + discountCode + " : " + description;
    }
    
    
}
