package com.example.demo.service.sales.impls;

import com.example.demo.dao.repository.SalesRepository;
import com.example.demo.model.Sales;
import com.example.demo.service.sales.interfaces.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements ISalesService {
    @Autowired
    SalesRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Sales save(Sales sales) {
        sales.setCreate(LocalDateTime.now());
        sales.setModified(LocalDateTime.now());
        return repository.save(sales);
    }

    @Override
    public Sales get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Sales> getall() {
        return repository.findAll();
    }

    @Override
    public Sales edit(Sales sales) {
        sales.setModified(LocalDateTime.now());
        return repository.save(sales);
    }

    @Override
    public Sales delete(String id) {
        Sales sales = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return sales;
    }

    public List<Sales> search(String word){
        List<Sales> list = this.getall().stream()
                .filter(sales -> sales.getId().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Sales> sortByName(List<Sales> people){

        Collections.sort(people, new SalesNameComparator());

        return people;
    }

    private class SalesNameComparator implements Comparator<Sales> {
        public int compare(Sales p1, Sales p2) {
            return p1.getId().compareTo(p2.getId());
        }
    }
}
