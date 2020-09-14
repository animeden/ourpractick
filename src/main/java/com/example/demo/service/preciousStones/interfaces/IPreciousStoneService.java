package com.example.demo.service.preciousStones.interfaces;

import com.example.demo.model.PreciousStones;

import java.util.List;

public interface IPreciousStoneService {
    PreciousStones save(PreciousStones preciousStones);
    PreciousStones get(String id);
    List<PreciousStones> getall();
    PreciousStones edit(PreciousStones preciousStones);
    PreciousStones delete(String id);
}
