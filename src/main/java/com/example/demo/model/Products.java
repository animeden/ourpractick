package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Products {
    @Id
    private String id;
    private String name;
    private Materials materialCode;
    private PreciousStones preciousStoneName;
    private String mass;
    private String price;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public Products() {
    }

    public Products(String id, String name, Materials materialCode, PreciousStones preciousStoneName, String mass, String price, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.name = name;
        this.materialCode = materialCode;
        this.preciousStoneName = preciousStoneName;
        this.mass = mass;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Materials getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(Materials materialCode) {
        this.materialCode = materialCode;
    }

    public PreciousStones getPreciousStoneName() {
        return preciousStoneName;
    }

    public void setPreciousStoneName(PreciousStones preciousStoneName) {
        this.preciousStoneName = preciousStoneName;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        Products products = (Products) o;
        return getId().equals(products.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Products{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", materialCode=" + materialCode +
                ", preciousStoneName=" + preciousStoneName +
                ", mass='" + mass + '\'' +
                ", price='" + price + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
