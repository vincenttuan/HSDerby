package com.web.mvc.entity;


public class DiscountCode {
    
    private String discountCode;
    
    private Double rate;

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "DiscountCode{" + "discountCode=" + discountCode + ", rate=" + rate + '}';
    }
    
    // 給下拉選單使用
    public String getLabel() {
        return discountCode + " : " + rate + " " + ((rate > 10)?"大特價":"");
    }
}
