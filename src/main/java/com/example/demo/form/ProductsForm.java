package com.example.demo.form;

import com.example.demo.model.Materials;
import com.example.demo.model.PreciousStones;

import java.time.LocalDateTime;

public class ProductsForm {
    private String name;
    private String materialCode;
    private String preciousStoneName;
    private String mass;
    private String price;
    private String descriction;

    public ProductsForm() {
    }

    public ProductsForm(String name, String materialCode, String preciousStoneName, String mass, String price, String descriction) {
        this.name = name;
        this.materialCode = materialCode;
        this.preciousStoneName = preciousStoneName;
        this.mass = mass;
        this.price = price;
        this.descriction = descriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getPreciousStoneName() {
        return preciousStoneName;
    }

    public void setPreciousStoneName(String preciousStoneName) {
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

    public String getDescriction() {
        return descriction;
    }

    public void setDescriction(String descriction) {
        this.descriction = descriction;
    }

    @Override
    public String toString() {
        return "ProductsForm{" +
                "name='" + name + '\'' +
                ", materialCode=" + materialCode +
                ", preciousStoneName=" + preciousStoneName +
                ", mass='" + mass + '\'' +
                ", price='" + price + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
