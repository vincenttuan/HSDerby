package com.web.mvc.entity;

public class Customer {
    private Integer customerId;
    private String discountCode;
    private String zip;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String phone;
    private String fax;
    private String email;
    private Integer creditLimit;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            this.name = new String(name.getBytes("iso-8859-1"),"utf-8");
        } catch (Exception e) {
        }
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        try {
            this.addressLine1 = new String(addressLine1.getBytes("iso-8859-1"),"utf-8");
        } catch (Exception e) {
        }
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        try {
            this.addressLine2 = new String(addressLine2.getBytes("iso-8859-1"),"utf-8");
        } catch (Exception e) {
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", discountCode=" + discountCode + ", zip=" + zip + ", name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", phone=" + phone + ", fax=" + fax + ", email=" + email + ", creditLimit=" + creditLimit + '}';
    }

    
}
