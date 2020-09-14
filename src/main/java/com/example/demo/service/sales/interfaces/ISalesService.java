package com.example.demo.service.sales.interfaces;

import com.example.demo.model.Sales;

import java.util.List;

public interface ISalesService {
    Sales save(Sales sales);
    Sales get(String id);
    List<Sales> getall();
    Sales edit(Sales sales);
    Sales delete(String id);
}
