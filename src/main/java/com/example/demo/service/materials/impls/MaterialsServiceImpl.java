package com.example.demo.service.materials.impls;

import com.example.demo.dao.repository.MaterialsRepository;
import com.example.demo.model.Materials;
import com.example.demo.service.materials.interfaces.IMaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialsServiceImpl implements IMaterialsService {
    @Autowired
    MaterialsRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Materials save(Materials materials) {
        materials.setCreate(LocalDateTime.now());
        materials.setModified(LocalDateTime.now());
        return repository.save(materials);
    }

    @Override
    public Materials get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Materials> getall() {
        return repository.findAll();
    }

    @Override
    public Materials edit(Materials materials) {
        materials.setModified(LocalDateTime.now());
        return repository.save(materials);
    }

    @Override
    public Materials delete(String id) {
        Materials materials = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return materials;
    }

    public List<Materials> search(String word){
        List<Materials> list = this.getall().stream()
                .filter(materials -> materials.getCode().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Materials> sortByName(List<Materials> people){

        Collections.sort(people, new MaterialsNameComparator());

        return people;
    }

    private class MaterialsNameComparator implements Comparator<Materials> {
        public int compare(Materials p1, Materials p2) {
            return p1.getCode().compareTo(p2.getCode());
        }
    }
}
