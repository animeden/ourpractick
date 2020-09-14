package com.example.demo.dao.repository;

import com.example.demo.model.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesRepository extends MongoRepository<Sales, String> {
}
