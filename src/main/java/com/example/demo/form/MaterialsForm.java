package com.example.demo.form;

import java.time.LocalDateTime;

public class MaterialsForm {
    private String code;
    private String name;
    private String price;
    private String descriction;

    public MaterialsForm() {
    }

    public MaterialsForm(String code, String name, String price, String descriction) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.descriction = descriction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "MaterialsForm{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
