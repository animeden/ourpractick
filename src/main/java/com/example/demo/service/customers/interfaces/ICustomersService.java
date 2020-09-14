package com.example.demo.service.customers.interfaces;

import com.example.demo.model.Customers;

import java.util.List;

public interface ICustomersService {
    Customers save(Customers customers);
    Customers get(String id);
    List<Customers> getall();
    Customers edit(Customers customers);
    Customers delete(String id);
}
