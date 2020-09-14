package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class PreciousStones {
    @Id
    private String id;
    private String name;
    private String mass;
    private String price;
    private LocalDateTime create;
    private LocalDateTime modified;
    private String descriction;

    public PreciousStones() {
    }

    public PreciousStones(String id, String name, String mass, String price, LocalDateTime create, LocalDateTime modified, String descriction) {
        this.id = id;
        this.name = name;
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
        PreciousStones that = (PreciousStones) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "PreciousStones{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mass='" + mass + '\'' +
                ", price='" + price + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", descriction='" + descriction + '\'' +
                '}';
    }
}
