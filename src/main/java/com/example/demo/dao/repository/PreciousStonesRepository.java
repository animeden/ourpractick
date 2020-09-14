package com.example.demo.dao.repository;

import com.example.demo.model.PreciousStones;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PreciousStonesRepository extends MongoRepository<PreciousStones, String> {
}
