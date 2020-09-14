package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Sales {
    @Id
    private String id;
    private Products productId;
    private String date;
    private Customers fullName;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Sales() {
    }

    public Sales(String id, Products productId, String date, Customers fullName, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.productId = productId;
        this.date = date;
        this.fullName = fullName;
        this.create = create;
        this.modified = modified;
        this.descriction = descriction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customers getFullName() {
        return fullName;
    }

    public void setFullName(Customers fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return getId().equals(sales.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id='" + id + '\'' +
                ", productId=" + productId +
                ", date='" + date + '\'' +
                ", fullName=" + fullName +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
