package com.example.demo.service.products.interfaces;

import com.example.demo.model.Products;

import java.util.List;

public interface IProductService {
    Products save(Products products);
    Products get(String id);
    List<Products> getall();
    Products edit(Products products);
    Products delete(String id);
}
