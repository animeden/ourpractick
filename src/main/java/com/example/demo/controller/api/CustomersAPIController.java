package com.example.demo.controller.api;

import com.example.demo.model.Customers;
import com.example.demo.service.customers.impls.CustomersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersAPIController {
    @Autowired
    CustomersServiceImpl service;

    @RequestMapping("/get/list")
    List<Customers> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Customers get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Customers delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Customers create(@RequestBody Customers customers){
        return service.save(customers);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Customers edit(@RequestBody Customers customers){
        return service.edit(customers);
    }
}
