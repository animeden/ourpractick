package com.example.demo.service.customers.impls;

import com.example.demo.dao.repository.CustomersRepository;
import com.example.demo.model.Customers;
import com.example.demo.service.customers.interfaces.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersServiceImpl implements ICustomersService {
    @Autowired
    CustomersRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Customers save(Customers customers) {
        customers.setCreate(LocalDateTime.now());
        customers.setModified(LocalDateTime.now());
        return repository.save(customers);
    }

    @Override
    public Customers get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customers> getall() {
        return repository.findAll();
    }

    @Override
    public Customers edit(Customers customers) {
        customers.setModified(LocalDateTime.now());
        return repository.save(customers);
    }

    @Override
    public Customers delete(String id) {
        Customers customers = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return customers;
    }

    public List<Customers> search(String word){
        List<Customers> list = this.getall().stream()
                .filter(customers -> customers.getName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Customers> sortByName(List<Customers> people){

        Collections.sort(people, new CustomersNameComparator());

        return people;
    }

    private class CustomersNameComparator implements Comparator<Customers> {
        public int compare(Customers p1, Customers p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
