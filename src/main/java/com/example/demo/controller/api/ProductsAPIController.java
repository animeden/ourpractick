package com.example.demo.controller.api;

import com.example.demo.model.PreciousStones;
import com.example.demo.model.Products;
import com.example.demo.service.preciousStones.impls.PreciousStonesServiceImpl;
import com.example.demo.service.products.impls.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsAPIController {
    @Autowired
    ProductServiceImpl service;

    @RequestMapping("/get/list")
    List<Products> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Products get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Products delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Products create(@RequestBody Products products){
        return service.save(products);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Products edit(@RequestBody Products products){
        return service.edit(products);
    }

}
