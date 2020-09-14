package com.example.demo.dao.repository;

import com.example.demo.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomersRepository extends MongoRepository<Customers, String> {
}
