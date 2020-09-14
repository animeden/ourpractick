package com.example.demo.controller.api;

import com.example.demo.model.Products;
import com.example.demo.model.Sales;
import com.example.demo.service.products.impls.ProductServiceImpl;
import com.example.demo.service.sales.impls.SalesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesAPIController {
    @Autowired
    SalesServiceImpl service;

    @RequestMapping("/get/list")
    List<Sales> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Sales get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Sales delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Sales create(@RequestBody Sales sales){
        return service.save(sales);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Sales edit(@RequestBody Sales sales){
        return service.edit(sales);
    }


}
