package com.example.demo.form;

import com.example.demo.model.Customers;
import com.example.demo.model.Products;

import java.time.LocalDateTime;

public class SalesForm {
    private String id;
    private String productId;
    private String date;
    private String fullName;
    private String descriction;

    public SalesForm() {
    }

    public SalesForm(String id, String productId, String date, String fullName, String descriction) {
        this.id = id;
        this.productId = productId;
        this.date = date;
        this.fullName = fullName;
        this.descriction = descriction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "SalesForm{" +
                "id='" + id + '\'' +
                ", productId=" + productId +
                ", date='" + date + '\'' +
                ", fullName=" + fullName +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
