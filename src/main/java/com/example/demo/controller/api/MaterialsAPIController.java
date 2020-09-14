package com.example.demo.controller.api;

import com.example.demo.model.Customers;
import com.example.demo.model.Materials;
import com.example.demo.service.customers.impls.CustomersServiceImpl;
import com.example.demo.service.materials.impls.MaterialsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialsAPIController {
    @Autowired
    MaterialsServiceImpl service;

    @RequestMapping("/get/list")
    List<Materials> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Materials get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Materials delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Materials create(@RequestBody Materials materials){
        return service.save(materials);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Materials edit(@RequestBody Materials materials){
        return service.edit(materials);
    }
}
