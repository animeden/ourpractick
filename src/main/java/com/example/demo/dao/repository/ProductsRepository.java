package com.example.demo.dao.repository;

import com.example.demo.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Products, String> {
}
