package com.example.demo.controller.api;

import com.example.demo.model.Materials;
import com.example.demo.model.PreciousStones;
import com.example.demo.service.materials.impls.MaterialsServiceImpl;
import com.example.demo.service.preciousStones.impls.PreciousStonesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preciousstones")
public class PreciousStonesAPIController {
    @Autowired
    PreciousStonesServiceImpl service;

    @RequestMapping("/get/list")
    List<PreciousStones> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    PreciousStones get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    PreciousStones delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    PreciousStones create(@RequestBody PreciousStones preciousStones){
        return service.save(preciousStones);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    PreciousStones edit(@RequestBody PreciousStones preciousStones){
        return service.edit(preciousStones);
    }
}
