package com.example.demo.service.preciousStones.impls;

import com.example.demo.dao.repository.PreciousStonesRepository;
import com.example.demo.model.PreciousStones;
import com.example.demo.service.materials.interfaces.IMaterialsService;
import com.example.demo.service.preciousStones.interfaces.IPreciousStoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreciousStonesServiceImpl implements IPreciousStoneService {
    @Autowired
    PreciousStonesRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public PreciousStones save(PreciousStones preciousStones) {
        preciousStones.setCreate(LocalDateTime.now());
        preciousStones.setModified(LocalDateTime.now());
        return repository.save(preciousStones);
    }

    @Override
    public PreciousStones get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PreciousStones> getall() {
        return repository.findAll();
    }

    @Override
    public PreciousStones edit(PreciousStones preciousStones) {
        preciousStones.setModified(LocalDateTime.now());
        return repository.save(preciousStones);
    }

    @Override
    public PreciousStones delete(String id) {
        PreciousStones preciousStones = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return preciousStones;
    }

    public List<PreciousStones> search(String word){
        List<PreciousStones> list = this.getall().stream()
                .filter(preciousStones -> preciousStones.getName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<PreciousStones> sortByName(List<PreciousStones> people){

        Collections.sort(people, new PreciousStonesNameComparator());

        return people;
    }

    private class PreciousStonesNameComparator implements Comparator<PreciousStones> {
        public int compare(PreciousStones p1, PreciousStones p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
