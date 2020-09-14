package com.example.demo.dao.repository;

import com.example.demo.model.Materials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialsRepository extends MongoRepository<Materials, String> {
}
