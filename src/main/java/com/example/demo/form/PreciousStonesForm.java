package com.example.demo.form;

import java.time.LocalDateTime;

public class PreciousStonesForm {
    private String name;
    private String mass;
    private String price;
    private String descriction;

    public PreciousStonesForm() {
    }

    public PreciousStonesForm(String name, String mass, String price, String descriction) {
        this.name = name;
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
        return "PreciousStonesForm{" +
                "name='" + name + '\'' +
                ", mass='" + mass + '\'' +
                ", price='" + price + '\'' +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
