package com.example.demo.service.materials.interfaces;

import com.example.demo.model.Materials;

import java.util.List;

public interface IMaterialsService {
    Materials save(Materials materials);
    Materials get(String id);
    List<Materials> getall();
    Materials edit(Materials materials);
    Materials delete(String id);
}
