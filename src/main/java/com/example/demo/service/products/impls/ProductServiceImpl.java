package com.example.demo.service.products.impls;

import com.example.demo.dao.repository.ProductsRepository;
import com.example.demo.model.Products;
import com.example.demo.service.products.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductsRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Products save(Products products) {
        products.setCreate(LocalDateTime.now());
        products.setModified(LocalDateTime.now());
        return repository.save(products);
    }

    @Override
    public Products get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Products> getall() {
        return repository.findAll();
    }

    @Override
    public Products edit(Products products) {
        products.setModified(LocalDateTime.now());
        return repository.save(products);
    }

    @Override
    public Products delete(String id) {
        Products products = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return products;
    }

    public List<Products> search(String word){
        List<Products> list = this.getall().stream()
                .filter(products -> products.getName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Products> sortByName(List<Products> people){

        Collections.sort(people, new ProductsNameComparator());

        return people;
    }

    private class ProductsNameComparator implements Comparator<Products> {
        public int compare(Products p1, Products p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
